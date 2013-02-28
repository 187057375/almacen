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

import es.home.almacen.bean.Libro;
import es.home.almacen.business.LibroBO;
import es.home.almacen.form.VerLibroForm;
import es.home.almacen.util.Constante;

/**
 * @author dsblanco
 * 
 */
public class VerLibroAction extends Action {

    private final static Logger LOGGER = Logger.getLogger(VerLibroAction.class);

    private LibroBO libroBO;

    @Override
    public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest request, final HttpServletResponse response) throws Exception {
	String forward = Constante.FW_SUCCESS;
	LOGGER.debug("Inicio VerLibroAction");
	try {
	    VerLibroForm vlForm = (VerLibroForm) form;
	    Integer idlibro = vlForm.getIdlibro();
	    Libro libro = null;
	    if (idlibro == null || idlibro.intValue() == 0) {
		ActionErrors errors = new ActionErrors();
		ActionMessage error = new ActionMessage(Constante.KEY_KO_IDGRUPO);
		errors.add(Constante.MSG_KO, error);
		saveErrors(request, errors);
	    } else {
		libro = libroBO.obtenerLibro(idlibro);
	    }

	    if (libro == null) {
		// Ha ocurrido un error
		ActionErrors errors = new ActionErrors();
		ActionMessage error = new ActionMessage(Constante.KEY_KO_ACTION);
		errors.add(Constante.MSG_KO, error);
		saveErrors(request, errors);
	    } else {
		vlForm.setLibro(libro);
	    }
	} catch (Exception except) {
	    LOGGER.error("Error al ejecutar el action", except);
	    forward = Constante.FW_ERROR_FATAL;
	}
	LOGGER.debug("End VerLibroAction");
	return mapping.findForward(forward);

    }


    public LibroBO getLibroBO() {
	return libroBO;
    }


    public void setLibroBO(final LibroBO libroBO) {
	this.libroBO = libroBO;
    }
}
