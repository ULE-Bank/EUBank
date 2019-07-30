/**
 * 
 */
package es.unileon.ulebankoffice.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Razvan Raducu
 *
 */
@Document(collection = "Addresses")
public class Address {

	@Id
	private String id;

	private String street;
	private String city;
	private String autonomousRegion;
	private String number;

	private Handler dni;

	private int postalCode;

	/**
	 * 
	 * Builder used to manually instantiate objects using the DNI as String
	 * 
	 * @param dni
	 * @param street
	 * @param city
	 * @param autonomousRegion
	 * @param postalCode
	 * @param number
	 * @throws DNIException
	 */
	public Address(String dni, String street, String city, String autonomousRegion, int postalCode,
			String number) throws DNIException {

		setDni(dni);
		this.street = street;
		this.city = city;
		this.autonomousRegion = autonomousRegion;
		this.postalCode = postalCode;
		this.number = number;

	}

	/**
	 * Persistence constructor used to instantiate objects from the database
	 * 
	 * @param street
	 * @param city
	 * @param autonomousRegion
	 * @param number
	 * @param dni
	 * @param postalCode
	 */
	@PersistenceConstructor
	public Address(String street, String city, String autonomousRegion, String number, Handler dni,
			int postalCode) {
		super();
		this.street = street;
		this.city = city;
		this.autonomousRegion = autonomousRegion;
		this.number = number;
		this.dni = dni;
		this.postalCode = postalCode;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAutonomousRegion() {
		return autonomousRegion;
	}

	public void setAutonomousRegion(String autonomousRegion) {
		this.autonomousRegion = autonomousRegion;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Handler getDni() {
		return dni;
	}

	public void setDni(Handler dni) {
		this.dni = dni;
	}

	public void setDni(String dni) throws DNIException {
		this.dni = new DNIHandler(dni);
	}

	public int getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}

	public String getId() {
		return id;
	}

	@Override
	public String toString() {
		return "DireccionDomain [id=" + id + ", calle=" + street + ", localidad=" + city + ", comunidadAutonoma="
				+ autonomousRegion + ", numero=" + number + ", dni=" + dni + ", codigoPostal=" + postalCode + "]";
	}

}
