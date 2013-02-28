/**
 * 
 */
package es.home.almacen.form;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.action.ActionForm;
import org.apache.struts.util.LabelValueBean;

import es.home.almacen.bean.Cancion;

/**
 * @author dsblanco
 * 
 */
public class VerCancionForm extends ActionForm {

    private static final long serialVersionUID = 4324249859072555575L;

    private Integer idcancion;
    private Cancion cancion;
    private boolean habilitado;
    private boolean confirmar;
    private String method;

    private List<LabelValueBean> discos;

    /**
     * Constructor
     */
    public VerCancionForm() {
	super();
	cancion = new Cancion();
	setDiscos(new ArrayList<LabelValueBean>());
    }

    /**
     * @return the cancion
     */
    public Cancion getCancion() {
	return cancion;
    }

    /**
     * @return the discos
     */
    public List<LabelValueBean> getDiscos() {
	return discos;
    }

    /**
     * @return the habilitado
     */
    public boolean getHabilitado() {
	return habilitado;
    }

    /**
     * @return the idcancion
     */
    public Integer getIdcancion() {
	return idcancion;
    }

    /**
     * @return the method
     */
    public String getMethod() {
	return method;
    }

    /**
     * @return the confirmar
     */
    public boolean isConfirmar() {
	return confirmar;
    }

    /**
     * @param cancion
     *            the cancion to set
     */
    public void setCancion(final Cancion cancion) {
	this.cancion = cancion;
    }

    /**
     * @param confirmar the confirmar to set
     */
    public void setConfirmar(final boolean confirmar) {
	this.confirmar = confirmar;
    }

    /**
     * @param discos
     *            the discos to set
     */
    public void setDiscos(final List<LabelValueBean> discos) {
	this.discos = discos;
    }

    /**
     * @param habilitado
     *            the habilitado to set
     */
    public void setHabilitado(final boolean habilitado) {
	this.habilitado = habilitado;
    }

    /**
     * @param idcancion
     *            the idcancion to set
     */
    public void setIdcancion(final Integer idcancion) {
	this.idcancion = idcancion;
    }

    /**
     * @param method
     *            the method to set
     */
    public void setMethod(final String method) {
	this.method = method;
    }

}
