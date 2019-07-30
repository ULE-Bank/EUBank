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

public class CurrentAccountClientAddressPOJOTest {
	
	private static Validator validator;
	private Set<ConstraintViolation<CurrentAccountClientAddressPOJO>> constraintViolations;
	private CurrentAccountClientAddressPOJO test;
	
	@BeforeClass
	public static void setUpClass() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}
	
	@Before
	public void setUp() throws Exception {
		test = new CurrentAccountClientAddressPOJO();
	}

	@Test
	public void testCliente() {
		assertNull(test.getClient());
		test.setClient(new ClientPOJO());
		assertNull(test.getClient().getDni());
	}


	@Test
	public void testAddress() {
		assertNull(test.getAddress());
		test.setAddress(new AddressPOJO());
		assertNull(test.getAddress().getStreet());
	}

	@Test
	public void testCurrentAccount() {
		assertNull(test.getCurrentAccount());
		test.setCurrentAccount(new CurrentAccountPOJO());
		assertThat(test.getCurrentAccount().getLiquidationPeriod(), is(0));
	}
	
	@Test
	public void testValidator(){
		test.setClient(new ClientPOJO());
		test.setCurrentAccount(new CurrentAccountPOJO());
		test.setAddress(new AddressPOJO());
		
		validate();
		assertThat(constraintViolations.size(), is(16));
	}

	private void validate(){
		constraintViolations = validator.validate(test);
	}
	
}
