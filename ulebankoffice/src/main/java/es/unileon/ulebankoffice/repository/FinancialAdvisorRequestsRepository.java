/**
 * 
 */
package es.unileon.ulebankoffice.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import es.unileon.ulebankoffice.domain.FinancialAdvisorRequest;

/**
 * @author Razvan Raducu
 *
 */
public interface FinancialAdvisorRequestsRepository extends MongoRepository<FinancialAdvisorRequest, String> {
		
		public FinancialAdvisorRequest findById(String id);
		public List<FinancialAdvisorRequest> findByEmailOrderByStatusDesc(String email);
		public List<FinancialAdvisorRequest> findAllByOrderByStatusDesc();
	
}
