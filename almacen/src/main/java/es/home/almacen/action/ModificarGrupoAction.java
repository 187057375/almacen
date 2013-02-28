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

import es.home.almacen.bean.Grupo;
import es.home.almacen.business.GrupoBO;
import es.home.almacen.form.VerGrupoForm;
import es.home.almacen.util.Constante;

/**
 * @author dsblanco
 * 
 */
public class ModificarGrupoAction extends DispatchAction {

    private final static Logger LOGGER = Logger.getLogger(ModificarGrupoAction.class);

    private GrupoBO grupoBO;

    public ModificarGrupoAction() {
	super();
    }

    public ActionForward Editar(final ActionMapping mapping, final ActionForm form, final HttpServletRequest request, final HttpServletResponse response)
    throws Exception {
	String forward = Constante.FW_PASO1;
	LOGGER.debug("Inicio ModificarCancionAction - Editar");
	try {
	    VerGrupoForm vlForm = (VerGrupoForm) form;
	    Integer idgrupo = vlForm.getIdgrupo();
	    Grupo grupo = null;
	    if (idgrupo == null || idgrupo.intValue() == 0) {
		ActionErrors errors = new ActionErrors();
		ActionMessage error = new ActionMessage(Constante.KEY_KO_IDGRUPO);
		errors.add(Constante.MSG_KO, error);
		saveErrors(request, errors);
	    } else {
		grupo = grupoBO.obtenerGrupo(idgrupo);
	    }

	    if (grupo == null) {
		// Ha ocurrido un error
		ActionErrors errors = new ActionErrors();
		ActionMessage error = new ActionMessage(Constante.KEY_KO_ACTION);
		errors.add(Constante.MSG_KO, error);
		saveErrors(request, errors);
	    } else {
		vlForm.setGrupo(grupo);
	    }
	} catch (Exception except) {
	    LOGGER.error("Error al ejecutar el action", except);
	    forward = Constante.FW_ERROR_FATAL;
	}
	LOGGER.debug("End ModificarCancionAction - Editar");
	return mapping.findForward(forward);
    }

    public ActionForward Eliminar(final ActionMapping mapping, final ActionForm form, final HttpServletRequest request, final HttpServletResponse response)
    throws Exception {
	String forward = Constante.FW_PASO2;
	LOGGER.debug("Inicio ModificarCancionAction - Eliminar");
	ActionErrors errors = new ActionErrors();
	ActionMessages messages = new ActionMessages();
	VerGrupoForm vForm = (VerGrupoForm) form;
	try {

	    int idcancion = vForm.getIdgrupo();
	    boolean correcto = grupoBO.eliminar(idcancion);
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

	LOGGER.debug("End ModificarCancionAction - Eliminar");
	return mapping.findForward(forward);
    }

    public GrupoBO getGrupoBO() {
	return grupoBO;
    }

    private Grupo getGrupoDto(final VerGrupoForm vgForm) {
	Grupo bean = new Grupo();
	bean.setNombre(vgForm.getGrupo().getNombre());
	bean.setIdgrupo(vgForm.getIdgrupo());
	return bean;
    }

    public ActionForward Guardar(final ActionMapping mapping, final ActionForm form, final HttpServletRequest request, final HttpServletResponse response)
    throws Exception {
	String forward = Constante.FW_PASO2;
	LOGGER.debug("Inicio ModificarCancionAction - Guardar");
	ActionErrors errors = new ActionErrors();
	ActionMessages messages = new ActionMessages();
	try {
	    VerGrupoForm clForm = (VerGrupoForm) form;
	    Grupo bean = getGrupoDto(clForm);
	    bean = grupoBO.crearGrupo(bean, false);
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

	LOGGER.debug("End ModificarCancionAction - Guardar");
	return mapping.findForward(forward);
    }

    public void setGrupoBO(final GrupoBO grupoBO) {
	this.grupoBO = grupoBO;
    }
}
