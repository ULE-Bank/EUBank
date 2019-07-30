
package es.unileon.ulebankoffice.domain;

/**
 * Excepción que se produce cuando el DNI introducido es incorrecto.
 * 
 * @author Razvan Raducu
 *
 */
public class DNIException extends Exception {
	/**
	 * Recibe el mensaje que se expandirá a lo largo de la traza de la
	 * Excepción. the detail message. The detail message is saved for later
	 * retrieval by the getMessage() method.
	 * 
	 * @param message
	 */
	public DNIException(String message) {
		super(message);
	}

}
