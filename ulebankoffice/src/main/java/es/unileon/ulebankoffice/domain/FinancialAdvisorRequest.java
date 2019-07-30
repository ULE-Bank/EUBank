/**
 * 
 */
package es.unileon.ulebankoffice.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import es.unileon.ulebankoffice.service.InvestorProfile;

/**
 * @author Razvan Raducu
 *
 */
@Document(collection = "SolicitudesFinancialAdvisor")
public class FinancialAdvisorRequest {

	@Id
	private String id;
	private String email;
	private String offerText;
	private String offerUrl;
	private String status;
	private String fileBlobKey;
	private String offerMatter;
	private String offerResponse;
	/*
	 * ATENCIÓN!!! Guardar al fecha en formato String es una mala práctica y
	 * supone un mal diseño. La persona que lea esto debería encargarse de
	 * cambiar. Yo lo hice así porque no he tenido más tiempo. Este mensaje fue
	 * escrito el 01.06.2017
	 */
	private String creationDate;
	
	private boolean testAnswered;
	private Answers testAnswers;
	private String profile;
	private double testResult;
	
	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}
	public double getTestResult() {
		return testResult;
	}

	public void setTestResult(double testResult) {
		this.testResult = testResult;
	}
	
	public void setTestAnswers(Answers testAnswers) {
		this.testAnswers = testAnswers;
	}
	
	public Answers getTestAnswers() {
		return this.testAnswers;
	}
	

	public boolean isTestAnswered() {
		return testAnswered;
	}

	public void setTestAnswered(boolean testAnswered) {
		this.testAnswered = testAnswered;
	}

	public void generateInvestorProfile() {
		InvestorProfile investorProfile = new InvestorProfile();
		this.testResult = investorProfile.getResultTest(this.testAnswers);
		this.profile = investorProfile.getInvestorProfile(this.testAnswers);
	}

	public String getOfferText() {
		return offerText;
	}

	public void setOfferText(String offerText) {
		this.offerText = offerText;
	}

	public String getOfferUrl() {
		return offerUrl;
	}

	public void setOfferUrl (String offerUrl) {
		this.offerUrl = offerUrl;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFileBlobKey() {
		return fileBlobKey;
	}

	public void setFileBlobKey(String fileBlobKey) {
		this.fileBlobKey = fileBlobKey;
	}

	public String getId() {
		return id;
	}

	public String getOfferMatter() {
		return offerMatter;
	}

	public void setOfferMatter(String offerMatter) {
		this.offerMatter = offerMatter;
	}

	public String getOfferResponse() {
		return offerResponse;
	}

	public void setOfferResponse(String offerResponse) {
		this.offerResponse = offerResponse;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

}
