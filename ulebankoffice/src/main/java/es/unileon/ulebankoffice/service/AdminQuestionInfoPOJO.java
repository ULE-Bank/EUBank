package es.unileon.ulebankoffice.service;

public class AdminQuestionInfoPOJO {
	
	private String pregunta;
	private String ponderacion;
	
	public AdminQuestionInfoPOJO(String pregunta, String ponderacion) {
		this.pregunta = pregunta;
		this.ponderacion = ponderacion;
	}

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
