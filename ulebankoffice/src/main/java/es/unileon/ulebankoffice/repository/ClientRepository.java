/**
 * 
 */
package es.unileon.ulebankoffice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import es.unileon.ulebankoffice.domain.Client;

/**
 * @author Razvan Raducu
 *
 */
@Repository
public interface ClientRepository extends MongoRepository<Client, String> {

	/**
	 * It's designed to obtain from the clients' database. 
	 * In the @Query which is used when it's invoked regex with case sensitive 
	 * ("options = 'i') is been used.
	 * 
	 * @param dni of the client
	 *            
	 * @return The Client object instantiated or null if the DNI doesn't match anyone.
	 */
	@Query(value="{'dni._id':{$regex : ?0, $options: 'i'}}")
	public Client findByDni(String dni);

	/**
	 * It deletes the client from the database.
	 * 
	 * @param dni of the client who is going to be deleted.
	 *            
	 */
	@Query(value = "{'dni._id' : ?0}", delete = true)
	public void deleteByDni(String dni);

}
