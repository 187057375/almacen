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

import es.home.almacen.bean.Disco;
import es.home.almacen.bean.Grupo;
import es.home.almacen.business.DiscoBO;
import es.home.almacen.business.GrupoBO;
import es.home.almacen.form.VerDiscoForm;
import es.home.almacen.util.Constante;

/**
 * @author dsblanco
 * 
 */
public class ModificarDiscoAction extends DispatchAction {

    private final static Logger LOGGER = Logger.getLogger(ModificarDiscoAction.class);

    private DiscoBO discoBO;
    private GrupoBO grupoBO;

    public ModificarDiscoAction() {
	super();
    }

    public ActionForward Editar(final ActionMapping mapping, final ActionForm form, final HttpServletRequest request, final HttpServletResponse response)
    throws Exception {
	String forward = Constante.FW_PASO1;
	LOGGER.debug("Inicio ModificarCancionAction - Editar");
	try {
	    VerDiscoForm vdForm = (VerDiscoForm) form;
	    Integer iddisco = vdForm.getIddisco();
	    Disco disco = null;
	    if (iddisco == null || iddisco.intValue() == 0) {
		ActionErrors errors = new ActionErrors();
		ActionMessage error = new ActionMessage(Constante.KEY_KO_IDGRUPO);
		errors.add(Constante.MSG_KO, error);
		saveErrors(request, errors);
	    } else {
		disco = discoBO.obtenerDisco(iddisco);
	    }

	    if (disco == null) {
		// Ha ocurrido un error
		ActionErrors errors = new ActionErrors();
		ActionMessage error = new ActionMessage(Constante.KEY_KO_ACTION);
		errors.add(Constante.MSG_KO, error);
		saveErrors(request, errors);
	    } else {
		vdForm.setDisco(disco);
	    }

	    // Obtenemos el conjunto de grupos
	    List<LabelValueBean> lista = new ArrayList<LabelValueBean>();

	    List<Grupo> listaGrupos = grupoBO.buscarGrupo(null);
	    if (!listaGrupos.isEmpty()) {
		for (Grupo grupo : listaGrupos) {
		    lista.add(new LabelValueBean(grupo.getNombre(), Integer.toString(grupo.getIdgrupo())));
		}
	    }
	    vdForm.setGrupos(lista);
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
	VerDiscoForm vForm = (VerDiscoForm) form;
	try {

	    int idcancion = vForm.getIddisco();
	    boolean correcto = discoBO.eliminar(idcancion);
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

    public DiscoBO getDiscoBO() {
	return discoBO;
    }

    private Disco getDiscoDto(final VerDiscoForm vdForm) {
	Disco bean = new Disco();
	bean.setAnyo(vdForm.getDisco().getAnyo());
	bean.setIddisco(vdForm.getIddisco());
	Grupo grupo = new Grupo();
	grupo.setIdgrupo(vdForm.getDisco().getGrupo().getIdgrupo());
	bean.setGrupo(grupo);
	bean.setNombre(vdForm.getDisco().getNombre());
	bean.setProductor(vdForm.getDisco().getProductor());
	bean.setSello(vdForm.getDisco().getSello());
	return bean;
    }

    public GrupoBO getGrupoBO() {
	return grupoBO;
    }

    public ActionForward Guardar(final ActionMapping mapping, final ActionForm form, final HttpServletRequest request, final HttpServletResponse response)
    throws Exception {
	String forward = Constante.FW_PASO2;
	LOGGER.debug("Inicio ModificarCancionAction - Guardar");
	ActionErrors errors = new ActionErrors();
	ActionMessages messages = new ActionMessages();
	try {
	    VerDiscoForm vdForm = (VerDiscoForm) form;
	    Disco bean = getDiscoDto(vdForm);
	    bean = discoBO.crearDisco(bean, false);
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

    public void setDiscoBO(final DiscoBO discoBO) {
	this.discoBO = discoBO;
    }

    public void setGrupoBO(final GrupoBO grupoBO) {
	this.grupoBO = grupoBO;
    }
}
