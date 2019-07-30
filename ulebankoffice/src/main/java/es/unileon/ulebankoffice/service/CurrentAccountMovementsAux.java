/**
 * 
 */
package es.unileon.ulebankoffice.service;

import java.util.List;

import javax.validation.Valid;

/**
 * @author Razvan Raducu
 *
 */
public class CurrentAccountMovementsAux {
	
	@Valid
	private List<CurrentAccountMovementPOJO> movements;

	public List<CurrentAccountMovementPOJO> getMovements() {
		return movements;
	}

	public void setMovements(List<CurrentAccountMovementPOJO> movements) {
		this.movements = movements;
	}
	
	
	
}
