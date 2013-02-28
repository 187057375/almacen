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
import es.home.almacen.form.VerCancionForm;
import es.home.almacen.util.Constante;

/**
 * @author dsblanco
 * 
 */
public class ModificarCancionAction extends DispatchAction {

    private final static Logger LOGGER = Logger.getLogger(ModificarCancionAction.class);

    private CancionBO cancionBO;
    private DiscoBO discoBO;

    public ModificarCancionAction() {
	super();
    }

    public ActionForward Editar(final ActionMapping mapping, final ActionForm form, final HttpServletRequest request, final HttpServletResponse response)
    throws Exception {
	String forward = Constante.FW_PASO1;
	LOGGER.debug("Inicio ModificarCancionAction - Editar");
	try {
	    VerCancionForm vdForm = (VerCancionForm) form;
	    vdForm.setHabilitado(true);
	    Integer idcancion = vdForm.getIdcancion();
	    Cancion cancion = null;
	    if (idcancion == null || idcancion.intValue() == 0) {
		ActionErrors errors = new ActionErrors();
		ActionMessage error = new ActionMessage(Constante.KEY_KO_IDGRUPO);
		errors.add(Constante.MSG_KO, error);
		saveErrors(request, errors);
	    } else {
		cancion = cancionBO.obtenerCancion(idcancion);
	    }

	    if (cancion == null) {
		// Ha ocurrido un error
		ActionErrors errors = new ActionErrors();
		ActionMessage error = new ActionMessage(Constante.KEY_KO_ACTION);
		errors.add(Constante.MSG_KO, error);
		saveErrors(request, errors);
	    } else {
		vdForm.setCancion(cancion);
	    }

	    // Obtenemos el conjunto de discos
	    List<LabelValueBean> lista = new ArrayList<LabelValueBean>();

	    List<Disco> listaDiscos = discoBO.buscarDisco(null, null, null, 0);
	    if (!listaDiscos.isEmpty()) {
		for (Disco disco : listaDiscos) {
		    lista.add(new LabelValueBean(disco.getNombre(), Integer.toString(disco.getIddisco())));
		}
	    }
	    vdForm.setDiscos(lista);
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
	VerCancionForm vForm = (VerCancionForm) form;
	try {

	    int idcancion = vForm.getIdcancion();
	    boolean correcto = cancionBO.eliminar(idcancion);
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

    public CancionBO getCancionBO() {
	return cancionBO;
    }

    private Cancion getCancionDto(final VerCancionForm vdForm) {
	Cancion bean = new Cancion();
	bean.setDuracion(vdForm.getCancion().getDuracion());
	bean.setIdcancion(vdForm.getIdcancion());
	Disco disco = new Disco();
	disco.setIddisco(vdForm.getCancion().getDisco().getIddisco());
	bean.setDisco(disco);
	bean.setNombre(vdForm.getCancion().getNombre());
	return bean;
    }

    public DiscoBO getDiscoBO() {
	return discoBO;
    }

    public ActionForward Guardar(final ActionMapping mapping, final ActionForm form, final HttpServletRequest request, final HttpServletResponse response)
    throws Exception {
	String forward = Constante.FW_PASO2;
	LOGGER.debug("Inicio ModificarCancionAction - Guardar");
	ActionErrors errors = new ActionErrors();
	ActionMessages messages = new ActionMessages();
	try {
	    VerCancionForm vdForm = (VerCancionForm) form;
	    Cancion bean = getCancionDto(vdForm);
	    bean = cancionBO.crearCancion(bean, false);
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

    public void setCancionBO(final CancionBO cancionBO) {
	this.cancionBO = cancionBO;
    }

    public void setDiscoBO(final DiscoBO discoBO) {
	this.discoBO = discoBO;
    }
}
