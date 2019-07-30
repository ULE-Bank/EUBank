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

public class CurrentAccountMovementPOJOTest {

	private static Validator validator;
	private CurrentAccountMovementPOJO movement;
	private Set<ConstraintViolation<CurrentAccountMovementPOJO>> constraintViolations;

	@BeforeClass
	public static void setUp() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Before
	public void setUpBeforeEach() {
		movement = new CurrentAccountMovementPOJO();
	}

	@Test
	public void testValue() {
		assertNull(movement.getValue());
		movement.setValue(150d);
		assertThat(movement.getValue(), is(150d));
	}

	@Test
	public void testConcept() {
		assertNull(movement.getConcept());
		movement.setConcept("concepto");
		assertThat(movement.getConcept(), is("concepto"));
	}

	@Test
	public void testDate() {
		assertNull(movement.getValueDate());
		movement.setValueDate("1994-12-05");
		assertThat(movement.getValueDate(), is("1994-12-05"));
	}
	
	@Test
	public void testOperation(){
		assertNull(movement.getOperation());
		movement.setOperation("D");;
		assertThat(movement.getOperation(), is("D"));
	}

	@Test
	public void testValueAnnotation() {
		validate();
		assertThat(constraintViolations.size(), is(4));
		movement.setConcept("c");
		validate();
		assertThat(constraintViolations.size(), is(3));
		movement.setValueDate("fecha");
		movement.setOperation("D");
		movement.setValue(300d);
		validate();
		assertThat(constraintViolations.size(), is(0));
		movement.setValue(-5d);
		validate();
		assertThat(constraintViolations.size(), is(1));
		assertThat(constraintViolations.iterator().next().getPropertyPath().toString(), is("value"));
	}
	
	private void validate(){
		constraintViolations = validator.validate(movement);
	}
}
