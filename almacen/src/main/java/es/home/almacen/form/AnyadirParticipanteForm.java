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
public class AnyadirParticipanteForm extends ActionForm {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private int iddisco;
    private int idcomponente;
    private List<LabelValueBean> componentes;
    private String instrumento;

    public AnyadirParticipanteForm() {
	super();
	componentes = new ArrayList<LabelValueBean>();
    }

    /**
     * @return the componentes
     */
    public List<LabelValueBean> getComponentes() {
	return componentes;
    }

    /**
     * @return the idcomponente
     */
    public int getIdcomponente() {
	return idcomponente;
    }

    /**
     * @return the iddisco
     */
    public int getIddisco() {
	return iddisco;
    }

    /**
     * @return the instrumento
     */
    public String getInstrumento() {
	return instrumento;
    }

    /**
     * @param componentes
     *            the componentes to set
     */
    public void setComponentes(List<LabelValueBean> componentes) {
	this.componentes = componentes;
    }

    /**
     * @param idcomponente
     *            the idcomponente to set
     */
    public void setIdcomponente(int idcomponente) {
	this.idcomponente = idcomponente;
    }

    /**
     * @param iddisco
     *            the iddisco to set
     */
    public void setIddisco(int iddisco) {
	this.iddisco = iddisco;
    }

    /**
     * @param instrumento
     *            the instrumento to set
     */
    public void setInstrumento(String instrumento) {
	this.instrumento = instrumento;
    }

}
