/**
 * 
 */
package es.home.almacen.form;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.action.ActionForm;
import org.apache.struts.util.LabelValueBean;

import es.home.almacen.bean.Disco;

/**
 * @author dsblanco
 * 
 */
public class VerDiscoForm extends ActionForm {

    private static final long serialVersionUID = 4324249859072555575L;

    private Integer iddisco;
    private boolean habilitado;
    private boolean confirmar;
    private String method;
    private Disco disco;
    private List<LabelValueBean> grupos;

    /**
     * Constructor
     */
    public VerDiscoForm() {
	super();
	disco = new Disco();
	setGrupos(new ArrayList<LabelValueBean>());
    }

    /**
     * @return the disco
     */
    public Disco getDisco() {
	return disco;
    }

    /**
     * @return the grupos
     */
    public List<LabelValueBean> getGrupos() {
	return grupos;
    }

    /**
     * @return the iddisco
     */
    public Integer getIddisco() {
	return iddisco;
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
     * @param disco
     *            the disco to set
     */
    public void setDisco(final Disco disco) {
	this.disco = disco;
    }

    /**
     * @param grupos
     *            the grupos to set
     */
    public void setGrupos(final List<LabelValueBean> grupos) {
	this.grupos = grupos;
    }

    /**
     * @param habilitado
     *            the habilitado to set
     */
    public void setHabilitado(final boolean habilitado) {
	this.habilitado = habilitado;
    }

    /**
     * @param iddisco
     *            the iddisco to set
     */
    public void setIddisco(final Integer iddisco) {
	this.iddisco = iddisco;
    }

    /**
     * @param method
     *            the method to set
     */
    public void setMethod(final String method) {
	this.method = method;
    }

}
