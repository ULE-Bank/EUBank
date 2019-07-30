/**
 * 
 */
package es.unileon.ulebankoffice.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Razvan Raducu
 *
 */
public class CreditMovementsPOJOTest {

	private static Validator validator;
	private CreditMovementsPOJO movement;
	private Set<ConstraintViolation<CreditMovementsPOJO>> constraintViolations;
	
	@BeforeClass
	   public static void setUpClass() {
	      ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	      validator = factory.getValidator();
	   }
	
	@Before
	public void setUp() throws Exception {
		movement = new CreditMovementsPOJO();
		movement.setMovementDescription("Movimiento test");
		movement.setMovementDate("1994-12-05");
		movement.setMovementValue(150000d);
		movement.setOperation("I");
	}


	@Test
	public void testGetMovementDescription() {
		assertThat(movement.getMovementDescription(), is("Movimiento test"));
	}

	@Test
	public void testGetMovementValue() {
		assertThat(movement.getMovementValue(), is(150000.0));
	}

	@Test
	public void testGetMovementDate() {
		assertThat(movement.getMovementDate(), is("1994-12-05"));
	}

	@Test
	public void testGetOperation() {
		assertThat(movement.getOperation(), is("I"));
	}
	
	@Test
	public void testAnnotationDescription(){
		validate();
		assertThat(constraintViolations.size(), is(0));
		movement.setMovementDescription("");
		validate();
		assertThat(constraintViolations.size(), is(1));
		assertThat(constraintViolations.iterator().next().getPropertyPath().toString(), is("movementDescription"));
	}
	
	@Test
	public void testAnnotationValue(){
		validate();
		assertThat(constraintViolations.size(), is(0));
		movement.setMovementValue(-150d);
		validate();
		assertThat(constraintViolations.size(), is(1));
		assertThat(constraintViolations.iterator().next().getPropertyPath().toString(), is("movementValue"));
	}
	
	@Test
	public void testAnnotationDate(){
		validate();
		assertThat(constraintViolations.size(), is(0));
		movement.setMovementDate("");
		validate();
		assertThat(constraintViolations.size(), is(1));
		assertThat(constraintViolations.iterator().next().getPropertyPath().toString(), is("movementDate"));
	}
	
	
	private void validate(){
		constraintViolations = validator.validate(movement);
	}
	
}
