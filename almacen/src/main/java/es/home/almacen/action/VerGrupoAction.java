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

import es.home.almacen.bean.Grupo;
import es.home.almacen.business.GrupoBO;
import es.home.almacen.form.VerGrupoForm;
import es.home.almacen.util.Constante;

/**
 * @author dsblanco
 * 
 */
public class VerGrupoAction extends Action {

    private final static Logger LOGGER = Logger.getLogger(VerGrupoAction.class);

    private final static String GRUPO = "grupo";
    private GrupoBO grupoBO;

    @Override
    public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest request, final HttpServletResponse response)
    throws Exception {
	String forward = Constante.FW_SUCCESS;
	LOGGER.debug("Inicio VerGrupoAction");
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
		request.setAttribute(GRUPO, grupo);
		vlForm.setGrupo(grupo);
	    }
	} catch (Exception except) {
	    LOGGER.error("Error al ejecutar el action", except);
	    forward = Constante.FW_ERROR_FATAL;
	}
	LOGGER.debug("End VerGrupoAction");
	return mapping.findForward(forward);

    }

    public GrupoBO getGrupoBO() {
	return grupoBO;
    }

    public void setGrupoBO(final GrupoBO grupoBO) {
	this.grupoBO = grupoBO;
    }
}
