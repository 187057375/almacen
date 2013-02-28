/**
 * 
 */
package es.home.almacen.form;

import org.apache.struts.action.ActionForm;

/**
 * @author dsblanco
 * 
 */
public class PruebaForm extends ActionForm {

    private static final long serialVersionUID = 7359245255078833004L;

    private String login;
    private String password;

    /**
     * @return the login
     */
    public String getLogin() {
	return login;
    }

    /**
     * @return the password
     */
    public String getPassword() {
	return password;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
	this.login = login;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
	this.password = password;
    }

}
