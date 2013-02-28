/**
 * 
 */
package es.home.almacen.form;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.action.ActionForm;
import org.apache.struts.util.LabelValueBean;

/**
 * @author dsblanco
 * 
 */
public class CrearCancionForm extends ActionForm {

    private static final long serialVersionUID = 1L;

    private List<LabelValueBean> discos;

    private String nombre;

    private String duracion;

    private int iddisco;

    /**
     * Constructor
     */
    public CrearCancionForm() {
	super();
	discos = new ArrayList<LabelValueBean>();
    }

    public List<LabelValueBean> getDiscos() {
	return discos;
    }

    public String getDuracion() {
	return duracion;
    }

    public int getIddisco() {
	return iddisco;
    }

    public String getNombre() {
	return nombre;
    }

    public void setDiscos(final List<LabelValueBean> discos) {
	this.discos = discos;
    }

    public void setDuracion(final String duracion) {
	this.duracion = duracion;
    }

    public void setIddisco(final int iddisco) {
	this.iddisco = iddisco;
    }

    public void setNombre(final String nombre) {
	this.nombre = nombre;
    }

}
