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

import es.home.almacen.bean.Componente;
import es.home.almacen.business.ComponenteBO;
import es.home.almacen.form.VerComponenteForm;
import es.home.almacen.util.Constante;

/**
 * @author dsblanco
 * 
 */
public class VerComponenteAction extends Action {

    private final static Logger LOGGER = Logger.getLogger(VerComponenteAction.class);
    private ComponenteBO business;

    public VerComponenteAction() {
	super();
    }

    @Override
    public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest request, final HttpServletResponse response) throws Exception {
	String forward = Constante.FW_SUCCESS;
	LOGGER.debug("Inicio VerComponenteAction");
	try {
	    VerComponenteForm vlForm = (VerComponenteForm) form;
	    Integer idcomponente = vlForm.getIdcomponente();
	    Componente componente = null;
	    if (idcomponente == null || idcomponente.intValue() == 0) {
		ActionErrors errors = new ActionErrors();
		ActionMessage error = new ActionMessage(Constante.KEY_KO_IDGRUPO);
		errors.add(Constante.MSG_KO, error);
		saveErrors(request, errors);
	    } else {
		componente = business.obtenerComponente(idcomponente);
	    }

	    if (componente == null) {
		// Ha ocurrido un error
		ActionErrors errors = new ActionErrors();
		ActionMessage error = new ActionMessage(Constante.KEY_KO_ACTION);
		errors.add(Constante.MSG_KO, error);
		saveErrors(request, errors);
	    } else {
		vlForm.setComponente(componente);
	    }
	} catch (Exception except) {
	    LOGGER.error("Error al ejecutar el action", except);
	    forward = Constante.FW_ERROR_FATAL;
	}
	LOGGER.debug("End VerComponenteAction");
	return mapping.findForward(forward);

    }

    public ComponenteBO getBusiness() {
	return business;
    }

    public void setBusiness(final ComponenteBO business) {
	this.business = business;
    }
}
