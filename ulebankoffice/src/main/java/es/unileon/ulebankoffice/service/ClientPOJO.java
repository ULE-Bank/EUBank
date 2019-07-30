package es.unileon.ulebankoffice.service;

import org.hibernate.validator.constraints.NotBlank;

/**
 * @author Razvan Raducu
 *
 */

public class ClientPOJO {

	@NotBlank
	private String name; 
	@NotBlank
	private String lastName; 
	@NotBlank
	private String email;

	@NotBlank
	private String birthDate;

	@NotBlank
	private String dni;
	
	@NotBlank
	private String citizenship;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastname) {
		this.lastName = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
	
	@Override
	public String toString() {
		return "Cliente [name=" + name + ", lastname=" + lastName + ", email=" + email
				+ ", fechaNacimiento=" + birthDate + ", dni=" + dni + "]";
	}

	public String getCitizenship() {
		return citizenship;
	}

	public void setCitizenship(String citizenship) {
		this.citizenship = citizenship;
	}

}
