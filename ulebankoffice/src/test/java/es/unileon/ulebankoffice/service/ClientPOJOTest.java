package es.unileon.ulebankoffice.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ClientPOJOTest {

	private static Validator validator;
	private Set<ConstraintViolation<ClientPOJO>> constraintViolations;
	
	private ClientPOJO cliente;

	@BeforeClass
	public static void setUpClass() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Before
	public void setUp() throws Exception {
		cliente = new ClientPOJO();
	}

	@Test
	public void testName() {
		assertNull(cliente.getName());
		cliente.setName("NombreCliente");
		assertThat(cliente.getName(), is("NombreCliente"));

	}

	@Test
	public void testLastname() {
		assertNull(cliente.getLastName());
		cliente.setLastName("LastNameCliente");
		assertThat(cliente.getLastName(), is("LastNameCliente"));
	}

	@Test
	public void testEmail() {
		assertNull(cliente.getEmail());
		cliente.setEmail("email@example.eg");
		assertThat(cliente.getEmail(), is("email@example.eg"));
	}

	@Test
	public void testBirthDate() {
		assertNull(cliente.getBirthDate());
		cliente.setBirthDate("1994-12-05");
		assertThat(cliente.getBirthDate(), is("1994-12-05"));
	}

	@Test
	public void testDni() {
		assertNull(cliente.getDni());
		cliente.setDni("x5526828c");
		assertThat(cliente.getDni(), is("x5526828c"));
	}

	@Test
	public void testToString() {
		assertThat(cliente.toString(),
				is("Cliente [name=null, lastname=null, email=null, fechaNacimiento=null, dni=null]"));
	}
	
	@Test
	public void testCitizenship() {
		assertNull(cliente.getCitizenship());
		cliente.setCitizenship("Español");
		assertThat(cliente.getCitizenship(), is("Español"));
	}

	@Test
	public void testValidator() {
		cliente.setDni("x5526828C");
		cliente.setEmail("email");
		cliente.setBirthDate("fecha");
		cliente.setLastName("lastname");
		cliente.setName("name");
		cliente.setCitizenship("español");
		
		validate();
		assertThat(constraintViolations.size(), is(0));
		
		cliente.setDni("");
		validate();
		assertThat(constraintViolations.size(), is(1));
		assertThat(constraintViolations.iterator().next().getPropertyPath().toString(), is("dni"));
		cliente.setDni("x5526828C");
		validate();
		assertThat(constraintViolations.size(), is(0));
		cliente.setDni("                           ");
		validate();
		assertThat(constraintViolations.size(), is(1));
		cliente.setDni("x");
		
		
		cliente.setEmail("");
		validate();
		assertThat(constraintViolations.size(), is(1));
		assertThat(constraintViolations.iterator().next().getPropertyPath().toString(), is("email"));
		
		cliente.setEmail("      ");
		validate();
		assertThat(constraintViolations.size(), is(1));
		assertThat(constraintViolations.iterator().next().getPropertyPath().toString(), is("email"));
		
		cliente.setEmail("email");
		validate();
		assertThat(constraintViolations.size(), is(0));
		
		cliente.setBirthDate("");
		validate();
		assertThat(constraintViolations.size(), is(1));
		assertThat(constraintViolations.iterator().next().getPropertyPath().toString(), is("birthDate"));
		
		cliente.setBirthDate("   ");
		validate();
		assertThat(constraintViolations.size(), is(1));
		assertThat(constraintViolations.iterator().next().getPropertyPath().toString(), is("birthDate"));

		cliente.setBirthDate("fecha");
		validate();
		assertThat(constraintViolations.size(), is(0));

		cliente.setLastName("");
		validate();
		assertThat(constraintViolations.size(), is(1));
		assertThat(constraintViolations.iterator().next().getPropertyPath().toString(), is("lastName"));
	
		cliente.setLastName("    ");
		validate();
		assertThat(constraintViolations.size(), is(1));
		assertThat(constraintViolations.iterator().next().getPropertyPath().toString(), is("lastName"));
		
		cliente.setLastName("lastNAme");
		validate();
		assertThat(constraintViolations.size(), is(0));

		cliente.setName("");
		validate();
		assertThat(constraintViolations.size(), is(1));
		assertThat(constraintViolations.iterator().next().getPropertyPath().toString(), is("name"));
		
		cliente.setName("          ");
		validate();
		assertThat(constraintViolations.size(), is(1));
		assertThat(constraintViolations.iterator().next().getPropertyPath().toString(), is("name"));
		
		cliente.setName("name");
		validate();
		assertThat(constraintViolations.size(), is(0));
		
	}
	
	private void validate(){
		constraintViolations = validator.validate(cliente);
	}
}
