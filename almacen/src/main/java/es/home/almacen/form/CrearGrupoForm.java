/**
 * 
 */
package es.home.almacen.form;

import org.apache.struts.action.ActionForm;

/**
 * @author dsblanco
 * 
 */
public class CrearGrupoForm extends ActionForm {

    private static final long serialVersionUID = -6291157372222788268L;

    private String nombre;

    /**
     * Constructor
     */
    public CrearGrupoForm() {
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
    public void setNombre(String nombre) {
	this.nombre = nombre;
    }

}
