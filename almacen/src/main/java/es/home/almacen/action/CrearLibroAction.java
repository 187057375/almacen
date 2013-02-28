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

import es.home.almacen.business.LibroBO;
import es.home.almacen.form.CrearLibroForm;
import es.home.almacen.util.Constante;

/**
 * @author dsblanco
 * 
 */
public class CrearLibroAction extends Action {

    private final static Logger LOGGER = Logger.getLogger(CrearLibroAction.class);

    private LibroBO business;

    public CrearLibroAction() {
	super();
    }

    @Override
    public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest request, final HttpServletResponse response) throws Exception {
	String forward = Constante.FW_SUCCESS;
	LOGGER.debug("Inicio CrearLibroAction");
	ActionErrors errors = new ActionErrors();
	ActionMessages messages = new ActionMessages();
	try {
	    CrearLibroForm clForm = (CrearLibroForm) form;
	    business.crearLibro(clForm.getLibro(), true);
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

	LOGGER.debug("End CrearLibroAction");
	return mapping.findForward(forward);

    }

    public LibroBO getBusiness() {
	return business;
    }

    public void setBusiness(final LibroBO business) {
	this.business = business;
    }
}
