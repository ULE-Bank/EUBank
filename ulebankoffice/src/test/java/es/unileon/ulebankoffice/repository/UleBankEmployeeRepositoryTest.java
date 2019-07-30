package es.unileon.ulebankoffice.repository;

import static com.lordofthejars.nosqlunit.mongodb.MongoDbRule.MongoDbRuleBuilder.newMongoDbRule;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import java.util.List;

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
import es.unileon.ulebankoffice.domain.UleBankEmployee;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MongoTestConfig.class)
public class UleBankEmployeeRepositoryTest {
	
	@Autowired
	Mongo mongo;

	@Autowired
	private ApplicationContext applicationContext;

	@Rule
	public MongoDbRule mongoDbRule = newMongoDbRule().defaultSpringMongoDb("ulebankofficetestdb");

	@Autowired
	private UleBankEmployeeRepository repo;

	@After
	public void afterEachMethor(){
		repo.deleteAll();
	}
	
	@Test
	public void isUsingFongo() {
		assertEquals("Fongo (ulebankofficetestdb)", mongo.toString());
	}
	
	@Test
	@UsingDataSet(locations = { "/testing/uleBankEmployeeRepositoryData.json" }, 
	loadStrategy = LoadStrategyEnum.CLEAN_INSERT)
	public void testFindByUserName() {
		UleBankEmployee employee = repo.findByUserName("cjrulebank");
		assertThat(employee.getRole(), is("admin"));
	}
	
	@Test
	@UsingDataSet(locations = { "/testing/uleBankEmployeeRepositoryData.json" }, 
	loadStrategy = LoadStrategyEnum.CLEAN_INSERT)
	public void testFindByUserNameNonExistent() {
		UleBankEmployee employee = repo.findByUserName("notanuser");
		assertNull(employee);
	}

	@Test
	@UsingDataSet(locations = { "/testing/uleBankEmployeeRepositoryData.json" }, 
	loadStrategy = LoadStrategyEnum.CLEAN_INSERT)
	public void testFindByRole() {
		List<UleBankEmployee> users = repo.findByRole("user");
		assertThat(users.size(), is(1));
	}
	
	@Test
	@UsingDataSet(locations = { "/testing/uleBankEmployeeRepositoryData.json" }, 
	loadStrategy = LoadStrategyEnum.CLEAN_INSERT)
	public void testAddDuplicated() {
		List<UleBankEmployee> employees = repo.findAll();
		assertThat(employees.size(), is(4));
		try {
			repo.save(new UleBankEmployee("cjrulebank", "pass", "role"));
		} catch (Exception e) {
			assertEquals(e.getCause().getClass(), com.mongodb.DuplicateKeyException.class);
			assertEquals(4, repo.findAll().size());
			assertEquals(e.getClass(), org.springframework.dao.DuplicateKeyException.class);
		}
		
	}
	
	@Test
	@UsingDataSet(locations = { "/testing/uleBankEmployeeRepositoryData.json" }, 
	loadStrategy = LoadStrategyEnum.CLEAN_INSERT)
	public void testSave() {
		List<UleBankEmployee> employees = repo.findAll();
		assertThat(employees.size(), is(4));
		repo.save(new UleBankEmployee("anotheruser", "passowrd", "user"));
		employees = repo.findAll();
		assertThat(employees.size(), is(5));
	}
	
	@Test
	@UsingDataSet(locations = { "/testing/uleBankEmployeeRepositoryData.json" }, 
	loadStrategy = LoadStrategyEnum.CLEAN_INSERT)
	public void testDelete() {
		List<UleBankEmployee> employees = repo.findAll();
		assertThat(employees.size(), is(4));
		repo.delete(employees);
		employees = repo.findAll();
		assertThat(employees.size(), is(0));
	}
	
	
}
