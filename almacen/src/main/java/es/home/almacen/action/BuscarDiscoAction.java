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

import es.home.almacen.bean.Disco;
import es.home.almacen.business.DiscoBO;
import es.home.almacen.form.BuscarDiscoForm;
import es.home.almacen.util.Constante;

/**
 * @author dsblanco
 * 
 */
public class BuscarDiscoAction extends Action {

    private final static Logger LOGGER = Logger.getLogger(BuscarDiscoAction.class);

    private DiscoBO discoBO;

    @Override
    public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest request, final HttpServletResponse response)
    throws Exception {
	LOGGER.debug("Inicio BuscarDiscoAction");
	BuscarDiscoForm bdForm = (BuscarDiscoForm) form;
	String nombre = bdForm.getNombre();
	String productor = bdForm.getProductor();
	String sello = bdForm.getSello();
	int anyo = bdForm.getAnyo();
	List<Disco> lista = discoBO.buscarDisco(nombre, productor, sello, anyo);
	bdForm.setDiscos(lista);
	LOGGER.debug("End BuscarDiscoAction");
	return mapping.findForward(Constante.FW_SUCCESS);
    }

    public DiscoBO getDiscoBO() {
	return discoBO;
    }

    public void setDiscoBO(final DiscoBO discoBO) {
	this.discoBO = discoBO;
    }
}
