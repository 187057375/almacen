/**
 * 
 */
package es.home.almacen.form;

import org.apache.struts.action.ActionForm;

import es.home.almacen.bean.Grupo;

/**
 * @author dsblanco
 * 
 */
public class VerGrupoForm extends ActionForm {

    private static final long serialVersionUID = 4324249859072555575L;

    private Integer idgrupo;
    private boolean habilitado;
    private boolean confirmar;
    private String method;
    private Grupo grupo;

    /**
     * Constructor
     */
    public VerGrupoForm() {
	super();
	grupo = new Grupo();
    }

    /**
     * @return the grupo
     */
    public Grupo getGrupo() {
	return grupo;
    }

    /**
     * @return the idgrupo
     */
    public Integer getIdgrupo() {
	return idgrupo;
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
     * @param confirmar the confirmar to set
     */
    public void setConfirmar(final boolean confirmar) {
	this.confirmar = confirmar;
    }

    /**
     * @param grupo
     *            the grupo to set
     */
    public void setGrupo(final Grupo grupo) {
	this.grupo = grupo;
    }

    /**
     * @param habilitado
     *            the habilitado to set
     */
    public void setHabilitado(final boolean habilitado) {
	this.habilitado = habilitado;
    }

    /**
     * @param idgrupo
     *            the idgrupo to set
     */
    public void setIdgrupo(final Integer idgrupo) {
	this.idgrupo = idgrupo;
    }

    /**
     * @param method
     *            the method to set
     */
    public void setMethod(final String method) {
	this.method = method;
    }

}
