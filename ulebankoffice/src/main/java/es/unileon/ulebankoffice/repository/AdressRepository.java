/**
 * 
 */
package es.unileon.ulebankoffice.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import es.unileon.ulebankoffice.domain.Address;

/**
 * @author Razvan Raducu
 *
 */
@Repository
public interface AdressRepository extends MongoRepository<Address, String> {
	
	/**
	 * It searches for all the addresses associated with a client through the DNI
	 * @param dni of the client
	 * @return list of directions
	 */
	@Query("{'dni._id':?0}")
	public List<Address> findByDni(String dni);
	
	
	/**
	 * Deletes all directions associated with a client
	 * @param dni of the directions to be deleted
	 */
	@Query(value="{'dni._id' : ?0}", delete = true)
	public void deleteByDni(String dni);
}
