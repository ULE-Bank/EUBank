package es.unileon.ulebankoffice.service;

import javax.validation.constraints.NotNull;

public class NewAdminQuestionPOJO {
	
	@NotNull
	private String pregunta;
	
	@NotNull
	private String ponderacion;

	public String getPregunta() {
		return pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	public String getPonderacion() {
		return ponderacion;
	}

	public void setPonderacion(String ponderacion) {
		this.ponderacion = ponderacion;
	}
}
