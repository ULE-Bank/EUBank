package es.unileon.ulebankoffice.repository;

import static com.lordofthejars.nosqlunit.mongodb.MongoDbRule.MongoDbRuleBuilder.newMongoDbRule;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.notNull;

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
import es.unileon.ulebankoffice.domain.Solicitud;

/**
 * @author Razvan Raducu
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MongoTestConfig.class)
public class SolicitudRepositoryTest {
		
	@Autowired
	Mongo mongo;

	@Autowired
	private ApplicationContext applicationContext;

	@Rule
	public MongoDbRule mongoDbRule = newMongoDbRule().defaultSpringMongoDb("ulebankofficetestdb");

	@Autowired
	private SolicitudRepository repo;
	
	@After
	public void afterEachMethod(){
		repo.deleteAll();
	}

	@Test
	public void isUsingFongo() {
		assertEquals("Fongo (ulebankofficetestdb)", mongo.toString());
	}
	
	
	@Test
	@UsingDataSet(locations = { "/testing/solicitudRepositoryData.json" }, 
	loadStrategy = LoadStrategyEnum.CLEAN_INSERT)
	public void testFindByProductId() {
		Solicitud solicitud = repo.findByProductId("id1");
		assertNotNull(solicitud);
		assertThat(solicitud.getEstado(), is("En trámite"));
		assertThat(solicitud.getFechaResolucion(), is(nullValue()));
		solicitud = repo.findByProductId("id2");
		assertThat(solicitud, is(notNullValue()));
		assertThat(solicitud.getEstado(), is("Aceptada"));
		assertThat(solicitud.getFechaResolucion(), is(notNullValue()));
		solicitud = repo.findByProductId("id3");
		assertThat(solicitud, is(notNullValue()));
		assertThat(solicitud.getEstado(), is("Aceptada"));
		assertThat(solicitud.getFechaResolucion(), is(notNullValue()));
		solicitud = repo.findByProductId("id4");
		assertThat(solicitud, is(notNullValue()));
		assertThat(solicitud.getEstado(), is("Cancelada"));
		assertThat(solicitud.getFechaResolucion(), is(notNullValue()));
	}
	
	@Test
	@UsingDataSet(locations = { "/testing/solicitudRepositoryData.json" }, 
	loadStrategy = LoadStrategyEnum.CLEAN_INSERT)
	public void testFindByProductIdNonExistent() {
		Solicitud solicitud = repo.findByProductId("id5");
		assertThat(solicitud, is(nullValue()));
		assertNull(solicitud);
	}
	
	@Test
	@UsingDataSet(locations = { "/testing/solicitudRepositoryData.json" }, 
	loadStrategy = LoadStrategyEnum.CLEAN_INSERT)
	public void testDelete() {
		List<Solicitud> solicitudes = repo.findAll();
		assertThat(solicitudes.size(), is(4));
		repo.delete(solicitudes.get(0));
		assertThat(repo.findAll().size(), is(3));
	}
	
	@Test
	@UsingDataSet(locations = { "/testing/solicitudRepositoryData.json" }, 
	loadStrategy = LoadStrategyEnum.CLEAN_INSERT)
	public void testDeleteByProductId() {
		List<Solicitud> solicitudes = repo.findAll();
		assertThat(solicitudes.size(), is(4));
		repo.deleteByProductId("id1");
		repo.deleteByProductId("id2");
		assertThat(repo.findAll().size(), is(2));
		repo.deleteByProductId("id8");
		assertThat(repo.findAll().size(), is(2));
	}
	
	@Test
	@UsingDataSet(locations = { "/testing/solicitudRepositoryData.json" }, 
	loadStrategy = LoadStrategyEnum.CLEAN_INSERT)
	public void testSave() {
		Solicitud solicitud = repo.findByProductId("id1");
		assertNotNull(solicitud);
		Solicitud solicitud2 = repo.findByProductId("id6");
		assertNull(solicitud2);
		assertThat(repo.findAll().size(), is(4));
		solicitud.setProductId("id6");
		
		repo.save(solicitud);
		assertThat(repo.findAll().size(), is(4));
		solicitud = repo.findByProductId("id1");
		assertNull(solicitud);
		solicitud2 = repo.findByProductId("id6");
		assertNotNull(solicitud2);
	}

}
