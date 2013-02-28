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

import es.home.almacen.bean.Cancion;
import es.home.almacen.bean.Disco;
import es.home.almacen.business.CancionBO;
import es.home.almacen.business.DiscoBO;
import es.home.almacen.form.CrearCancionForm;
import es.home.almacen.util.Constante;

/**
 * @author dsblanco
 * 
 */
public class CrearCancionAction extends DispatchAction {

    private final static Logger LOGGER = Logger.getLogger(CrearCancionAction.class);

    private CancionBO cancionBus;
    private DiscoBO discoBus;

    public CrearCancionAction() {
	super();
    }

    public CancionBO getCancionBus() {
	return cancionBus;
    }

    private Cancion getCancionDto(final CrearCancionForm cdForm) {
	Cancion bean = new Cancion();
	Disco disco = new Disco();
	disco.setIddisco(cdForm.getIddisco());
	bean.setDisco(disco);
	bean.setNombre(cdForm.getNombre());
	bean.setDuracion(cdForm.getDuracion());
	return bean;
    }

    /**
     * @return the discoBus
     */
    public DiscoBO getDiscoBus() {
	return discoBus;
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
	LOGGER.debug("Inicio CrearDiscoAction - nuevo");
	ActionErrors errors = new ActionErrors();
	try {
	    List<LabelValueBean> lista = new ArrayList<LabelValueBean>();

	    List<Disco> listaDiscos = discoBus.buscarDisco(null, null, null, 0);
	    if (!listaDiscos.isEmpty()) {
		for (Disco disco : listaDiscos) {
		    lista.add(new LabelValueBean(disco.getNombre(), Integer.toString(disco.getIddisco())));
		}
	    }
	    ((CrearCancionForm) form).setDiscos(lista);

	} catch (Exception except) {
	    LOGGER.error("Error al ejecutar el action", except);
	    forward = Constante.FW_ERROR_FATAL;
	    ActionMessage error = new ActionMessage(Constante.KEY_KO_ACTION);
	    errors.add(Constante.MSG_KO, error);
	    saveErrors(request, errors);
	}

	LOGGER.debug("End CrearDiscoAction - nuevo");
	return mapping.findForward(forward);
    }

    public ActionForward save(final ActionMapping mapping, final ActionForm form, final HttpServletRequest request, final HttpServletResponse response) throws Exception {
	String forward = Constante.FW_PASO2;
	LOGGER.debug("Inicio CrearDiscoAction - save");
	ActionErrors errors = new ActionErrors();
	ActionMessages messages = new ActionMessages();
	try {
	    CrearCancionForm cdForm = (CrearCancionForm) form;
	    Cancion bean = getCancionDto(cdForm);
	    bean = cancionBus.crearCancion(bean, true);
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

	LOGGER.debug("End CrearDiscoAction - save");
	return mapping.findForward(forward);
    }

    public void setCancionBus(final CancionBO cancionBus) {
	this.cancionBus = cancionBus;
    }

    public void setDiscoBus(final DiscoBO discoBus) {
	this.discoBus = discoBus;
    }
}
