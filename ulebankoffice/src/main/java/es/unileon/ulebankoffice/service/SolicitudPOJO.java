package es.unileon.ulebankoffice.service;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author Razvan Raducu
 *
 */

public class SolicitudPOJO {

	@NotBlank
	@NotEmpty
	private String estado; // Se seleccionará estado de entre varios
							// predefinidos

	@NotBlank
	@NotEmpty
	@Past
	private String fechaApertura;

	@NotBlank
	@NotNull
	private String dni;

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getFechaApertura() {
		return fechaApertura;
	}

	public void setFechaApertura(String fechaApertura) {
		this.fechaApertura = fechaApertura;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

}
