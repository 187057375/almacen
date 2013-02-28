/**
 * 
 */
package es.home.almacen.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import es.home.almacen.bean.Grupo;
import es.home.almacen.business.GrupoBO;
import es.home.almacen.business.impl.GrupoBOImpl;
import es.home.almacen.form.CrearGrupoForm;
import es.home.almacen.util.Constante;

/**
 * @author dsblanco
 * 
 */
public class CrearGrupoAction extends Action {

    private final static Logger LOGGER = Logger.getLogger(CrearGrupoAction.class);

    private final GrupoBO business;

    public CrearGrupoAction() {
	super();
	business = new GrupoBOImpl();
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
    public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest request, final HttpServletResponse response) throws Exception {
	String forward = Constante.FW_SUCCESS;
	LOGGER.debug("Inicio CrearGrupoAction");
	ActionErrors errors = new ActionErrors();
	ActionMessages messages = new ActionMessages();
	try {
	    CrearGrupoForm clForm = (CrearGrupoForm) form;
	    Grupo bean = getGrupoDto(clForm);
	    bean = business.crearGrupo(bean, true);
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

	LOGGER.debug("End CrearGrupoAction");
	return mapping.findForward(forward);

    }

    private Grupo getGrupoDto(final CrearGrupoForm vgForm) {
	Grupo bean = new Grupo();
	bean.setNombre(vgForm.getNombre());
	return bean;
    }
}
