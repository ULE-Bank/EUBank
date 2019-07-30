package es.unileon.ulebankoffice.domain;

import java.util.Date;

/**
 * @author Razvan Raducu
 *
 */
public interface FinancialProduct {
	public Date getApplicationDate();
	public Date getResolutionDate();
	public Date getFinalizationDate();
	public String getStatus();
	public Handler getDni();
	
}
