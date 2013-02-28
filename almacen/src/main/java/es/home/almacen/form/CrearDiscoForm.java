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
public class CrearDiscoForm extends ActionForm {

    private static final long serialVersionUID = 1L;

    private List<LabelValueBean> grupos;

    private String nombre;

    private String productor;

    private String sello;

    private int anyo;

    private int idgrupo;

    /**
     * Constructor
     */
    public CrearDiscoForm() {
	super();
	grupos = new ArrayList<LabelValueBean>();
    }

    /**
     * @return the anyo
     */
    public int getAnyo() {
	return anyo;
    }

    /**
     * @return the grupos
     */
    public List<LabelValueBean> getGrupos() {
	return grupos;
    }

    /**
     * @return the idgrupo
     */
    public int getIdgrupo() {
	return idgrupo;
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
    public void setAnyo(int anyo) {
	this.anyo = anyo;
    }

    /**
     * @param grupos
     *            the grupos to set
     */
    public void setGrupos(List<LabelValueBean> grupos) {
	this.grupos = grupos;
    }

    /**
     * @param idgrupo
     *            the idgrupo to set
     */
    public void setIdgrupo(int idgrupo) {
	this.idgrupo = idgrupo;
    }

    /**
     * @param nombre
     *            the nombre to set
     */
    public void setNombre(String nombre) {
	this.nombre = nombre;
    }

    /**
     * @param productor
     *            the productor to set
     */
    public void setProductor(String productor) {
	this.productor = productor;
    }

    /**
     * @param sello
     *            the sello to set
     */
    public void setSello(String sello) {
	this.sello = sello;
    }

}
