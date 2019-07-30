/**
 * 
 */
package es.unileon.ulebankoffice.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Razvan Raducu
 *
 */
@Document(collection = "UleBankEmployees")
public class UleBankEmployee {

	@Id
	private String id;
	@Indexed(unique=true)
	private String userName;
	private String password;
	private String role;

	/**
	 * Constructor principal. Se ha declarado este construcotr para controlar la
	 * instanciación de esta clase. El constructor parameterless se ha obviado.
	 * 
	 * @param userName
	 * @param password
	 * @param role
	 */
	@PersistenceConstructor
	public UleBankEmployee(String userName, String password, String role) {
		this.userName = userName;
		this.password = password;
		this.role = role;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getId() {
		return id;
	}
	
	

}
