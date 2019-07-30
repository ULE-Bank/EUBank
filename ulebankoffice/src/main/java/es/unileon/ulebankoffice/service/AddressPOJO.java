package es.unileon.ulebankoffice.service;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

/**
 * @author Razvan Raducu
 *
 */
public class AddressPOJO {

	@NotBlank
	private String street;
	
	@NotBlank
	private String number;
	
	//Not empty only works with string, collections, maps or arrays
	@NotNull @Min(0)
	private int postalCode;
	
	@NotBlank
	private String city;
	
	@NotBlank
	private String autonomousRegion;
	
	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public int getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
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

	@Override
	public String toString() {
		return "Direccion [calle=" + street + ", numero=" + number + ", codigoPostal=" + postalCode
				+ ", localidad=" + city + ", comunidadAutonoma=" + autonomousRegion + "]";
	}	
	
}
