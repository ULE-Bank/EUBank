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
@Document(collection = "AdvisorUsers")
public class AdvisorUser {

	@Id
	private String id;
	private String email;
	/* Primitive, false by default */

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getId() {
		return id;
	}

}
