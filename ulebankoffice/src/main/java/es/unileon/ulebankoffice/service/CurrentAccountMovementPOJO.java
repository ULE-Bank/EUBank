/**
 * 
 */
package es.unileon.ulebankoffice.service;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

/**
 * @author Razvan Raducu
 *
 */
public class CurrentAccountMovementPOJO {

    @NotNull @Min(0)
	private Double value;
	@NotBlank
	private String concept;
	@NotBlank
	private String valueDate;
	@NotBlank
	private String operation;

	public Double getValue() {
		return value;
	}
	
	public String getConcept(){
		return concept;
	}
	
	public void setValue(Double value) {
		this.value = value;
	}

	public void setConcept(String concept) {
		this.concept = concept;
	}

	public String getValueDate() {
		return valueDate;
	}

	public void setValueDate(String valueDate) {
		this.valueDate = valueDate;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}
	
	
	
}
