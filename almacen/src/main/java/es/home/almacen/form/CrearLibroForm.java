/**
 * 
 */
package es.home.almacen.form;

import org.apache.struts.validator.ValidatorForm;

import es.home.almacen.bean.Libro;

/**
 * @author dsblanco
 * 
 */
public class CrearLibroForm extends ValidatorForm {

    private static final long serialVersionUID = 3984516371445006864L;

    private Libro libro;

    /**
     * Constructor
     */
    public CrearLibroForm() {
	super();
	setLibro(new Libro());
    }

    /**
     * @return the libro
     */
    public Libro getLibro() {
	return libro;
    }

    /**
     * @param libro the libro to set
     */
    public void setLibro(final Libro libro) {
	this.libro = libro;
    }


}
