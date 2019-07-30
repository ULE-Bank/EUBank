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

public class UleBankEmployeePOJOTest {
	
	private static Validator validator;
	private Set<ConstraintViolation<UleBankEmployeePOJO>> constraintViolations;
	private UleBankEmployeePOJO employee;
	
	@BeforeClass
	public static void setUpClass() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Before
	public void setUp() throws Exception {
		employee = new UleBankEmployeePOJO();
	}

	@Test
	public void testUserName() {
		assertNull(employee.getUserName());
		employee.setUserName("user");
		assertThat(employee.getUserName(), is("user"));
	}


	@Test
	public void testPassword() {
		assertNull(employee.getPassword());
		employee.setPassword("pass");
		assertThat(employee.getPassword(), is("pass"));
	}


	@Test
	public void testRole() {
		assertNull(employee.getRole());
		employee.setRole("role");
		assertThat(employee.getRole(), is("role"));
		
	}
	
	@Test
	public void testValidator(){
		employee.setPassword("pass");
		employee.setRole("role");
		employee.setUserName("user");
		
		validate();
		assertThat(constraintViolations.size(), is(0));
		
		employee.setPassword("");
		validate();
		assertThat(constraintViolations.size(), is(1));
		assertThat(constraintViolations.iterator().next().getPropertyPath().toString(), is("password"));
		employee.setPassword("pass");
		
		employee.setRole("");
		validate();
		assertThat(constraintViolations.size(), is(1));
		assertThat(constraintViolations.iterator().next().getPropertyPath().toString(), is("role"));
		employee.setRole("role");
		
		employee.setUserName("");
		validate();
		assertThat(constraintViolations.size(), is(1));
		assertThat(constraintViolations.iterator().next().getPropertyPath().toString(), is("userName"));
		
	}
	
	private void validate(){
		constraintViolations = validator.validate(employee);
	}
	
}
