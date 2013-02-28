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
public class BuscarCancionForm extends ActionForm {

    private static final long serialVersionUID = -8792011061543456711L;

    private String nombre;
    private String duracion;
    private List<Cancion> canciones;
    private List<LabelValueBean> discos;
    private int iddisco;

    public BuscarCancionForm() {
	super();
	setCanciones(new ArrayList<Cancion>());
	discos = new ArrayList<LabelValueBean>();
    }

    /**
     * @return the canciones
     */
    public List<Cancion> getCanciones() {
	return canciones;
    }

    public List<LabelValueBean> getDiscos() {
	return discos;
    }

    /**
     * @return the duracion
     */
    public String getDuracion() {
	return duracion;
    }

    public int getIddisco() {
	return iddisco;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
	return nombre;
    }

    /**
     * @param canciones
     *            the canciones to set
     */
    public void setCanciones(final List<Cancion> canciones) {
	this.canciones = canciones;
    }

    public void setDiscos(final List<LabelValueBean> discos) {
	this.discos = discos;
    }

    /**
     * @param duracion
     *            the duracion to set
     */
    public void setDuracion(final String duracion) {
	this.duracion = duracion;
    }

    public void setIddisco(final int iddisco) {
	this.iddisco = iddisco;
    }

    /**
     * @param nombre
     *            the nombre to set
     */
    public void setNombre(final String nombre) {
	this.nombre = nombre;
    }

}
