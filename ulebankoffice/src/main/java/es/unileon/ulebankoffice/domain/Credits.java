package es.unileon.ulebankoffice.domain;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

import org.joda.time.DateTime;
import org.joda.time.Days;

/**
 * Class which manages the business logic associated with the service
 * Credit Accounts
 * 
 * @author Razvan Raducu, Alexis Gutierrez
 *
 */
public class Credits extends Operation {

	private double creditLimit;
	private Date openingDate;
	private Date expirationDate;
	private double debtorInterest;
	private double exceededInterest;
	private double creditorInterest;
	private double comissionSMND;
	private List<CreditMovements> movements;
	private List<List<String>> table;
	private List<Integer> days;
	private List<Double> debtorNumbers;
	private List<Double> exceededNumbers;
	private List<Double> creditorNumbers;

	/*
	 * DecimalFormatter is used to avoid scientific notation.
	 * (It was asked by the financial people.)
	 */
	
	
	private static final DecimalFormat DECIMALFORMATTER = new DecimalFormat("#,##0.00");
	private static final String CURRENCY = "€";
	private static final String DEPOSIT = "I";

	/**
	 * @param creditLimit
	 * @param openingDate
	 * @param expirationDate
	 * @param debtorInterest
	 * @param exceededInterest
	 * @param creditorInterest
	 * @param comissionSMND
	 * @param movements
	 */
	public Credits(double creditLimit, Date openingDate, Date expirationDate, double debtorInterest,
			double exceededInterest, double creditorInterest, double comissionSMND,
			List<CreditMovements> movements) {

		this.creditLimit = creditLimit;
		this.openingDate = openingDate;
		this.expirationDate = expirationDate;
		this.debtorInterest = debtorInterest / 100.0;
		this.exceededInterest = exceededInterest / 100.0;
		this.creditorInterest = creditorInterest / 100.0;
		this.comissionSMND = comissionSMND / 100.0;
		this.movements = movements;

		DECIMALFORMATTER.setDecimalFormatSymbols(new DecimalFormatSymbols(Locale.GERMAN));
	}

	/**
	 * Method used to include the opening commission and the brokerage as
	 * movements in the credit account.
	 * 
	 * @param openingComission
	 * @param brokerage
	 */
	public void includeOpeningAndBrokerageComission(double openingComission, double brokerage) {
		double openingCost = creditLimit * (openingComission / 100);
		double brokerageCost = creditLimit * (brokerage / 1000.0);

		movements.add(0, new CreditMovements("Corretaje", brokerageCost, openingDate, "D"));
		movements.add(0,
				new CreditMovements("Comision de apertura", openingCost, openingDate, "D"));
	}

	public List<List<String>> calculateTable() {

		orderMovementsByDate();
		changeDepositSign();

		List<Double> balance = new ArrayList<>();
		days = new ArrayList<>();
		debtorNumbers = new ArrayList<>();
		exceededNumbers = new ArrayList<>();
		creditorNumbers = new ArrayList<>();

		table = new ArrayList<>();
		List<String> itemTabla;
		Calendar calendar = new GregorianCalendar();

		int index = 0;

		for (CreditMovements movimiento : movements) {

			// Puesto que un bucle foreach no se puede terminar con un break
			// (las fechas están en orden) simplemente compruebo que el
			// movmiento actual ocurre antes que la fecha de vencimiento.
			if (movimiento.getMovementDate().before(expirationDate)) {

				itemTabla = new ArrayList<>();

				/* Fecha valor */
				calendar.setTime(movimiento.getMovementDate());
					/* Atencion. Se suma 1 puesto que en el calendario Gregoriano las fechas empiezan en 0. Enero el es el mes 0 y Diciembre el 11. */
				itemTabla.add(calendar.get(Calendar.DAY_OF_MONTH) + "-" + (calendar.get(Calendar.MONTH)+1));
				
				/* Concepto */
				itemTabla.add(movimiento.getMovementDescription());

				/* Disposiciones o ingresos */
				if (movimiento.getOperation().equals(DEPOSIT)) {
					itemTabla.add("-");
					/*
					 * Atención. Le vuelvo a cambiar de signo para que no se
					 * muestra en la tabla como un número negativo.
					 */
					itemTabla.add(String.valueOf(DECIMALFORMATTER.format(-movimiento.getMovementValue())) + CURRENCY);
				} else {
					itemTabla.add(String.valueOf(DECIMALFORMATTER.format(movimiento.getMovementValue())) + CURRENCY);
					itemTabla.add("-");
				}
				
				/* Saldo */
				if (balance.isEmpty()) {
					balance.add(movimiento.getMovementValue());
					itemTabla.add(DECIMALFORMATTER.format(round(movimiento.getMovementValue())) + CURRENCY);

				} else {
					balance.add(movimiento.getMovementValue() + balance.get(index - 1));
					itemTabla.add(DECIMALFORMATTER
							.format(round(movimiento.getMovementValue() + balance.get(index - 1))) + CURRENCY);

				}

				/* Días */
				DateTime thisDay;
				DateTime nextDay;
				Days daysAux;
				thisDay = new DateTime(movimiento.getMovementDate());
				if (index + 1 < movements.size()) {
					nextDay = new DateTime(movements.get(index + 1).getMovementDate());
					daysAux = Days.daysBetween(thisDay, nextDay);
					days.add(daysAux.getDays());
				} else {
					nextDay = new DateTime(expirationDate);
					daysAux = Days.daysBetween(thisDay, nextDay);
					days.add(daysAux.getDays());
				}
				itemTabla.add(Integer.toString(daysAux.getDays()));

				/* N.Deudores / N.Excedidos / N.Acreedores */
				if (balance.get(index) > creditLimit) {
					double numerosDeudoresAux = creditLimit * days.get(index);
					debtorNumbers.add(numerosDeudoresAux);
					itemTabla.add(DECIMALFORMATTER.format(numerosDeudoresAux) + CURRENCY);
					double diferencia = balance.get(index) - creditLimit;
					exceededNumbers.add(diferencia * days.get(index));

					itemTabla.add(DECIMALFORMATTER.format(diferencia * days.get(index)) + CURRENCY);
					itemTabla.add("-");
				} else if (balance.get(index) < 0) {
					creditorNumbers.add(days.get(index) * balance.get(index) * (-1));
					itemTabla.add("-");
					itemTabla.add("-");
					itemTabla.add(DECIMALFORMATTER.format(days.get(index) * balance.get(index) * (-1)) + CURRENCY);

				} else {
					debtorNumbers.add(balance.get(index) * days.get(index));
					itemTabla.add(DECIMALFORMATTER.format(balance.get(index) * days.get(index)) + CURRENCY);
					itemTabla.add("-");
					itemTabla.add("-");

				}

				table.add(itemTabla);

				index++;
			}
		}

		return table;
	}

	/**
	 * Method used to calculate the liquidation of the account according to
	 * the specified parameters. First, Credits must be instantiated.
	 * Second, openingComission and brokerage must be added.
	 * Finally, the table is calculated.
	 * This method uses all previously mentioned parameters.
	 * 
	 * <b>Edit:</b> 10.05.2017.
	 * The client asked this method to return a list of all the calculations.
	 * The order of the calculations to be shown is:
	 * 
	 * <ul>
	 * <li>0 - Debtor interests</li>
	 * <li>1 - Exceeded interests</li>
	 * <li>2 - Creditor interests</li>
	 * <li>3 - CSMND</li>
	 * <li>4 - Total days</li>
	 * <li>5 - Total liquidation</li>
	 * </ul>
	 * 
	 * @return Final liquidations as well as the parameters mentioned above.
	 */
	
	public List<Double> obtainLiquidation() {
		double debtorInterests = 0;
		double exceededInterests = 0;
		double creditorInterests = 0;
		double notReadyMediumBalanceComission;
		double finalDebtorInterests;
		double finalCreditorInterests;
		double finalExceededInterests;
		double totalLiquidation;
		
		int totalDays = 0;

		for (Double interest : debtorNumbers) {
			debtorInterests += interest;
		}

		for (Double interest : creditorNumbers) {
			creditorInterests += interest;
		}

		for (Double interest : exceededNumbers) {
			exceededInterests += interest;
		}

		for (Integer numberDays : days) {
			totalDays += numberDays;
		}

		if(totalDays != 0) {
			notReadyMediumBalanceComission = (this.creditLimit - (debtorInterests / totalDays))
					* this.comissionSMND;
		}else {
			notReadyMediumBalanceComission = 0;
		}

		finalDebtorInterests = debtorInterests * this.debtorInterest / 360;
		finalCreditorInterests = creditorInterests * this.creditorInterest / 360;
		finalExceededInterests = exceededInterests * this.exceededInterest / 360;
		
		// Final creditor interests must be subtracted.
		totalLiquidation = round(finalDebtorInterests - finalCreditorInterests
				+ finalExceededInterests + notReadyMediumBalanceComission);

		List<Double> resultList = new ArrayList<>();
		resultList.add(round(debtorInterests));
		resultList.add(round(exceededInterests));
		resultList.add(round(creditorInterests));
		resultList.add(round(notReadyMediumBalanceComission));
		resultList.add((double) totalDays);
		resultList.add(round(totalLiquidation));

		return resultList;
	}

	private void orderMovementsByDate() {
		Collections.sort(this.movements, new Comparator<CreditMovements>() {
			@Override
			public int compare(CreditMovements m1, CreditMovements m2) {
				return m1.getMovementDate().compareTo(m2.getMovementDate());
			}
		});
	}

	private void changeDepositSign() {
		for (CreditMovements movement : movements) {
			if (movement.getOperation().equals(DEPOSIT)) {
				movement.setMovementValue(-(movement.getMovementValue()));
			}
		}
	}

	public double getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(double creditLimit) {
		this.creditLimit = creditLimit;
	}

	public double getDebtorInterest() {
		return debtorInterest;
	}

	public void setDebtorInterest(double debtorInterest) {
		this.debtorInterest = debtorInterest / 100.0;
	}

	public double getExceededInterest() {
		return exceededInterest;
	}

	public void setExceededInterest(double exceededInterest) {
		this.exceededInterest = exceededInterest / 100.0;
	}

	public double getCreditorInterest() {
		return creditorInterest;
	}

	public void setCreditorInterest(double creditorInterest) {
		this.creditorInterest = creditorInterest / 100.0;
	}

	public double getComissionSMND() {
		return comissionSMND;
	}

	public void setComissionSMND(double comissionSMND) {
		this.comissionSMND = comissionSMND / 1000.0;
	}

	public List<CreditMovements> getMovements() {
		return movements;
	}

	public void setMovements(List<CreditMovements> movements) {
		this.movements = movements;
	}

	public Date getOpeningDate() {
		return openingDate;
	}

	public void setOpeningDate(Date openingDate) {
		this.openingDate = openingDate;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}
}
