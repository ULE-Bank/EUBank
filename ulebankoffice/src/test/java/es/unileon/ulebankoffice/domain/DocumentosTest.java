package es.unileon.ulebankoffice.domain;

import static com.lordofthejars.nosqlunit.mongodb.MongoDbRule.MongoDbRuleBuilder.newMongoDbRule;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.isA;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.util.ReflectionTestUtils;

import com.lordofthejars.nosqlunit.annotation.UsingDataSet;
import com.lordofthejars.nosqlunit.core.LoadStrategyEnum;
import com.lordofthejars.nosqlunit.mongodb.MongoDbRule;
import com.mongodb.Mongo;

import es.unileon.ulebankoffice.configuration.MongoTestConfig;
import es.unileon.ulebankoffice.repository.DocumentoRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MongoTestConfig.class)
public class DocumentosTest {

	@Autowired
	Mongo mongo;

	@Autowired
	private ApplicationContext applicationContext;

	@Rule
	public MongoDbRule mongoDbRule = newMongoDbRule().defaultSpringMongoDb("ulebankofficetestdb");

	private Documentos documentos;

	@Autowired
	private DocumentoRepository repository;

	@Before
	public void setUp() throws Exception {
		documentos = new Documentos(new ArrayList<String>());
		ReflectionTestUtils.setField(documentos, "repo", repository);

	}

	@After
	public void afterEachTest() {
		repository.deleteAll();
	}

	@Test
	public void isUsingFongo() {
		assertEquals("Fongo (ulebankofficetestdb)", mongo.toString());
	}

	@Test
	@UsingDataSet(locations = { "/testing/documentoRepositoryData.json" }, loadStrategy = LoadStrategyEnum.CLEAN_INSERT)
	public void testAddDocumento() {
		assertThat(repository.findAll().size(), is(6));
		assertThat(documentos.getSize(), is(0));
		documentos.add(new DocumentoAdjunto("rutaEjemplo", "NombreEjemplo"));
		assertThat(repository.findAll().size(), is(7));
		assertThat(documentos.getSize(), is(1));
	}

	@Test
	public void testMongoIdAssignment() {

		// Al hacer maven test el tamaño es 7, otherwise es 0.

		assertThat(repository.findAll().size(), is(0));
		assertThat(documentos.getSize(), is(0));

		for (DocumentoAdjunto documentos : repository.findAll()) {
			System.out.println(documentos + ":D");
		}

		DocumentoAdjunto documento = new DocumentoAdjunto("rutaE", "nameE");

		assertNull(documento.getId());
		documentos.add(documento);
		assertNotNull(documento.getId());
		assertThat(repository.findAll().size(), is(1));

		assertThat(documento.getId(), is(repository.findAll().get(0).getId()));

	}

	@Test
	public void testGetSize() {
		List<String> idDocumentos = new ArrayList<>();
		idDocumentos.add("documentId1");
		idDocumentos.add("documentId2");
		idDocumentos.add("documentId3");

		documentos = new Documentos(idDocumentos);

		assertThat(documentos.getSize(), is(3));

		idDocumentos.add("documentId4");
		idDocumentos.add("documentId5");
		idDocumentos.add("documentId6");

		assertThat(documentos.getSize(), is(6));
	}

	@Test
	public void testGetElement() throws EmptyCollectionException {
		assertThat(documentos.getSize(), is(0));
		documentos.add(new DocumentoAdjunto("ruta1", "nombre1"));
		documentos.add(new DocumentoAdjunto("ruta3", "nombre3"));
		documentos.add(new DocumentoAdjunto("ruta2", "nombre2"));
		assertThat(documentos.getSize(), is(3));
		DocumentoAdjunto documento = (DocumentoAdjunto) documentos.getElement(0);
		assertThat(documento.getRuta(), is("ruta1"));
		documento = (DocumentoAdjunto) documentos.getElement(1);
		assertThat(documento.getName(), is("nombre3"));
		documento = (DocumentoAdjunto) documentos.getElement(2);
		assertThat(documento.getRuta(), is("ruta2"));
	}

	@Test
	public void testRemove() throws EmptyCollectionException {
		assertThat(documentos.getSize(), is(0));
		documentos.add(new DocumentoAdjunto("ruta1", "nombre1"));
		documentos.add(new DocumentoAdjunto("ruta3", "nombre3"));
		documentos.add(new DocumentoAdjunto("ruta2", "nombre2"));
		assertThat(documentos.getSize(), is(3));
		DocumentoAdjunto documento = (DocumentoAdjunto) documentos.getElement(0);
		assertThat(documento.getRuta(), is("ruta1"));
		documentos.remove(0);
		documento = (DocumentoAdjunto) documentos.getElement(0);
		assertThat(documento.getRuta(), is("ruta3"));
	}

	@Test
	public void testCreateIterator() {
		assertThat(documentos.createIterator(), isA(Iterator.class));
		assertThat(documentos.createIterator(), is(instanceOf(ListIterator.class)));
	}

	@Test
	@UsingDataSet(locations = { "/testing/documentoRepositoryData.json" }, loadStrategy = LoadStrategyEnum.CLEAN_INSERT)
	public void testAdd() {
		assertThat(documentos.getSize(), is(0));

		documentos.add(new DocumentoAdjunto("ruta", "name"));
		assertThat(documentos.getSize(), is(1));

		documentos.add(new DocumentoAdjunto("ruta", "name"));
		assertThat(documentos.getSize(), is(2));

	}

}
