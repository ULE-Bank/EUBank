/**
 * 
 */
package es.unileon.ulebankoffice.web;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import es.unileon.ulebankoffice.service.VariableInterest;
import es.unileon.ulebankoffice.service.TAESeveralInterestsPOJO;

/**
 * @author Razvan Raducu
 *
 */
public class TAESeveralInterestValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return TAESeveralInterestsPOJO.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		int i = 0;
		TAESeveralInterestsPOJO tae = (TAESeveralInterestsPOJO) target;

		for (VariableInterest interest : tae.getInterests()) {
			double interesAux = interest.getInterest();
			if (interesAux < 0) {		
				/*
				 * This generates dependency between the view and the business model/controller
				 * If I change the name of the field from intereses[0].interes to interest[0].interes 
				 * there is an unnecessary 
				 */
				errors.rejectValue("intereses[" + i + "].interes", "fieldIsLessThanZero");
			}
			i++;
		}
	}
}
