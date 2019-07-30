package es.unileon.ulebankoffice.service;
import javax.validation.constraints.NotNull;

public class NewQuestionPOJO {
	
	
	@NotNull
	private String url;
	
	@NotNull
	private String comentarios;
	

	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getComentarios() {
		return comentarios;
	}
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
	
}
