/**
 * 
 */
package es.home.almacen.form;

import org.apache.struts.action.ActionForm;

/**
 * @author dsblanco
 * 
 */
public class CrearComponenteForm extends ActionForm {

    private static final long serialVersionUID = 1L;
    private String nombre;

    /**
     * Constructor
     */
    public CrearComponenteForm() {
	super();
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
	return nombre;
    }

    /**
     * @param nombre
     *            the nombre to set
     */
    public void setNombre(final String nombre) {
	this.nombre = nombre;
    }

}
