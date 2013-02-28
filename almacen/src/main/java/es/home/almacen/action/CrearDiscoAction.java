/**
 * 
 */
package es.home.almacen.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.actions.DispatchAction;
import org.apache.struts.util.LabelValueBean;

import es.home.almacen.bean.Disco;
import es.home.almacen.bean.Grupo;
import es.home.almacen.business.DiscoBO;
import es.home.almacen.business.GrupoBO;
import es.home.almacen.form.CrearDiscoForm;
import es.home.almacen.util.Constante;

/**
 * @author dsblanco
 * 
 */
public class CrearDiscoAction extends DispatchAction {

    private final static Logger LOGGER = Logger.getLogger(CrearDiscoAction.class);

    private DiscoBO discoBus;
    private GrupoBO grupoBus;

    public CrearDiscoAction() {
	super();
    }

    public DiscoBO getDiscoBus() {
	return discoBus;
    }

    private Disco getDiscoDto(final CrearDiscoForm cdForm) {
	Disco bean = new Disco();
	Grupo grupo = new Grupo();
	grupo.setIdgrupo(cdForm.getIdgrupo());
	bean.setGrupo(grupo);
	bean.setNombre(cdForm.getNombre());
	bean.setAnyo(cdForm.getAnyo());
	bean.setProductor(cdForm.getProductor());
	bean.setSello(cdForm.getSello());
	return bean;
    }

    /**
     * @return the grupoBus
     */
    public GrupoBO getGrupoBus() {
	return grupoBus;
    }

    /**
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward nuevo(final ActionMapping mapping, final ActionForm form, final HttpServletRequest request, final HttpServletResponse response) throws Exception {
	String forward = Constante.FW_PASO1;
	LOGGER.debug("Inicio CrearGrupoAction - nuevo");
	ActionErrors errors = new ActionErrors();
	try {
	    List<LabelValueBean> lista = new ArrayList<LabelValueBean>();

	    List<Grupo> listaGrupos = grupoBus.buscarGrupo(null);
	    if (!listaGrupos.isEmpty()) {
		for (Grupo grupo : listaGrupos) {
		    lista.add(new LabelValueBean(grupo.getNombre(), Integer.toString(grupo.getIdgrupo())));
		}
	    }
	    ((CrearDiscoForm) form).setGrupos(lista);

	} catch (Exception except) {
	    LOGGER.error("Error al ejecutar el action", except);
	    forward = Constante.FW_ERROR_FATAL;
	    ActionMessage error = new ActionMessage(Constante.KEY_KO_ACTION);
	    errors.add(Constante.MSG_KO, error);
	    saveErrors(request, errors);
	}

	LOGGER.debug("End CrearGrupoAction - nuevo");
	return mapping.findForward(forward);
    }

    public ActionForward save(final ActionMapping mapping, final ActionForm form, final HttpServletRequest request, final HttpServletResponse response) throws Exception {
	String forward = Constante.FW_PASO2;
	LOGGER.debug("Inicio CrearGrupoAction - save");
	ActionErrors errors = new ActionErrors();
	ActionMessages messages = new ActionMessages();
	try {
	    CrearDiscoForm cdForm = (CrearDiscoForm) form;
	    Disco bean = getDiscoDto(cdForm);
	    bean = discoBus.crearDisco(bean, true);
	    if (bean == null) {
		// Ha ocurrido un error
		ActionMessage error = new ActionMessage(Constante.KEY_KO_ACTION);
		errors.add(Constante.MSG_KO, error);
		saveErrors(request, errors);
	    } else {
		ActionMessage mensaje = new ActionMessage(Constante.KEY_OK_ACTION);
		messages.add(Constante.MSG_OK, mensaje);
		saveMessages(request, messages);
	    }
	} catch (Exception except) {
	    LOGGER.error("Error al ejecutar el action", except);
	    forward = Constante.FW_ERROR_FATAL;
	    ActionMessage error = new ActionMessage(Constante.KEY_KO_ACTION);
	    errors.add(Constante.MSG_KO, error);
	    saveErrors(request, errors);
	}

	LOGGER.debug("End CrearGrupoAction - save");
	return mapping.findForward(forward);
    }

    public void setDiscoBus(final DiscoBO discoBus) {
	this.discoBus = discoBus;
    }

    public void setGrupoBus(final GrupoBO grupoBus) {
	this.grupoBus = grupoBus;
    }
}
