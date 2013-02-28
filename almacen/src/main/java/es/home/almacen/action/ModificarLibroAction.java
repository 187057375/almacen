/**
 * 
 */
package es.home.almacen.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.actions.LookupDispatchAction;

import es.home.almacen.bean.Libro;
import es.home.almacen.business.LibroBO;
import es.home.almacen.form.VerLibroForm;
import es.home.almacen.util.Constante;

/**
 * @author dsblanco
 * 
 */
public class ModificarLibroAction extends LookupDispatchAction {

    private final static Logger LOGGER = Logger.getLogger(ModificarLibroAction.class);

    private LibroBO libroBO;

    public ModificarLibroAction() {
	super();
    }

    public ActionForward aceptar(final ActionMapping mapping, final ActionForm form, final HttpServletRequest request, final HttpServletResponse response)
    throws Exception {
	String forward = Constante.FW_PASO2;
	LOGGER.debug("Inicio ModificarCancionAction - Eliminar");
	ActionErrors errors = new ActionErrors();
	ActionMessages messages = new ActionMessages();
	VerLibroForm vForm = (VerLibroForm) form;
	try {

	    int idcancion = vForm.getIdlibro();
	    boolean correcto = libroBO.eliminar(idcancion);
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

    public ActionForward atras(final ActionMapping mapping, final ActionForm form, final HttpServletRequest request, final HttpServletResponse response)
    throws Exception {
	String forward = Constante.FW_ATRAS;
	LOGGER.debug("Inicio ModificarCancionAction - atras");
	LOGGER.debug("End ModificarCancionAction - atras");
	return mapping.findForward(forward);
    }

    public ActionForward cancelar(final ActionMapping mapping, final ActionForm form, final HttpServletRequest request, final HttpServletResponse response)
    throws Exception {
	String forward = Constante.FW_PASO1;
	LOGGER.debug("Inicio ModificarCancionAction - cancelar");
	VerLibroForm vForm = (VerLibroForm) form;
	vForm.setConfirmar(false);
	LOGGER.debug("End ModificarCancionAction - cancelar");
	return mapping.findForward(forward);
    }

    public ActionForward editar(final ActionMapping mapping, final ActionForm form, final HttpServletRequest request, final HttpServletResponse response)
    throws Exception {
	String forward = Constante.FW_PASO1;
	LOGGER.debug("Inicio ModificarCancionAction - Editar");
	try {
	    VerLibroForm vlForm = (VerLibroForm) form;
	    vlForm.setHabilitado(true);
	} catch (Exception except) {
	    LOGGER.error("Error al ejecutar el action", except);
	    forward = Constante.FW_ERROR_FATAL;
	}
	LOGGER.debug("End ModificarCancionAction - Editar");
	return mapping.findForward(forward);
    }

    public ActionForward eliminar(final ActionMapping mapping, final ActionForm form, final HttpServletRequest request, final HttpServletResponse response)
    throws Exception {
	String forward = Constante.FW_PASO1;
	LOGGER.debug("Inicio ModificarCancionAction - Eliminar");
	VerLibroForm vForm = (VerLibroForm) form;
	vForm.setConfirmar(true);
	LOGGER.debug("End ModificarCancionAction - Eliminar");
	return mapping.findForward(forward);
    }

    @Override
    protected Map<String, String> getKeyMethodMap() {
	Map<String, String> map = new HashMap<String, String>();
	map.put("general.guardar", "guardar");
	map.put("general.editar", "editar");
	map.put("general.eliminar", "eliminar");
	map.put("general.aceptar", "aceptar");
	map.put("general.cancelar", "cancelar");
	map.put("general.atras", "atras");
	return map;
    }

    Libro getLibro(final VerLibroForm vlForm) {
	Libro bean = vlForm.getLibro();
	bean.setIdlibro(vlForm.getIdlibro());
	return bean;

    }

    public LibroBO getLibroBO() {
	return libroBO;
    }

    public ActionForward guardar(final ActionMapping mapping, final ActionForm form, final HttpServletRequest request, final HttpServletResponse response)
    throws Exception {
	String forward = Constante.FW_PASO2;
	LOGGER.debug("Inicio ModificarCancionAction - Guardar");
	ActionErrors errors = new ActionErrors();
	ActionMessages messages = new ActionMessages();
	try {
	    VerLibroForm clForm = (VerLibroForm) form;
	    Libro bean = libroBO.crearLibro(getLibro(clForm), false);
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

    public void setLibroBO(final LibroBO libroBO) {
	this.libroBO = libroBO;
    }
}
