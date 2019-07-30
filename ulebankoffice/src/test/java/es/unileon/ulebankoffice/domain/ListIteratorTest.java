/**
 * 
 */
package es.unileon.ulebankoffice.domain;

import static com.lordofthejars.nosqlunit.mongodb.MongoDbRule.MongoDbRuleBuilder.newMongoDbRule;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.isA;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.util.ReflectionTestUtils;

import com.lordofthejars.nosqlunit.mongodb.MongoDbRule;
import com.mongodb.Mongo;

import es.unileon.ulebankoffice.configuration.MongoTestConfig;
import es.unileon.ulebankoffice.repository.DocumentoRepository;

/**
 * @author Razvan Raducu
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MongoTestConfig.class)
public class ListIteratorTest {

	private ListIterator<DocumentoAdjunto> iterator;
	private Documentos docus;
	private Iterator<DocumentoAdjunto> iteratorAux;

	@Autowired
	Mongo mongo;

	@Autowired
	private ApplicationContext applicationContext;

	@Rule
	public MongoDbRule mongoDbRule = newMongoDbRule().defaultSpringMongoDb("ulebankofficetestdb");

	@Autowired
	private DocumentoRepository repo;

	@Before
	public void setUp() throws Exception {
		docus = new Documentos(new ArrayList<String>());
		iterator = new ListIterator<>(docus);
		iteratorAux = docus.createIterator();
		ReflectionTestUtils.setField(docus, "repo", repo);
	}

	@Test
	public void testListIterator() {
		assertThat(docus.createIterator(), isA(Iterator.class));
		assertThat(docus.createIterator(), is(instanceOf(ListIterator.class)));
	}

	@Test
	public void testFirstElement() throws EmptyCollectionException {

		assertThat(docus.getSize(), is(0));
		assertThat(iterator.hasMoreElements(), is(iteratorAux.hasMoreElements()));
		assertThat(iteratorAux.hasMoreElements(), is(false));

		docus.add(new DocumentoAdjunto("ruta", "nameExample"));

		iteratorAux.firstElement();
		iterator.firstElement();

		assertThat(((DocumentoAdjunto) iteratorAux.currentElement()).getFechaCreacion(),
				is(((DocumentoAdjunto) iterator.currentElement()).getFechaCreacion()));
		assertThat(((DocumentoAdjunto) iterator.currentElement()).getName(), is("nameExample"));

	}

	@Test(expected = EmptyCollectionException.class)
	public void testFirstElementException() throws EmptyCollectionException {
		iterator.currentElement();
	}

	@Test
	public void testHasMoreElements() {

		assertThat(iterator.hasMoreElements(), is(false));
		assertThat(iteratorAux.hasMoreElements(), is(false));

	}

	@Test
	public void testCurrentElement() throws EmptyCollectionException {

		docus.add(new DocumentoAdjunto("ruta", "nameExample"));

		iteratorAux.firstElement();
		iterator.firstElement();

		assertThat(((DocumentoAdjunto) iteratorAux.currentElement()).getFechaCreacion(),
				is(((DocumentoAdjunto) iterator.currentElement()).getFechaCreacion()));
		assertThat(((DocumentoAdjunto) iterator.currentElement()).getName(), is("nameExample"));

	}

}
