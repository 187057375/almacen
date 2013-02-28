/**
 * 
 */
package es.home.almacen.form;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.action.ActionForm;

import es.home.almacen.bean.Componente;

/**
 * @author dsblanco
 * 
 */
public class BuscarComponenteForm extends ActionForm {

    private static final long serialVersionUID = 1L;
    private String nombre;
    private List<Componente> componentes;

    public BuscarComponenteForm() {
	super();
	setComponentes(new ArrayList<Componente>());
    }

    /**
     * @return the componentes
     */
    public List<Componente> getComponentes() {
	return componentes;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
	return nombre;
    }

    /**
     * @param componentes
     *            the componentes to set
     */
    public void setComponentes(final List<Componente> componentes) {
	this.componentes = componentes;
    }

    /**
     * @param nombre
     *            the nombre to set
     */
    public void setNombre(final String nombre) {
	this.nombre = nombre;
    }

}
