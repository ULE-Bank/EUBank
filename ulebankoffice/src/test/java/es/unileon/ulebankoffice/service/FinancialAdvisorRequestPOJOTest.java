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

public class FinancialAdvisorRequestPOJOTest {
	
	private static Validator validator;
	private Set<ConstraintViolation<FinancialAdvisorRequestPOJO>> constraintViolations;
	private FinancialAdvisorRequestPOJO solicitud;
	
	@BeforeClass
	public static void setUpClass() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}
	
	@Before
	public void setUp() throws Exception {
		solicitud = new FinancialAdvisorRequestPOJO();
	}

	@Test
	public void testOfferText() {
		assertNull(solicitud.getOfferText());
		solicitud.setOfferText("texto");
		assertThat(solicitud.getOfferText(), is("texto"));
		
	}

	@Test
	public void testOfferUrl() {
		assertNull(solicitud.getOfferUrl());
		solicitud.setOfferUrl("url");
		assertThat(solicitud.getOfferUrl(), is("url"));
	}

	@Test
	public void testOfferMatter() {
		assertNull(solicitud.getOfferMatter());
		solicitud.setOfferMatter("asunto");
		assertThat(solicitud.getOfferMatter(), is("asunto"));
	}

	@Test
	public void testValidator(){
		solicitud.setOfferMatter("asunto");
		solicitud.setOfferText("texto");
		solicitud.setOfferUrl("url");
		
		validate();
		assertThat(constraintViolations.size(), is(0));
		
		solicitud.setOfferMatter("");
		validate();
		assertThat(constraintViolations.size(), is(1));
		assertThat(constraintViolations.iterator().next().getPropertyPath().toString(), is("offerMatter"));
		solicitud.setOfferMatter("asunto");
		
		solicitud.setOfferText("");
		validate();
		assertThat(constraintViolations.size(), is(1));
		assertThat(constraintViolations.iterator().next().getPropertyPath().toString(), is("offerText"));
		solicitud.setOfferText("texto");
		
	}
	
	private void validate(){
		constraintViolations = validator.validate(solicitud);
	}
}
