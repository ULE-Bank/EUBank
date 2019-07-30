package es.unileon.ulebankoffice.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ReverseMortgagePOJOTest {

	private static Validator validator;
	private Set<ConstraintViolation<ReverseMortgagePOJO>> constraintViolations;
	private ReverseMortgagePOJO mortgage;
	
	@BeforeClass
	public static void setUpClass() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Before
	public void setUp() throws Exception {
		mortgage = new ReverseMortgagePOJO();
	}

	@Test
	public void testValueValuation() {
		assertThat(mortgage.getValueValuation(), is(0.0));
		mortgage.setValueValuation(1.1);
		assertThat(mortgage.getValueValuation(), is(1.1));
	}



	@Test
	public void testAge() {
		assertThat(mortgage.getAge(), is(0));
		mortgage.setAge(5);
		assertThat(mortgage.getAge(), is(5));
	}


	@Test
	public void testPercentageOverValuation() {
		assertThat(mortgage.getPercentageOverValuation(), is(0.0));
		mortgage.setPercentageOverValuation(5.0);
		assertThat(mortgage.getPercentageOverValuation(), is(5.0));
	}

	@Test
	public void testInterestLoanRate() {
		assertThat(mortgage.getInterestLoanRate(), is(0.0));
		mortgage.setInterestLoanRate(5.0);
		assertThat(mortgage.getInterestLoanRate(), is(5.0));
	}

	@Test
	public void testOpeningComission() {
		assertThat(mortgage.getOpeningComission(), is(0.0));
		mortgage.setOpeningComission(5.0);
		assertThat(mortgage.getOpeningComission(), is(5.0));
	}

	@Test
	public void testRentProfitability() {
		assertThat(mortgage.getRentProfitability(), is(0.0));
		mortgage.setRentProfitability(5.0);
		assertThat(mortgage.getRentProfitability(), is(5.0));
	}

	@Test
	public void testValuationCost() {
		assertThat(mortgage.getValuationCost(), is(0.0));
		mortgage.setValuationCost(5.0);
		assertThat(mortgage.getValuationCost(), is(5.0));
	}


	@Test
	public void testFormalizationExpenses() {
		assertThat(mortgage.getFormalizationExpenses(), is(0.0));
		mortgage.setFormalizationExpenses(5.0);
		assertThat(mortgage.getFormalizationExpenses(), is(5.0));
	}
	
	@Test
	public void testValidator(){
		
		mortgage.setValueValuation(-1.0);
		mortgage.setAge(67);
		validate();
		assertThat(constraintViolations.size(), is(1));
		assertThat(constraintViolations.iterator().next().getPropertyPath().toString(), is("valueValuation"));
		mortgage.setValueValuation(1.0);
		validate();
		assertThat(constraintViolations.size(), is(0));
		
		mortgage.setAge(63);
		validate();
		assertThat(constraintViolations.size(), is(1));
		assertThat(constraintViolations.iterator().next().getPropertyPath().toString(), is("age"));
		
		mortgage.setAge(69);
		validate();
		assertThat(constraintViolations.size(), is(0));
		
		mortgage.setAge(90);
		validate();
		assertThat(constraintViolations.size(), is(1));
		assertThat(constraintViolations.iterator().next().getPropertyPath().toString(), is("age"));
		mortgage.setAge(67);
		
		/**
		 * The labels are equals for all of the attributes. 
		 * That's why the same test isn't repeated for all of them
		 */
		
		mortgage.setPercentageOverValuation(-5.0);
		validate();
		assertThat(constraintViolations.size(), is(1));
		assertThat(constraintViolations.iterator().next().getPropertyPath().toString(), is("percentageOverValuation"));
		
		
	}
	
	private void validate(){
		constraintViolations = validator.validate(mortgage);
	}



}
