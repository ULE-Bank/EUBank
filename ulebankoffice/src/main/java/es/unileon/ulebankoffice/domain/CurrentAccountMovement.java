/**
 * 
 */
package es.unileon.ulebankoffice.domain;

import java.util.Date;

/**
 * @author Razvan Raducu
 *
 */
public class CurrentAccountMovement {

	private Double value;
	private String concept;
	private Date valueDate;
	private String operation;

	public CurrentAccountMovement() {
		 // The empty constructor is necessary to instantiate the modelAttributes
	}

	/**
	 * Date is received using the Date class.
	 * 
	 * @param value
	 * @param concept
	 * @param date
	 * @param operation
	 */
	public CurrentAccountMovement(Double value, String concept, Date date, String operation) {
		this.value = value;
		this.concept = concept;
		this.valueDate = date;
		this.operation = operation;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public String getConcept() {
		return concept;
	}

	public void setConcept(String concept) {
		this.concept = concept;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public Date getValueDate() {
		return valueDate;
	}

	public void setValueDate(Date valueDate) {
		this.valueDate = valueDate;
	}
}
