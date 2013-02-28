/**
 * 
 */
package es.home.almacen.form;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.action.ActionForm;

import es.home.almacen.bean.Grupo;

/**
 * @author dsblanco
 * 
 */
public class BuscarGrupoForm extends ActionForm {

    private static final long serialVersionUID = -8792011061543456711L;

    private String nombre;

    private List<Grupo> grupos;

    public BuscarGrupoForm() {
	super();
	grupos = new ArrayList<Grupo>();
    }

    /**
     * @return the grupos
     */
    public List<Grupo> getGrupos() {
	return grupos;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
	return nombre;
    }

    /**
     * @param grupos
     *            the grupos to set
     */
    public void setGrupos(List<Grupo> grupos) {
	this.grupos = grupos;
    }

    /**
     * @param nombre
     *            the nombre to set
     */
    public void setNombre(String nombre) {
	this.nombre = nombre;
    }

}
