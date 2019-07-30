package es.unileon.ulebankoffice.domain;

public class QuestionInfo {
	
	private String id;
	private String title;
	private String state;
	
	public QuestionInfo(String id, String title, String state) {
		this.id = id;
		this.title = title;
		this.state = state;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
}
