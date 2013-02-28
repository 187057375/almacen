/**
 * 
 */
package es.home.almacen.action;

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

import es.home.almacen.bean.Componente;
import es.home.almacen.business.ComponenteBO;
import es.home.almacen.form.VerComponenteForm;
import es.home.almacen.util.Constante;

/**
 * @author dsblanco
 * 
 */
public class ModificarComponenteAction extends DispatchAction {

    private final static Logger LOGGER = Logger.getLogger(ModificarComponenteAction.class);

    private ComponenteBO componenteBO;

    public ModificarComponenteAction() {
	super();
    }

    public ActionForward Editar(final ActionMapping mapping, final ActionForm form, final HttpServletRequest request, final HttpServletResponse response)
    throws Exception {
	String forward = Constante.FW_PASO1;
	LOGGER.debug("Inicio ModificarComponenteAction - Editar");
	try {
	    VerComponenteForm vlForm = (VerComponenteForm) form;
	    Integer idcomponente = vlForm.getIdcomponente();
	    Componente grupo = null;
	    if (idcomponente == null || idcomponente.intValue() == 0) {
		ActionErrors errors = new ActionErrors();
		ActionMessage error = new ActionMessage(Constante.KEY_KO_IDGRUPO);
		errors.add(Constante.MSG_KO, error);
		saveErrors(request, errors);
	    } else {
		grupo = componenteBO.obtenerComponente(idcomponente);
	    }

	    if (grupo == null) {
		// Ha ocurrido un error
		ActionErrors errors = new ActionErrors();
		ActionMessage error = new ActionMessage(Constante.KEY_KO_ACTION);
		errors.add(Constante.MSG_KO, error);
		saveErrors(request, errors);
	    } else {
		vlForm.setComponente(grupo);
	    }
	} catch (Exception except) {
	    LOGGER.error("Error al ejecutar el action", except);
	    forward = Constante.FW_ERROR_FATAL;
	}
	LOGGER.debug("End ModificarComponenteAction - Editar");
	return mapping.findForward(forward);
    }

    public ActionForward Eliminar(final ActionMapping mapping, final ActionForm form, final HttpServletRequest request, final HttpServletResponse response)
    throws Exception {
	String forward = Constante.FW_PASO2;
	LOGGER.debug("Inicio ModificarComponenteAction - Eliminar");
	ActionErrors errors = new ActionErrors();
	ActionMessages messages = new ActionMessages();
	VerComponenteForm vForm = (VerComponenteForm) form;
	try {

	    int idcancion = vForm.getIdcomponente();
	    boolean correcto = componenteBO.eliminar(idcancion);
	    if (correcto) {
		ActionMessage mensaje = new ActionMessage(Constante.KEY_OK_ACTION);
		messages.add(Constante.MSG_OK, mensaje);
		saveMessages(request, messages);
	    } else {
		ActionMessage error = new ActionMessage(Constante.KEY_KO_ACTION);
		errors.add(Constante.MSG_KO, error);
		saveErrors(request, errors);
	    }
	} catch (Exception except) {
	    LOGGER.error("Error al ejecutar el action", except);
	    forward = Constante.FW_ERROR_FATAL;
	    ActionMessage error = new ActionMessage(Constante.KEY_KO_ACTION);
	    errors.add(Constante.MSG_KO, error);
	    saveErrors(request, errors);
	}

	LOGGER.debug("End ModificarComponenteAction - Eliminar");
	return mapping.findForward(forward);
    }

    public ComponenteBO getComponenteBO() {
	return componenteBO;
    }

    private Componente getComponenteDto(final VerComponenteForm vgForm) {
	Componente bean = new Componente();
	bean.setNombre(vgForm.getComponente().getNombre());
	bean.setIdcomponente(vgForm.getIdcomponente());
	return bean;
    }

    public ActionForward Guardar(final ActionMapping mapping, final ActionForm form, final HttpServletRequest request, final HttpServletResponse response)
    throws Exception {
	String forward = Constante.FW_PASO2;
	LOGGER.debug("Inicio ModificarComponenteAction - Guardar");
	ActionErrors errors = new ActionErrors();
	ActionMessages messages = new ActionMessages();
	try {
	    VerComponenteForm clForm = (VerComponenteForm) form;
	    Componente bean = getComponenteDto(clForm);
	    bean = componenteBO.crearComponente(bean, false);
	    if (bean == null) {
		// Ha ocurrido un error
		ActionMessage error = new ActionMessage(Constante.KEY_KO_ACTION);
		errors.add(Constante.MSG_KO, error);
		saveErrors(request, errors);
	    }
	    ActionMessage mensaje = new ActionMessage(Constante.KEY_OK_ACTION);
	    messages.add(Constante.MSG_OK, mensaje);
	    saveMessages(request, messages);
	} catch (Exception except) {
	    LOGGER.error("Error al ejecutar el action", except);
	    forward = Constante.FW_ERROR_FATAL;
	    ActionMessage error = new ActionMessage(Constante.KEY_KO_ACTION);
	    errors.add(Constante.MSG_KO, error);
	    saveErrors(request, errors);
	}

	LOGGER.debug("End ModificarComponenteAction - Guardar");
	return mapping.findForward(forward);
    }

    public void setComponenteBO(final ComponenteBO componenteBO) {
	this.componenteBO = componenteBO;
    }
}
