/**
 * 
 */
package es.unileon.ulebankoffice.security;

import static com.lordofthejars.nosqlunit.mongodb.MongoDbRule.MongoDbRuleBuilder.newMongoDbRule;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.util.ReflectionTestUtils;

import com.lordofthejars.nosqlunit.annotation.UsingDataSet;
import com.lordofthejars.nosqlunit.core.LoadStrategyEnum;
import com.lordofthejars.nosqlunit.mongodb.MongoDbRule;
import com.mongodb.Mongo;

import es.unileon.ulebankoffice.configuration.MongoTestConfig;
import es.unileon.ulebankoffice.repository.AdvisorUserRepository;

/**
 * @author Razvan Raducu
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MongoTestConfig.class)
public class EmailAdvisorUserDetailsServiceTest {

	@Autowired
	Mongo mongo;

	@Autowired
	private ApplicationContext applicationContext;

	@Rule
	public MongoDbRule mongoDbRule = newMongoDbRule().defaultSpringMongoDb("ulebankofficetestdb");

	private EmailAdvisorUserDetailsService service;

	@Autowired
	private AdvisorUserRepository repo;

	@Before
	public void setUp() throws Exception {
		service = new EmailAdvisorUserDetailsService();
		ReflectionTestUtils.setField(service, "repo", repo);
	}

	@After
	public void afterEachTest() {
		repo.deleteAll();
	}

	@Test
	public void isUsingFongo() {
		assertEquals("Fongo (ulebankofficetestdb)", mongo.toString());
	}

	@Test
	@UsingDataSet(locations = {
			"/testing/advisorUserRepositoryData.json" }, loadStrategy = LoadStrategyEnum.CLEAN_INSERT)
	public void testLoadUserByUsername() {
		UserDetails user = service.loadUserByUsername("email@example.com");
		assertThat(user.getUsername(), is("email@example.com"));
		assertThat(user.getPassword(), is(""));
	}

	@Test(expected = UsernameNotFoundException.class)
	@UsingDataSet(locations = {
			"/testing/advisorUserRepositoryData.json" }, loadStrategy = LoadStrategyEnum.CLEAN_INSERT)
	public void testLoadUserByUsernameWithoutDot() {
		UserDetails user = service.loadUserByUsername("user@user");
		assertNull(user);
	}

	@Test(expected = UsernameNotFoundException.class)
	@UsingDataSet(locations = {
			"/testing/advisorUserRepositoryData.json" }, loadStrategy = LoadStrategyEnum.CLEAN_INSERT)
	public void testLoadUserByUsernameWithoutAt() {
		UserDetails user = service.loadUserByUsername("user.user");
		assertNull(user);
	}

	@Test(expected = UsernameNotFoundException.class)
	@UsingDataSet(locations = {
			"/testing/advisorUserRepositoryData.json" }, loadStrategy = LoadStrategyEnum.CLEAN_INSERT)
	public void testLoadUserByUsernameWithoutDotAfterAt() {
		UserDetails user = service.loadUserByUsername("user.user@user");
		assertNull(user);
	}
	
	@Test
	@UsingDataSet(locations = {
			"/testing/advisorUserRepositoryData.json" }, loadStrategy = LoadStrategyEnum.CLEAN_INSERT)
	public void testRegisterNewUser() {
		assertNull(repo.findByEmail("user@inexistente.com"));
		UserDetails user = service.loadUserByUsername("user@inexistente.com");
		assertNotNull(user);
		assertNotNull(repo.findByEmail("user@inexistente.com"));
	}

}
