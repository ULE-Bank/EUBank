/**
 * 
 */
package es.unileon.ulebankoffice.domain;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Razvan Raducu
 *
 */
@Document(collection = "CurrentAccounts")
public class CurrentAccount extends Operation implements FinancialProduct {

	@Id
	private String id;

	private Date openingDate;
	private Double creditorInterests;
	private Double debtorInterestOverNegativeBalance;
	private Double capitalPerformanceRetention;
	private Double maintenanceComission;
	private Double maintenanceDeficit;
	private Double minMaintenanceDeficit;
	private Date applicationDate;
	private Date resolutionDate;
	private Date finalizationDate;
	private int annualDays;
	private int liquidationPeriod;

	private String accountNumber;

	private Double totalBalance;
	private Double blockedBalance;
	private String status;

	private Handler dni;

	private List<CurrentAccountMovement> movements;

	private Documentos documents;
	
	private String finalCreditorInterests;
	private String finalPerformanceRetention;
	private String finalDebtorInterests;
	private String finalDeficitComission;
	private String totalLiquidation;
	
	private Date lastLiquidation;

	/**
	 * Builder used to manually instantiate objects.
	 * Movements and documents are added later.
	 * 
	 * @param openingDate
	 * @param creditorInterests
	 * @param debtorInterestOverNegativeBalance
	 * @param capitalPerformanceRetention
	 * @param maintenanceComission
	 * @param maintenanceDeficit
	 * @param minMaintenanceDeficit
	 * @param applicationDate
	 * @param totalBalance
	 * @param status
	 * @param dni
	 * @param annualDays
	 * @param liquidationPeriod
	 */
	public CurrentAccount(Date openingDate, Double creditorInterests,
			Double debtorInterestOverNegativeBalance, Double capitalPerformanceRetention, Double maintenanceComission,
			Double maintenanceDeficit, Double minMaintenanceDeficit, Date applicationDate, Double totalBalance,
			Double blockedBalance, String status, Handler dni, int annualDays, int liquidationPeriod) {
		this.openingDate = openingDate;
		this.creditorInterests = creditorInterests;
		this.debtorInterestOverNegativeBalance = debtorInterestOverNegativeBalance;
		this.capitalPerformanceRetention = capitalPerformanceRetention;
		this.maintenanceComission = maintenanceComission;
		this.maintenanceDeficit = maintenanceDeficit;
		this.minMaintenanceDeficit = minMaintenanceDeficit;
		this.applicationDate = applicationDate;
		this.totalBalance = totalBalance;
		this.blockedBalance = blockedBalance;
		this.status = status;
		this.dni = dni;
		this.annualDays = annualDays;
		this.liquidationPeriod = liquidationPeriod;
	}

	/**
	 * Builder used to instantiate objects from the database
	 * 
	 * @param openingDate
	 * @param creditorInterests
	 * @param debtorInterestOverNegativeBalance
	 * @param capitalPerformanceRetention
	 * @param maintenanceComission
	 * @param maintenanceDeficit
	 * @param minMaintenanceDeficit
	 * @param applicationDate
	 * @param balance
	 * @param status
	 * @param dni
	 * @param annualDays
	 * @param liquidationPeriod
	 */
	@PersistenceConstructor
	public CurrentAccount(Date openingDate, Double creditorInterests,
			Double debtorInterestOverNegativeBalance, Double capitalPerformanceRetention, Double maintenanceComission,
			Double maintenanceDeficit, Double minMaintenanceDeficit, Date applicationDate, Date resolutionDate,
			Date finalizationDate, Double totalBalance, Double blockedBalance, String status, Handler dni,
			List<CurrentAccountMovement> movements, Documentos documents, int annualDays,
			int liquidationPeriod) {
		this.openingDate = openingDate;
		this.creditorInterests = creditorInterests;
		this.debtorInterestOverNegativeBalance = debtorInterestOverNegativeBalance;
		this.capitalPerformanceRetention = capitalPerformanceRetention;
		this.maintenanceComission = maintenanceComission;
		this.maintenanceDeficit = maintenanceDeficit;
		this.minMaintenanceDeficit = minMaintenanceDeficit;
		this.applicationDate = applicationDate;
		this.resolutionDate = resolutionDate;
		this.finalizationDate = finalizationDate;
		this.totalBalance = totalBalance;
		this.blockedBalance = blockedBalance;
		this.status = status;
		this.dni = dni;
		this.movements = movements;
		this.documents = documents;
		this.annualDays = annualDays;
		this.liquidationPeriod = liquidationPeriod;
	}

	/**
	 * 
	 * Method used to obtain the liquidation between the received dates.
	 * The liquidation is made using the movements between the two dates.
	 * 
	 * @param initLiquidationDate
	 * @param finalLiquidationDate
	 * @param isPermanent 
	 * @return The table to be shown. As requested by Javier (the client)
	 * 			the numbers must be expressed in European notation.
	 * 			<b>Protip:<b>
	 * 			The output of this method is a list of rows where the numbers
	 * 			are already formatted and the currency is added (€ default)
	 * 			The ideal case would be that the currency could be received
	 * 			through the web page as a parameter.
	 */
	public List<List<String>> makeLiquidation(Date initLiquidationDate, Date finalLiquidationDate, boolean isPermanent) {

		List<CurrentAccountMovement> liquidationMovements = obtenerMovimientosLiquidacion(
				initLiquidationDate, finalLiquidationDate);

		List<List<String>> table = new ArrayList<>();

		List<String> tableItem;
		List<Double> balanceList = new ArrayList<>();
		List<Integer> daysList = new ArrayList<>();
		List<Double> creditorNumbersList = new ArrayList<>();
		List<Double> debtorNumbersList = new ArrayList<>();
		int index = 0;
		DecimalFormat decimalFormatter = new DecimalFormat("#,##0.00");
		decimalFormatter.setDecimalFormatSymbols(new DecimalFormatSymbols(Locale.GERMAN));
		String deposit = "I";
		String currency = "€";

		/*
		 * The logic behind this is to print the table by rows.
		 */

		for (CurrentAccountMovement currentAccountMovement : liquidationMovements) {

			tableItem = new ArrayList<>();

			/* First column: date */
			DateTime date = new DateTime(currentAccountMovement.getValueDate());
			tableItem.add(date.getDayOfMonth() + "-" + date.getMonthOfYear() + "-" + date.getYear());

			/* Second column: Concept */
			tableItem.add(currentAccountMovement.getConcept());

			/* Third and forth column: Deposits or provisions */
			if (currentAccountMovement.getOperation().equals(deposit)) {
				tableItem.add(decimalFormatter.format(currentAccountMovement.getValue()) + currency);
				tableItem.add("-");
			} else {
				tableItem.add("-");
				tableItem.add(decimalFormatter.format(currentAccountMovement.getValue()) + currency);
			}

			/* Fifth column: The balance before computing the movement */
			Double concreteBalance = currentAccountMovement.getValue();

			Double concreteBalanceOperate = currentAccountMovement.getOperation().equals(deposit) ? concreteBalance
					: -concreteBalance;

			if (balanceList.isEmpty()) {
				balanceList.add(concreteBalanceOperate);
				tableItem.add(decimalFormatter.format(round(balanceList.get(index))) + currency);
			} else {
				balanceList.add(concreteBalanceOperate + balanceList.get(index - 1));
				tableItem.add(decimalFormatter.format(round(balanceList.get(index))) + currency);
			}

			/* Sixth column: The days about the next movement. */
			DateTime nextDay;
			Days days;
			if (index + 1 < liquidationMovements.size()) {
				// If it reaches here, it isn't the last movement.
				nextDay = new DateTime(liquidationMovements.get(index + 1).getValueDate());
				days = Days.daysBetween(date, nextDay);
				daysList.add(days.getDays());
			} else {
				nextDay = new DateTime(finalLiquidationDate);
				days = Days.daysBetween(date, nextDay);
				daysList.add(days.getDays());
			}
			tableItem.add(Integer.toString(days.getDays()));

			/*
			 * Seventh and eighth column: Creditor numbers and debtor numbers.
			 */
			Double currentBalance = balanceList.get(index);
			if (currentBalance >= 0) {
				creditorNumbersList.add(currentBalance * daysList.get(index));
				tableItem.add(decimalFormatter
						.format(round(creditorNumbersList.get(creditorNumbersList.size() - 1))) + currency);
				tableItem.add("-");
			} else {
				debtorNumbersList.add(currentBalance * daysList.get(index));
				tableItem.add("-");
				tableItem.add(
						decimalFormatter.format(round(debtorNumbersList.get(debtorNumbersList.size() - 1)))
								+ currency);
			}

			table.add(tableItem);
			index++;
		}

		/* Liquidation is made by using the computed data */
		int totalDays = 0;
		double totalCreditorNumbers = 0;
		double totalDebtorNumbers = 0;
		double biggerNegativeBalance = 0;

		for (Integer days : daysList) {
			totalDays += days;
		}

		for (Double nCreditor : creditorNumbersList) {
			totalCreditorNumbers += nCreditor;
		}

		for (Double nDebtor : debtorNumbersList) {
			totalDebtorNumbers += nDebtor;
		}

		for (Double balanceAux : balanceList) {
			if (balanceAux < 0 && balanceAux < biggerNegativeBalance) {
				biggerNegativeBalance = balanceAux;
			}
		}

		double creditorInterestsFinalAux = (totalCreditorNumbers * creditorInterests) / (annualDays * 100);
		double performanceWithholdingFinalAux = (capitalPerformanceRetention * creditorInterestsFinalAux) / 100;
		double debtorInterestsFinalAux = (totalDebtorNumbers * debtorInterestOverNegativeBalance)
				/ (annualDays * 100);
		double deficitComissionFinalAux = biggerNegativeBalance * maintenanceDeficit;
		deficitComissionFinalAux = deficitComissionFinalAux < minMaintenanceDeficit ? minMaintenanceDeficit
				: deficitComissionFinalAux;

		creditorInterestsFinalAux = round(creditorInterestsFinalAux);
		performanceWithholdingFinalAux = round(performanceWithholdingFinalAux);
		
		/* 
		 * Because it's a negative number, I convert it to positive to make
		 * a regular subtraction.
		 */
		debtorInterestsFinalAux = round(-debtorInterestsFinalAux);

		double totalLiquidationFinal = creditorInterestsFinalAux - performanceWithholdingFinalAux - debtorInterestsFinalAux
				- deficitComissionFinalAux - maintenanceComission;
		
				
		/* Last movement is the liquidation */
		tableItem = new ArrayList<>();
		DateTime liquidationDate = new DateTime(finalLiquidationDate);
		tableItem.add(liquidationDate.getDayOfMonth() + "-" + liquidationDate.getMonthOfYear() + "-" + liquidationDate.getYear());
		tableItem.add("Liquidacion");
		if (totalLiquidationFinal >= 0) {
			tableItem.add(decimalFormatter.format(round(totalLiquidationFinal)) + currency);
			tableItem.add("-");
		} else {
			tableItem.add("-");
			/*
			 * I change the sign in order to avoid a negative number in the table.
			 */
			tableItem.add(decimalFormatter.format(round(-totalLiquidationFinal)) + currency);
		}
		
		/* 
		 * If no movement has been added in this step, 
		 * balanceList.size()-1 isn't made to avoid a nullPointerException
		 */
		
		if(!balanceList.isEmpty()){
		tableItem
				.add(decimalFormatter.format(round(balanceList.get(balanceList.size() - 1) + totalLiquidationFinal))
						+ currency);
		} else{
			tableItem.add(Double.toString(this.totalBalance + totalLiquidationFinal));
					
		}

		tableItem.add(Integer.toString(totalDays));
		tableItem.add(decimalFormatter.format(round(totalCreditorNumbers)) + currency);
		tableItem.add(decimalFormatter.format(round(totalDebtorNumbers)) + currency);

		table.add(tableItem);
		this.finalCreditorInterests = decimalFormatter.format(round(creditorInterestsFinalAux))+currency;
		this.finalPerformanceRetention = decimalFormatter.format(round( performanceWithholdingFinalAux))+currency;
		this.finalDebtorInterests = decimalFormatter.format(round(debtorInterestsFinalAux ))+currency;
		this.finalDeficitComission =decimalFormatter.format(round(deficitComissionFinalAux))+currency;
		this.totalLiquidation = decimalFormatter.format(round(totalLiquidationFinal))+currency;
			
		
		if(isPermanent) {	
			double liquiTotalAux = totalLiquidationFinal < 0 ? -totalLiquidationFinal : totalLiquidationFinal;
			this.movements.add(new CurrentAccountMovement(round(liquiTotalAux), "Liquidación", finalLiquidationDate, "D"));
			this.totalBalance += totalLiquidationFinal;
			this.totalBalance = round(this.totalBalance);
			this.lastLiquidation = finalLiquidationDate;
		}

		return table;
	}
	


	/*
	 * A este método le falta optimización. Lo ideal sería llevar un contador de
	 * movimientos que ya han sido liquidados, de esta forma no se recorrerían
	 * todos siempre. Animo a la persona que esté leyendo esto y que haya venido
	 * detrás de mi a hacerlo ya que yo no he tenido tiempo. En cuanto haya
	 * muchos movimientos si se tiene que recorrer toda la coleccion siempre
	 * esto va a ser luz fuego destrucción.
	 * 
	 * This method needs optimisation. A counter of the already payed off movements
	 * would be better. 
	 */
	private List<CurrentAccountMovement> obtenerMovimientosLiquidacion(Date fechaInicio, Date fechaFinal) {

		List<CurrentAccountMovement> movimientosLiquidacion = new ArrayList<>();
		for (CurrentAccountMovement movimientoCuentaCorrienteDomain : movements) {
			Date fechaMovimiento = movimientoCuentaCorrienteDomain.getValueDate();
			if (!fechaMovimiento.after(fechaFinal) && !fechaMovimiento.before(fechaInicio)) {
				/*
				 * Puesto que before y after no incluyen los "endpoints", es
				 * decir que after 2017-05-10 es true a partir de 2017-05-11 y
				 * before 2017-05-10 es true a partir de 2017-05-09 y hacia
				 * atrás, es preciso hacer lo siguiente: En lugar de
				 * after(FechaInicio) y before(fechaFinal) que serían exclusive,
				 * no se incluirían las propias fechas, se hace
				 * !after(fechaFinal) y !before(fechaInicio).
				 */
				movimientosLiquidacion.add(movimientoCuentaCorrienteDomain);
			}
		}
		return movimientosLiquidacion;

	}

	private void orderMovementsByDate() {
		Collections.sort(this.movements, new Comparator<CurrentAccountMovement>() {
			@Override
			public int compare(CurrentAccountMovement m1, CurrentAccountMovement m2) {
				return m1.getValueDate().compareTo(m2.getValueDate());
			}
		});
	}
	
	public String getLastLiquidationDate() {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String lastLiquidationString;
		if(this.lastLiquidation == null) {
			lastLiquidationString = "none";
		}else {
			lastLiquidationString = df.format(this.lastLiquidation);
		}
		
		return lastLiquidationString;
	}

	@Override
	public Date getApplicationDate() {
		return applicationDate;
	}

	public void setApplicationDate(Date applicationDate) {
		this.applicationDate = applicationDate;
	}

	@Override
	public Date getResolutionDate() {
		return resolutionDate;
	}

	public void setResolutionDate(Date resolutionDate) {
		this.resolutionDate = resolutionDate;
	}

	@Override
	public Date getFinalizationDate() {
		return finalizationDate;
	}

	public void setFinalizationDate(Date finalizationDate) {
		this.finalizationDate = finalizationDate;
	}

	@Override
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public Handler getDni() {
		return dni;
	}

	public void setDni(Handler dni) {
		this.dni = dni;
	}

	public List<CurrentAccountMovement> getMovements() {
		return movements;
	}

	public void setMovementes(List<CurrentAccountMovement> movements) {
		this.movements = movements;
	}

	/**
	 * Adds the amount, given as a parameter, to the current balance
	 * 
	 * @param balance
	 */
	public void depositBalance(double balance) {
		this.totalBalance += balance;
	}

	/**
	 * Extracts the indicated amount of the balance.
	 * 
	 * @param balance
	 */
	public void extractBalance(double balance) {
		this.totalBalance -= balance;
	}

	/**
	 * Adds to the list of movements the movement given as a parameter.
	 * In this method, all movements are ordered by the date when a new one is 
	 * introduced.
	 * 
	 * @param movement
	 */
	public void addMovement(CurrentAccountMovement movement) {
		this.movements.add(movement);
		orderMovementsByDate();
	}
	
	public void removeMovement(int index) {
		this.movements.remove(index);
	}
	
	/**
	 * 
	 * Adds the document to the database as well as to the list of ids
	 * associated with the current account
	 * 
	 * @param document
	 */
	public void addDocument(DocumentoAdjunto document) {
		documents.add(document);
	}

	public List<DocumentoAdjunto> getDocuments() throws EmptyCollectionException {
		// This code substitutes: return documents.getDocuments()

		Iterator<DocumentoAdjunto> iterator = documents.createIterator();
		List<DocumentoAdjunto> docsList = new ArrayList<>();

		for (iterator.firstElement(); iterator.hasMoreElements(); iterator.nextElement()) {

			docsList.add((DocumentoAdjunto) iterator.currentElement());

		}
		return docsList;
	}

	public String getId() {
		return id;
	}

	public Date getOpeningDate() {
		return openingDate;
	}

	public void setOpeningDate(Date openingDate) {
		this.openingDate = openingDate;
	}

	public Double getCreditorInterests() {
		return creditorInterests;
	}

	public void setCreditorInterests(Double creditorInterests) {
		this.creditorInterests = creditorInterests;
	}

	public Double getDebtorInterestOverNegativeBalance() {
		return debtorInterestOverNegativeBalance;
	}

	public void setDebtorInterestOverNegativeBalance(Double debtorInterestOverNegativeBalance) {
		this.debtorInterestOverNegativeBalance = debtorInterestOverNegativeBalance;
	}

	public Double getCapitalPerformanceRetention() {
		return capitalPerformanceRetention;
	}

	public void setCapitalPerformanceRetention(Double capitalPerformanceRetention) {
		this.capitalPerformanceRetention = capitalPerformanceRetention;
	}

	public Double getMaintenanceComission() {
		return maintenanceComission;
	}

	public void setMaintenanceComission(Double maintenanceComission) {
		this.maintenanceComission = maintenanceComission;
	}

	public Double getMaintenanceDeficit() {
		return maintenanceDeficit;
	}

	public void setMaintenanceDeficit(Double maintenanceDeficit) {
		this.maintenanceDeficit = maintenanceDeficit;
	}

	public Double getMinMaintenanceDeficit() {
		return minMaintenanceDeficit;
	}

	public void setMinMaintenanceDeficit(Double minMaintenanceDeficit) {
		this.minMaintenanceDeficit = minMaintenanceDeficit;
	}

	public int getAnnualDays() {
		return annualDays;
	}

	public void setAnnualDays(int annualDays) {
		this.annualDays = annualDays;
	}

	public int getLiquidationPeriod() {
		return liquidationPeriod;
	}

	public void setLiquidationPeriod(int liquidationPeriod) {
		this.liquidationPeriod = liquidationPeriod;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = "ES001234123401" + accountNumber;
	}

	public String getFinalCreditorInterests() {
		return finalCreditorInterests;
	}

	public String getFinalPerformanceRetention() {
		return finalPerformanceRetention;
	}

	public String getFinalDebtorInterests() {
		return finalDebtorInterests;
	}

	public String getFinalDeficitComission() {
		return finalDeficitComission;
	}

	public String getTotalLiquidation() {
		return totalLiquidation;
	}
	
	public Double getBlockedBalance() {
		return blockedBalance;
	}
	
	public void setBlockedBalance(Double blockedBalance) {
		this.blockedBalance = blockedBalance;
	}
	
	public Double getTotalBalance() {
		return totalBalance;
	}
	
	public void setTotalBalance(Double totalBalance) {
		this.totalBalance = totalBalance;
	}
	
	public void setLastLiquidation(Date lastLiquidation) {
		this.lastLiquidation = lastLiquidation;
	}
	
	public Date getLastLiquidation() {
		return this.lastLiquidation;
	}
	
}
