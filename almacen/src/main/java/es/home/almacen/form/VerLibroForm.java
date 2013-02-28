/**
 * 
 */
package es.home.almacen.form;

import org.apache.struts.action.ActionForm;

import es.home.almacen.bean.Libro;

/**
 * @author dsblanco
 * 
 */
public class VerLibroForm extends ActionForm {

    private static final long serialVersionUID = 1L;
    private Integer idlibro;
    private boolean habilitado;
    private boolean confirmar;
    private String method;
    private Libro libro;

    /**
     * Constructor
     */
    public VerLibroForm() {
	super();
	libro = new Libro();
	habilitado = false;
	confirmar = false;
    }

    public Integer getIdlibro() {
	return idlibro;
    }

    public Libro getLibro() {
	return libro;
    }

    /**
     * @return the method
     */
    public String getMethod() {
	return method;
    }


    public boolean isConfirmar() {
	return confirmar;
    }

    /**
     * @return the habilitado
     */
    public boolean isHabilitado() {
	return habilitado;
    }

    public void setConfirmar(final boolean confirmar) {
	this.confirmar = confirmar;
    }

    /**
     * @param habilitado
     *            the habilitado to set
     */
    public void setHabilitado(final boolean habilitado) {
	this.habilitado = habilitado;
    }

    public void setIdlibro(final Integer idlibro) {
	this.idlibro = idlibro;
    }

    public void setLibro(final Libro libro) {
	this.libro = libro;
    }

    /**
     * @param method
     *            the method to set
     */
    public void setMethod(final String method) {
	this.method = method;
    }

}
