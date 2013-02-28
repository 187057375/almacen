/**
 * 
 */
package es.home.almacen.form;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.action.ActionForm;

import es.home.almacen.bean.Disco;

/**
 * @author dsblanco
 * 
 */
public class BuscarDiscoForm extends ActionForm {

    private static final long serialVersionUID = -8792011061543456711L;

    private String nombre;

    private String productor;
    private String sello;
    private int anyo;
    private List<Disco> discos;

    public BuscarDiscoForm() {
	super();
	discos = new ArrayList<Disco>();
    }

    /**
     * @return the anyo
     */
    public int getAnyo() {
	return anyo;
    }

    /**
     * @return the discos
     */
    public List<Disco> getDiscos() {
	return discos;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
	return nombre;
    }

    /**
     * @return the productor
     */
    public String getProductor() {
	return productor;
    }

    /**
     * @return the sello
     */
    public String getSello() {
	return sello;
    }

    /**
     * @param anyo
     *            the anyo to set
     */
    public void setAnyo(final int anyo) {
	this.anyo = anyo;
    }

    /**
     * @param discos
     *            the discos to set
     */
    public void setDiscos(final List<Disco> discos) {
	this.discos = discos;
    }

    /**
     * @param nombre
     *            the nombre to set
     */
    public void setNombre(final String nombre) {
	this.nombre = nombre;
    }

    /**
     * @param productor
     *            the productor to set
     */
    public void setProductor(final String productor) {
	this.productor = productor;
    }

    /**
     * @param sello
     *            the sello to set
     */
    public void setSello(final String sello) {
	this.sello = sello;
    }

}
