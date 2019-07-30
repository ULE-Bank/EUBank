/**
 * 
 */
package es.unileon.ulebankoffice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import es.unileon.ulebankoffice.domain.AdvisorUser;

/**
 * @author Razvan Raducu
 *
 */
public interface AdvisorUserRepository extends MongoRepository<AdvisorUser, String> {
	
	public AdvisorUser findByEmail(String email);
	
}
