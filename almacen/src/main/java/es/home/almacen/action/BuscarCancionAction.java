/**
 * 
 */
package es.home.almacen.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.apache.struts.util.LabelValueBean;

import es.home.almacen.bean.Cancion;
import es.home.almacen.bean.Disco;
import es.home.almacen.business.CancionBO;
import es.home.almacen.business.DiscoBO;
import es.home.almacen.form.BuscarCancionForm;
import es.home.almacen.util.Constante;

/**
 * @author dsblanco
 * 
 */
public class BuscarCancionAction extends DispatchAction {

    private final static Logger LOGGER = Logger.getLogger(BuscarCancionAction.class);

    private CancionBO cancionBO;
    private DiscoBO discoBO;

    public BuscarCancionAction() {
	super();
    }

    private void anyadirOpcion(final List<LabelValueBean> listaBean) {
	LabelValueBean lvbBean = new LabelValueBean(Constante.SELECCIONE_OPCION, Integer.toString(Constante.INT_ZERO));
	listaBean.add(lvbBean);
    }

    public ActionForward buscar(final ActionMapping mapping, final ActionForm form, final HttpServletRequest request, final HttpServletResponse response) throws Exception {
	LOGGER.debug("Inicio BuscarCancionAction - buscar");
	BuscarCancionForm bdForm = (BuscarCancionForm) form;
	String nombre = bdForm.getNombre();
	String duracion = bdForm.getDuracion();
	int iddisco = bdForm.getIddisco();
	List<Cancion> lista = cancionBO.buscarCancion(nombre, duracion, iddisco);
	bdForm.setCanciones(lista);
	buscarDiscos(bdForm);
	LOGGER.debug("End BuscarCancionAction - buscar");
	return mapping.findForward(Constante.FW_SUCCESS);

    }

    private void buscarDiscos(final BuscarCancionForm bdForm) {
	List<Disco> lista = discoBO.buscarDisco(null, null, null, 0);
	List<LabelValueBean> listaBean = new ArrayList<LabelValueBean>();
	if (!lista.isEmpty()) {
	    anyadirOpcion(listaBean);
	    for (Disco grupo : lista) {
		listaBean.add(new LabelValueBean(grupo.getNombre(), Integer.toString(grupo.getIddisco())));
	    }
	} else {
	    anyadirOpcion(listaBean);
	}
	bdForm.setDiscos(listaBean);
    }

    public CancionBO getCancionBO() {
	return cancionBO;
    }

    public CancionBO getcBO() {
	return cancionBO;
    }

    public DiscoBO getdBO() {
	return discoBO;
    }

    public DiscoBO getDiscoBO() {
	return discoBO;
    }

    public ActionForward inicio(final ActionMapping mapping, final ActionForm form, final HttpServletRequest request, final HttpServletResponse response) throws Exception {
	LOGGER.debug("Inicio BuscarCancionAction - inicio");
	BuscarCancionForm bdForm = (BuscarCancionForm) form;
	buscarDiscos(bdForm);
	LOGGER.debug("End BuscarCancionAction - inicio");
	return mapping.findForward(Constante.FW_SUCCESS);
    }

    public void setCancionBO(final CancionBO cancionBO) {
	this.cancionBO = cancionBO;
    }

    public void setcBO(final CancionBO cBO) {
	this.cancionBO = cBO;
    }

    public void setdBO(final DiscoBO dBO) {
	this.discoBO = dBO;
    }

    public void setDiscoBO(final DiscoBO discoBO) {
	this.discoBO = discoBO;
    }
}
