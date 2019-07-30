/**
 * 
 */
package es.unileon.ulebankoffice.service;

import java.util.List;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Razvan Raducu
 *
 */
public class FinancialAdvisorRequestPOJO {
	
	@NotBlank
	private String offerText;

	private String offerUrl;
	
	@NotBlank
	private String offerMatter;
	
    private List<MultipartFile> files;
    
    public List<MultipartFile> getFiles() {
        return this.files;
    }
 
    public void setFiles(List<MultipartFile> files) {
        this.files = files;
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
	public String getOfferMatter() {
		return offerMatter;
	}
	public void setOfferMatter (String offerMatter) {
		this.offerMatter = offerMatter;
	}

	
}
