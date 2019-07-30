/**
 * 
 */
package es.unileon.ulebankoffice.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import es.unileon.ulebankoffice.domain.CurrentAccount;

/**
 * @author Razvan Raducu
 *
 */
@Repository
public interface CurrentAccountRepository extends MongoRepository<CurrentAccount, String> {

	/**
	 * This method searches for all current accounts associated with a client (DNI)
	 * 
	 * @param dni of the client
	 * @return List of current accounts associated with the DNI.
	 * 			List of 0 elements returned if 0 accounts are found.
	 */
	@Query("{'dni._id':?0}")
	public List<CurrentAccount> findByDni(String dni);

	/**
	 * It deletes all current accounts associated with a client
	 * 
	 * @param dni of the client.
	 */
	@Query(value = "{'dni._id' : ?0}", delete = true)
	public void deleteByDni(String dni);

	/**
	 * Method that returns the instance of the current account using an
	 * account number (unique)
	 * 
	 * @param accountNumber
	 * @return The instance of the account or null if nothing is found.
	 */
	public CurrentAccount findByAccountNumber(String accountNumber);

}
