/**
 * 
 */
package es.home.almacen.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.util.LabelValueBean;

import es.home.almacen.bean.Disco;
import es.home.almacen.bean.Grupo;
import es.home.almacen.business.DiscoBO;
import es.home.almacen.business.GrupoBO;
import es.home.almacen.form.VerDiscoForm;
import es.home.almacen.util.Constante;

/**
 * @author dsblanco
 * 
 */
public class VerDiscoAction extends Action {

    private DiscoBO discoBO;
    private GrupoBO grupoBO;

    private final static Logger LOGGER = Logger.getLogger(VerDiscoAction.class);

    public VerDiscoAction() {
	super();
    }

    /*
     * (non-Javadoc)
     * 
     * @seeorg.apache.struts.action.Action#execute(org.apache.struts.action.
     * ActionMapping, org.apache.struts.action.ActionForm,
     * javax.servlet.http.HttpServletRequest,
     * javax.servlet.http.HttpServletResponse)
     */
    @Override
    public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest request, final HttpServletResponse response)
    throws Exception {
	String forward = Constante.FW_SUCCESS;
	LOGGER.debug("Inicio VerDiscoAction");
	try {
	    VerDiscoForm vdForm = (VerDiscoForm) form;
	    Integer iddisco = vdForm.getIddisco();
	    Disco disco = null;
	    if (iddisco == null || iddisco.intValue() == 0) {
		ActionErrors errors = new ActionErrors();
		ActionMessage error = new ActionMessage(Constante.KEY_KO_IDGRUPO);
		errors.add(Constante.MSG_KO, error);
		saveErrors(request, errors);
	    } else {
		disco = discoBO.obtenerDisco(iddisco);
	    }

	    if (disco == null) {
		// Ha ocurrido un error
		ActionErrors errors = new ActionErrors();
		ActionMessage error = new ActionMessage(Constante.KEY_KO_ACTION);
		errors.add(Constante.MSG_KO, error);
		saveErrors(request, errors);
	    } else {
		vdForm.setDisco(disco);
	    }

	    // Obtenemos el conjunto de grupos
	    List<LabelValueBean> lista = new ArrayList<LabelValueBean>();

	    List<Grupo> listaGrupos = grupoBO.buscarGrupo(null);
	    if (!listaGrupos.isEmpty()) {
		for (Grupo grupo : listaGrupos) {
		    lista.add(new LabelValueBean(grupo.getNombre(), Integer.toString(grupo.getIdgrupo())));
		}
	    }
	    vdForm.setGrupos(lista);
	} catch (Exception except) {
	    LOGGER.error("Error al ejecutar el action", except);
	    forward = Constante.FW_ERROR_FATAL;
	}
	LOGGER.debug("End VerDiscoAction");
	return mapping.findForward(forward);

    }

    public DiscoBO getDiscoBO() {
	return discoBO;
    }

    public GrupoBO getGrupoBO() {
	return grupoBO;
    }

    public void setDiscoBO(final DiscoBO discoBO) {
	this.discoBO = discoBO;
    }

    public void setGrupoBO(final GrupoBO grupoBO) {
	this.grupoBO = grupoBO;
    }
}
