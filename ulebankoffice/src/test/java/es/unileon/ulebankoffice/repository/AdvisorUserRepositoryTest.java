package es.unileon.ulebankoffice.repository;

import static com.lordofthejars.nosqlunit.mongodb.MongoDbRule.MongoDbRuleBuilder.newMongoDbRule;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

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
import es.unileon.ulebankoffice.domain.AdvisorUser;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MongoTestConfig.class)
public class AdvisorUserRepositoryTest {
	
	@Autowired
	Mongo mongo;

	@Autowired
	private ApplicationContext applicationContext;

	@Rule
	public MongoDbRule mongoDbRule = newMongoDbRule().defaultSpringMongoDb("ulebankofficetestdb");

	
	@Autowired
	private AdvisorUserRepository repo;
	

	@After
	public void afterEachMethor(){
		repo.deleteAll();
	}
	
	@Test
	public void isUsingFongo() {
		assertEquals("Fongo (ulebankofficetestdb)", mongo.toString());
	}
	
	
	@Test
	@UsingDataSet(locations = { "/testing/advisorUserRepositoryData.json" }, 
	loadStrategy = LoadStrategyEnum.CLEAN_INSERT)
	public void testFindByEmail() {
		assertNull(repo.findByEmail("emailquenoexiste"));
	}
	
	@Test
	@UsingDataSet(locations = { "/testing/advisorUserRepositoryData.json" }, 
	loadStrategy = LoadStrategyEnum.CLEAN_INSERT)
	public void testFindAll(){
		assertThat(repo.findAll().size(), is(1));
		
	}
	
	@Test
	public void testSave(){
		assertThat(repo.findAll().size(), is(0));
		repo.save(new AdvisorUser());
		assertThat(repo.findAll().size(), is(1));
	}
	
	@Test
	@UsingDataSet(locations = { "/testing/advisorUserRepositoryData.json" }, 
	loadStrategy = LoadStrategyEnum.CLEAN_INSERT)
	public void testDeleteAll(){
		assertThat(repo.findAll().size(), is(1));
		repo.save(new AdvisorUser());
		assertThat(repo.findAll().size(), is(2));
		repo.deleteAll();
		assertThat(repo.findAll().size(), is(0));
	}
	
	@Test
	@UsingDataSet(locations = { "/testing/advisorUserRepositoryData.json" }, 
	loadStrategy = LoadStrategyEnum.CLEAN_INSERT)
	public void testDelete(){
		assertThat(repo.findAll().size(), is(1));
		AdvisorUser user = repo.findByEmail("email@example.com");
		repo.delete(user);
		assertThat(repo.findAll().size(), is(0));
	}
	
}
