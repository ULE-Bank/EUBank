package es.unileon.ulebankoffice.service;

import javax.validation.constraints.NotNull;

public class AdminAnswerPOJO {
	
	@NotNull
	private String answer;
	
	 private String email;
	 private String idConsulta;

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIdConsulta() {
		return idConsulta;
	}

	public void setIdConsulta(String idConsulta) {
		this.idConsulta = idConsulta;
	}
	
	
}
