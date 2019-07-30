/**
 * 
 */
package es.unileon.ulebankoffice.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import es.unileon.ulebankoffice.domain.UleBankEmployee;

/**
 * @author Razvan Raducu
 *
 */
@Repository
public interface UleBankEmployeeRepository extends MongoRepository<UleBankEmployee, String> {
	
	public UleBankEmployee findByUserName(String username);
	
	public List<UleBankEmployee> findByRole(String role);
	
}
