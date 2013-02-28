/**
 * 
 */
package es.home.almacen.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import es.home.almacen.bean.Grupo;
import es.home.almacen.business.GrupoBO;
import es.home.almacen.form.BuscarGrupoForm;
import es.home.almacen.util.Constante;

/**
 * @author dsblanco
 * 
 */
public class BuscarGrupoAction extends Action {

    private final static Logger LOGGER = Logger.getLogger(BuscarGrupoAction.class);

    private GrupoBO grupoBO;

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
	LOGGER.debug("Inicio BuscarGrupoAction");
	BuscarGrupoForm bgForm = (BuscarGrupoForm) form;
	String nombre = bgForm.getNombre();
	List<Grupo> lista = grupoBO.buscarGrupo(nombre);
	bgForm.setGrupos(lista);
	LOGGER.debug("End BuscarGrupoAction");
	return mapping.findForward(Constante.FW_SUCCESS);

    }

    public GrupoBO getGrupoBO() {
	return grupoBO;
    }

    public void setGrupoBO(final GrupoBO grupoBO) {
	this.grupoBO = grupoBO;
    }
}
