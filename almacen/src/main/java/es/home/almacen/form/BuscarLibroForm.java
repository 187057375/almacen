/**
 * 
 */
package es.home.almacen.form;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.action.ActionForm;

import es.home.almacen.bean.Libro;

/**
 * @author dsblanco
 * 
 */
public class BuscarLibroForm extends ActionForm {

    private static final long serialVersionUID = -8792011061543456711L;

    private String nombre;

    private String nombreOriginal;

    private String autor;

    private String ilustracion;

    private String disenyo;

    private String traduccion;

    private String editorial;

    private String edicion;

    private int paginas;

    private String argumento;

    private String saga;

    private List<Libro> libros;

    /**
     * Constructor
     */
    public BuscarLibroForm() {
	super();
	libros = new ArrayList<Libro>();
    }

    /**
     * @return the argumento
     */
    public String getArgumento() {
	return argumento;
    }

    /**
     * @return the autor
     */
    public String getAutor() {
	return autor;
    }

    /**
     * @return the disenyo
     */
    public String getDisenyo() {
	return disenyo;
    }

    /**
     * @return the edicion
     */
    public String getEdicion() {
	return edicion;
    }

    /**
     * @return the editorial
     */
    public String getEditorial() {
	return editorial;
    }

    /**
     * @return the ilustracion
     */
    public String getIlustracion() {
	return ilustracion;
    }

    /**
     * @return the libros
     */
    public List<Libro> getLibros() {
	return libros;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
	return nombre;
    }

    /**
     * @return the nombreOriginal
     */
    public String getNombreOriginal() {
	return nombreOriginal;
    }

    /**
     * @return the paginas
     */
    public int getPaginas() {
	return paginas;
    }

    /**
     * @return the saga
     */
    public String getSaga() {
	return saga;
    }

    /**
     * @return the traduccion
     */
    public String getTraduccion() {
	return traduccion;
    }

    /**
     * @param argumento
     *            the argumento to set
     */
    public void setArgumento(final String argumento) {
	this.argumento = argumento;
    }

    /**
     * @param autor
     *            the autor to set
     */
    public void setAutor(final String autor) {
	this.autor = autor;
    }

    /**
     * @param disenyo
     *            the disenyo to set
     */
    public void setDisenyo(final String disenyo) {
	this.disenyo = disenyo;
    }

    /**
     * @param edicion
     *            the edicion to set
     */
    public void setEdicion(final String edicion) {
	this.edicion = edicion;
    }

    /**
     * @param editorial
     *            the editorial to set
     */
    public void setEditorial(final String editorial) {
	this.editorial = editorial;
    }

    /**
     * @param ilustracion
     *            the ilustracion to set
     */
    public void setIlustracion(final String ilustracion) {
	this.ilustracion = ilustracion;
    }

    /**
     * @param libros
     *            the libros to set
     */
    public void setLibros(final List<Libro> libros) {
	this.libros = libros;
    }

    /**
     * @param nombre
     *            the nombre to set
     */
    public void setNombre(final String nombre) {
	this.nombre = nombre;
    }

    /**
     * @param nombreOriginal
     *            the nombreOriginal to set
     */
    public void setNombreOriginal(final String nombreOriginal) {
	this.nombreOriginal = nombreOriginal;
    }

    /**
     * @param paginas
     *            the paginas to set
     */
    public void setPaginas(final int paginas) {
	this.paginas = paginas;
    }

    /**
     * @param paginas
     *            the paginas to set
     */
    public void setPaginas(final Integer paginas) {
	this.paginas = paginas;
    }

    /**
     * @param saga
     *            the saga to set
     */
    public void setSaga(final String saga) {
	this.saga = saga;
    }

    /**
     * @param traduccion
     *            the traduccion to set
     */
    public void setTraduccion(final String traduccion) {
	this.traduccion = traduccion;
    }
}
