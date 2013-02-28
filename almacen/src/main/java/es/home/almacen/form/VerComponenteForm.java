/**
 * 
 */
package es.home.almacen.form;

import org.apache.struts.action.ActionForm;

import es.home.almacen.bean.Componente;

/**
 * @author dsblanco
 * 
 */
public class VerComponenteForm extends ActionForm {

    private static final long serialVersionUID = 1L;
    private Integer idcomponente;
    private boolean habilitado;
    private String method;
    private Componente componente;
    private boolean confirmar;

    /**
     * Constructor
     */
    public VerComponenteForm() {
	super();
	componente = new Componente();
    }

    /**
     * @return the componente
     */
    public Componente getComponente() {
	return componente;
    }

    /**
     * @return the idcomponente
     */
    public Integer getIdcomponente() {
	return idcomponente;
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
     * @return the habilitado
     */
    public boolean isHabilitado() {
	return habilitado;
    }

    /**
     * @param componente
     *            the componente to set
     */
    public void setComponente(final Componente componente) {
	this.componente = componente;
    }

    /**
     * @param confirmar the confirmar to set
     */
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

    /**
     * @param idcomponente
     *            the idcomponente to set
     */
    public void setIdcomponente(final Integer idcomponente) {
	this.idcomponente = idcomponente;
    }

    /**
     * @param method
     *            the method to set
     */
    public void setMethod(final String method) {
	this.method = method;
    }

}
