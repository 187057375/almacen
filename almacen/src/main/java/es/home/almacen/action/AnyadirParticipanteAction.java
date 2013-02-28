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

import es.home.almacen.bean.Componente;
import es.home.almacen.bean.Disco;
import es.home.almacen.bean.Participante;
import es.home.almacen.business.ComponenteBO;
import es.home.almacen.business.ParticipanteBO;
import es.home.almacen.form.AnyadirParticipanteForm;
import es.home.almacen.util.Constante;

/**
 * @author dsblanco
 * 
 */
public class AnyadirParticipanteAction extends DispatchAction {

    private final static Logger LOGGER = Logger.getLogger(AnyadirParticipanteAction.class);

    // private final DiscoBO discoBus;
    private ComponenteBO componenteBus;
    private ParticipanteBO participanteBus;

    /**
     * @return the componenteBus
     */
    public ComponenteBO getComponenteBus() {
	return componenteBus;
    }

    private Participante getParticipante(AnyadirParticipanteForm acForm) {
	Participante part = new Participante();
	Disco disco = new Disco();
	disco.setIddisco(acForm.getIddisco());
	part.setDisco(disco);
	Componente componente = new Componente();
	componente.setIdcomponente(acForm.getIdcomponente());
	part.setComponente(componente);
	part.setInstrumento(acForm.getInstrumento());
	return part;

    }

    /**
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward nuevo(final ActionMapping mapping, final ActionForm form, final HttpServletRequest request, final HttpServletResponse response)
	    throws Exception {
	String forward = Constante.FW_PASO1;
	LOGGER.debug("Inicio AnyadirComponenteAction - nuevo");
	ActionErrors errors = new ActionErrors();
	try {
	    List<LabelValueBean> lista = new ArrayList<LabelValueBean>();

	    List<Componente> listaComponentes = componenteBus.buscarComponente(null);
	    if (!listaComponentes.isEmpty()) {
		for (Componente componente : listaComponentes) {
		    lista.add(new LabelValueBean(componente.getNombre(), Integer.toString(componente.getIdcomponente())));
		}
	    }
	    ((AnyadirParticipanteForm) form).setComponentes(lista);

	} catch (Exception except) {
	    LOGGER.error("Error al ejecutar el action", except);
	    forward = Constante.FW_ERROR_FATAL;
	    ActionMessage error = new ActionMessage(Constante.KEY_KO_ACTION);
	    errors.add(Constante.MSG_KO, error);
	    saveErrors(request, errors);
	}

	LOGGER.debug("End AnyadirComponenteAction - nuevo");
	return mapping.findForward(forward);
    }

    public ActionForward save(final ActionMapping mapping, final ActionForm form, final HttpServletRequest request, final HttpServletResponse response)
	    throws Exception {
	String forward = Constante.FW_PASO2;
	LOGGER.debug("Inicio CrearGrupoAction - save");
	ActionErrors errors = new ActionErrors();
	ActionMessages messages = new ActionMessages();
	try {
	    AnyadirParticipanteForm acForm = (AnyadirParticipanteForm) form;
	    Participante bean = getParticipante(acForm);
	    bean = participanteBus.crearParticipante(bean, true);
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

	LOGGER.debug("End CrearGrupoAction - save");
	return mapping.findForward(forward);
    }
}
