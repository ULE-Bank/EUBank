/**
 * 
 */
package es.unileon.ulebankoffice.repository;

import static com.lordofthejars.nosqlunit.mongodb.MongoDbRule.MongoDbRuleBuilder.newMongoDbRule;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import java.text.ParseException;
import java.util.Date;

import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lordofthejars.nosqlunit.annotation.UsingDataSet;
import com.lordofthejars.nosqlunit.core.LoadStrategyEnum;
import com.lordofthejars.nosqlunit.mongodb.MongoDbRule;
import com.mongodb.Mongo;

import es.unileon.ulebankoffice.configuration.MongoTestConfig;
import es.unileon.ulebankoffice.domain.Client;
import es.unileon.ulebankoffice.domain.DNIException;

/**
 * @author Razvan Raducu
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MongoTestConfig.class)
public class ClientRepositoryTest {

	@Autowired
	Mongo mongo;

	@Autowired
	private ApplicationContext applicationContext;

	@Rule
	public MongoDbRule mongoDbRule = newMongoDbRule().defaultSpringMongoDb("ulebankofficetestdb");

	@Autowired
	private ClientRepository clienteRepository;
	
	@After
	public void afterEachMethod(){
		clienteRepository.deleteAll();
	}
	

	@Test
	public void testNoRepeatedDNI() throws ParseException, DNIException {
		try {
			Client cliente = new Client("razvan", "raducu", "r@r.com", "1994-12-05","x5526828C", "español", new Date());
			Client cliente2 = new Client("razvan", "raducu", "r@r.com", "1994-02-05","x5526828C", "español", new Date());
			clienteRepository.save(cliente);
			clienteRepository.save(cliente2);
		} catch (Exception e) {
			assertEquals(e.getCause().getClass(), com.mongodb.DuplicateKeyException.class);
			assertEquals(1, clienteRepository.findAll().size());
			assertEquals(e.getClass(), org.springframework.dao.DuplicateKeyException.class);
		}
	}
	
	@Test
	public void isUsingFongo() {
		assertEquals("Fongo (ulebankofficetestdb)", mongo.toString());
	}

	@Test
	@UsingDataSet(locations = { "/testing/clientRepositoryData.json" }, 
	loadStrategy = LoadStrategyEnum.CLEAN_INSERT)
	public void testFindAll() throws ParseException, DNIException {
		
		assertEquals(1, clienteRepository.findAll().size());
		clienteRepository.save(new Client("razvan", "raducu", "r@r.com", "1994-12-05","X7077794G", "español", new Date()));
		clienteRepository.save(new Client("razvan", "raducu", "r@r.com", "1994-07-05","08336515G", "español", new Date()));
		assertEquals(3, clienteRepository.findAll().size());
	}
	
	@Test
	@UsingDataSet(locations = { "/testing/clientRepositoryData.json" }, 
	loadStrategy = LoadStrategyEnum.CLEAN_INSERT)
	public void testFindByDni(){
		Client cliente = clienteRepository.findByDni("X5526828C");
		assertEquals("Razvan", cliente.getName());
		assertEquals("Raducu", cliente.getLastName());
		
	}
	
	@Test
	@UsingDataSet(locations = { "/testing/clientRepositoryData.json" }, 
	loadStrategy = LoadStrategyEnum.CLEAN_INSERT)
	public void testFindByDniNonExistent(){
		
		Client cliente = clienteRepository.findByDni("R5526828C");
		
		//Hamcrest notation
		assertThat(cliente, is(nullValue()));
		
		assertNull(cliente);
		
	}
	

	@Test
	@UsingDataSet(locations = { "/testing/clientRepositoryData.json" }, 
	loadStrategy = LoadStrategyEnum.CLEAN_INSERT)
	public void testDeleteByDni(){
		
		assertThat(clienteRepository.findAll().size(), is(1));
		
		clienteRepository.deleteByDni("X5526828C");
		
		assertThat(clienteRepository.findAll().size(), is(0));
		
		Client cliente = clienteRepository.findByDni("X5526828C");
		
		assertNull(cliente);
		
	}
	
	@Test
	@UsingDataSet(locations = { "/testing/clientRepositoryData.json" }, 
	loadStrategy = LoadStrategyEnum.CLEAN_INSERT)
	public void testSave(){
		
		Client cliente = clienteRepository.findByDni("X5526828C");
		assertThat(cliente.getEmail(), is("rraduc00@estudiantes.unileon.es"));
		cliente.setEmail("email@example.com");
		clienteRepository.save(cliente);
		cliente = clienteRepository.findByDni("X5526828C");
		assertThat(cliente.getEmail(), is("email@example.com"));
	}
	
	@Test
	@UsingDataSet(locations = { "/testing/clientRepositoryData.json" }, 
	loadStrategy = LoadStrategyEnum.CLEAN_INSERT)
	public void testDeleteAll(){
		assertThat(clienteRepository.findAll().size(), is(1));
		clienteRepository.deleteAll();
		assertThat(clienteRepository.findAll().size(), is(0));
	}
}
