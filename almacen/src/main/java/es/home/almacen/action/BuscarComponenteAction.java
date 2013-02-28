/**
 * 
 */
package es.home.almacen.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import es.home.almacen.bean.Componente;
import es.home.almacen.business.ComponenteBO;
import es.home.almacen.form.BuscarComponenteForm;
import es.home.almacen.util.Constante;

/**
 * @author dsblanco
 * 
 */
public class BuscarComponenteAction extends Action {

    private ComponenteBO componenteBO;

    private final static Logger LOGGER = Logger.getLogger(BuscarComponenteAction.class);

    public BuscarComponenteAction() {
	super();
    }

    @Override
    public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest request, final HttpServletResponse response) throws Exception {
	LOGGER.debug("Inicio BuscarComponenteAction");
	BuscarComponenteForm biForm = (BuscarComponenteForm) form;
	String nombre = biForm.getNombre();
	List<Componente> lista = componenteBO.buscarComponente(nombre);
	biForm.setComponentes(lista);
	LOGGER.debug("End BuscarComponenteAction");
	return mapping.findForward(Constante.FW_SUCCESS);

    }

    public ComponenteBO getComponenteBO() {
	return componenteBO;
    }

    public void setComponenteBO(final ComponenteBO componenteBO) {
	this.componenteBO = componenteBO;
    }
}
