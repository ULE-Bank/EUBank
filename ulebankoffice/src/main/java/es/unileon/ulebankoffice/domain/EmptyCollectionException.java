/**
 * 
 */
package es.unileon.ulebankoffice.domain;

/**
 * Excepcón que se produce cuando se está tratando de iterar sobre una colección
 * vacía.
 * 
 * @author Razvan Raducu
 *
 */
public class EmptyCollectionException extends Exception {

	/**
	 * Recibe el mensaje que se expandirá a lo largo de la traza de la
	 * Excepción. the detail message. The detail message is saved for later
	 * retrieval by the getMessage() method.
	 * 
	 * @param message
	 */
	public EmptyCollectionException(String message) {
		super(message);
	}

}
