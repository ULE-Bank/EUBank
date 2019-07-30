package es.unileon.ulebankoffice.repository;
/**
 * @author Razvan Raducu
 *
 */

import com.lordofthejars.nosqlunit.annotation.UsingDataSet;
import com.lordofthejars.nosqlunit.core.LoadStrategyEnum;
import com.lordofthejars.nosqlunit.mongodb.MongoDbRule;
import com.mongodb.Mongo;
import es.unileon.ulebankoffice.configuration.MongoTestConfig;
import es.unileon.ulebankoffice.domain.DocumentoAdjunto;
import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static com.lordofthejars.nosqlunit.mongodb.MongoDbRule.MongoDbRuleBuilder.newMongoDbRule;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MongoTestConfig.class)
public class DocumentoRepositoryTest {

	@Autowired
	Mongo mongo;

	@Autowired
	private ApplicationContext applicationContext;

	@Rule
	public MongoDbRule mongoDbRule = newMongoDbRule().defaultSpringMongoDb("ulebankofficetestdb");

	@Autowired
	private DocumentoRepository repo;

	@After
	public void afterEachMethod() throws Exception {
		repo.deleteAll();
	}

	@Test
	public void isUsingFongo() {
		assertEquals("Fongo (ulebankofficetestdb)", mongo.toString());
	}

	@Test
	@UsingDataSet(locations = { "/testing/documentoRepositoryData.json" }, loadStrategy = LoadStrategyEnum.CLEAN_INSERT)
	public void testFindById() {
		DocumentoAdjunto documento = repo.findById("documentId1");
		assertThat(documento.getId(), is("documentId1"));
		assertThat(documento.getRuta(), is("c/ruta/de/ejemplo"));

		documento = repo.findById("documentId2");
		assertThat(documento.getId(), is("documentId2"));
		assertThat(documento.getRuta(), is("etc/var/lib"));

		documento = repo.findById("documentId3");
		assertThat(documento.getId(), is("documentId3"));
		assertThat(documento.getRuta(), is("etc/var/lib"));

		documento = repo.findById("documentId4");
		assertThat(documento.getId(), is("documentId4"));
		assertThat(documento.getRuta(), is("etc/var/lib"));

		documento = repo.findById("documentId5");
		assertThat(documento.getId(), is("documentId5"));
		assertThat(documento.getRuta(), is("etc/var/lib"));

		documento = repo.findById("documentId6");
		assertThat(documento.getId(), is("documentId6"));
		assertThat(documento.getRuta(), is("c/ruta/de/ejemplo2"));

		assertThat(repo.findAll().size(), is(6));

	}

	@Test
	@UsingDataSet(locations = { "/testing/documentoRepositoryData.json" }, loadStrategy = LoadStrategyEnum.CLEAN_INSERT)
	public void testDeleteById() {
		assertThat(repo.findAll().size(), is(6));

		repo.delete("documentId6");

		assertThat(repo.findAll().size(), is(5));

		assertNull(repo.findById("documentId6"));

	}

	@Test
	@UsingDataSet(locations = { "/testing/documentoRepositoryData.json" }, loadStrategy = LoadStrategyEnum.CLEAN_INSERT)
	public void testDelete() {
		assertThat(repo.findAll().size(), is(6));
		DocumentoAdjunto documento = repo.findById("documentId6");
		assertThat(documento.getId(), is("documentId6"));
		assertNotNull(documento);

		repo.delete(documento);

		assertThat(repo.findAll().size(), is(5));

		assertNull(repo.findById("documentId6"));

	}

	@Test
	@UsingDataSet(locations = { "/testing/documentoRepositoryData.json" }, loadStrategy = LoadStrategyEnum.CLEAN_INSERT)
	public void testDeleteByIdPageable() {

		List<String> listaIds = new ArrayList<>();
		listaIds.add("documentId6");
		listaIds.add("documentId1");
		listaIds.add("documentId2");

		assertThat(repo.findAll().size(), is(6));

		assertNotNull(repo.findById("documentId6"));

		repo.deleteByIdIn(listaIds);

		assertThat(repo.findAll().size(), is(3));

		assertNull(repo.findById("documentId6"));

	}

	@Test
	@UsingDataSet(locations = { "/testing/documentoRepositoryData.json" }, loadStrategy = LoadStrategyEnum.CLEAN_INSERT)
	public void testSave() {
		assertThat(repo.findAll().size(), is(6));

		DocumentoAdjunto documento = repo.findById("documentId6");

		documento.setRuta("path/ex/ample");

		repo.save(documento);

		assertThat(repo.findAll().size(), is(6));

		documento = repo.findById("documentId6");

		assertThat(documento.getRuta(), is("path/ex/ample"));

	}

	@Test
	@UsingDataSet(locations = { "/testing/documentoRepositoryData.json" }, loadStrategy = LoadStrategyEnum.CLEAN_INSERT)
	public void testFindByIdPageable() {

		List<String> listaIds = new ArrayList<>();
		listaIds.add("documentId6");
		listaIds.add("documentId1");
		listaIds.add("documentId2");

		List<DocumentoAdjunto> listaDocumentos = repo.findByIdIn(listaIds);

		assertThat(listaDocumentos.size(), is(3));
		for (DocumentoAdjunto documentoAdjuntoDomain : listaDocumentos) {
			assertThat(documentoAdjuntoDomain.getName(),
					anyOf(equalTo("documento1"), equalTo("documento2"), equalTo("documento6")));
		}

		repo.delete("documentId6");
		repo.delete("documentId1");

		assertThat(repo.findAll().size(), is(4));

		listaDocumentos = repo.findByIdIn(listaIds);
		assertThat(listaDocumentos.size(), is(1));
		assertThat(listaDocumentos.get(0).getName(), is("documento2"));
		
		listaIds.add("documentId2");
		assertThat(listaIds.size(), is(4));
		listaDocumentos = repo.findByIdIn(listaIds);
		assertThat(listaDocumentos.size(), is(1));
		assertThat(listaDocumentos.get(0).getName(), is("documento2"));

	}

	@Test
	@UsingDataSet(locations = { "/testing/documentoRepositoryData.json" }, loadStrategy = LoadStrategyEnum.CLEAN_INSERT)
	public void testFindByIdPageableDateAsc() {

		List<String> listaIds = new ArrayList<>();
		listaIds.add("documentId6");
		listaIds.add("documentId1");
		listaIds.add("documentId2");
		listaIds.add("documentId3");
		listaIds.add("documentId4");
		listaIds.add("documentId5");

		List<DocumentoAdjunto> listaDocumentos = repo.findByIdInOrderByFechaCreacionAsc(listaIds);

		assertThat(listaDocumentos.size(), is(6));
		
		assertThat(listaDocumentos.get(0).getName(), is("documento3"));
		assertThat(listaDocumentos.get(1).getName(), is("documento5"));
		assertThat(listaDocumentos.get(2).getName(), is("documento6"));
		assertThat(listaDocumentos.get(3).getName(), is("documento4"));
		assertThat(listaDocumentos.get(4).getName(), is("documento2"));
		assertThat(listaDocumentos.get(5).getName(), is("documento1"));
		
		
	}
	
}
