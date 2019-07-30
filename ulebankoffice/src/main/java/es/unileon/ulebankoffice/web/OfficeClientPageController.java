/**
 * 
 */
package es.unileon.ulebankoffice.web;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.Principal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.itextpdf.text.pdf.qrcode.Mode;

import es.unileon.ulebankoffice.domain.Client;
import es.unileon.ulebankoffice.domain.CurrentAccount;
import es.unileon.ulebankoffice.domain.CurrentAccountMovement;
import es.unileon.ulebankoffice.domain.DNIException;
import es.unileon.ulebankoffice.domain.DNIHandler;
import es.unileon.ulebankoffice.domain.Address;
import es.unileon.ulebankoffice.repository.ClientRepository;
import es.unileon.ulebankoffice.repository.CurrentAccountRepository;
import es.unileon.ulebankoffice.repository.AdressRepository;
import es.unileon.ulebankoffice.service.CurrentAccountPOJO;
import es.unileon.ulebankoffice.service.CurrentAccountMovementPOJO;
import es.unileon.ulebankoffice.service.CurrentAccountMovementsAux;
import es.unileon.ulebankoffice.service.AddressPOJO;

/**
 * @author Razvi Razvan Raducu
 *
 */
@Controller
@RequestMapping("/o/u")
public class OfficeClientPageController {

	@Autowired
	private ClientRepository clientRepo;

	@Autowired
	private AdressRepository addressesRepo;

	@Autowired
	private CurrentAccountRepository currentAccountsRepo;

	private String clientDNI;
	private String accountNumber;

	private static final Logger logger = Logger.getLogger("ulebankLogger");
	private static final String OFFICECLIENTPAGEVIEW = "officeclientpage";

	@ModelAttribute("newCurrentAccount")
	public CurrentAccountPOJO cuentaCorriente() {
		return new CurrentAccountPOJO();
	}

	@ModelAttribute("newAddress")
	public AddressPOJO direccion() {
		return new AddressPOJO();
	}

	@ModelAttribute("subledgerAccount")
	public CurrentAccountMovementsAux cuentaAuxiliar() {
		return new CurrentAccountMovementsAux();
	}

	@RequestMapping(method = RequestMethod.GET, params = { "uin" })
	public String showClientData(ModelMap model, @RequestParam("uin") String dni) {

		Client clientFound = clientRepo.findByDni(dni);
		clientDNI = clientFound.getDni().toString();

		model.addAttribute("client", clientFound);
		model.addAttribute("addresses", addressesRepo.findByDni(clientDNI));
		model.addAttribute("currentAccounts", currentAccountsRepo.findByDni(clientDNI));
		logger.debug("Dni is: " + clientDNI);
		return OFFICECLIENTPAGEVIEW;
	}

	@PostMapping(value = "/nd")
	public String newAddress(ModelMap model, HttpServletRequest req, Principal principal,
			@Valid @ModelAttribute("newAddress") AddressPOJO newAddress, BindingResult addressResult)
			throws DNIException {
		
		logger.debug("Dni is: " + clientDNI);
		
		if (addressResult.hasErrors()) {
			logger.warn("Address has errors");
			return "redirect:/o/u?uin=" + clientDNI;
		}

		Address address = new Address(clientDNI, newAddress.getStreet(),
				newAddress.getCity(), newAddress.getAutonomousRegion(), newAddress.getPostalCode(),
				newAddress.getNumber());

		addressesRepo.save(address);
		logger.info(principal.getName() + " " + req.getRemoteAddr()
				+ " has register a new address for the client: " + clientDNI);
		return "redirect:/o/u?uin=" + clientDNI;

	}

	@PostMapping(value = "/nc")
	public String newCurrentAccount(ModelMap model, HttpServletRequest req, Principal principal,
			@Valid @ModelAttribute("newCurrentAccount") CurrentAccountPOJO newAccount, BindingResult accountResult)
			throws DNIException {

		if (accountResult.hasErrors()) {
			return OFFICECLIENTPAGEVIEW;
		}

		CurrentAccount account = new CurrentAccount(new Date(), newAccount.getCreditorInterests(),
				newAccount.getDebtorInterestOverNegativeBalance(), newAccount.getCapitalPerformanceRetention(),
				newAccount.getMaintenanceComission(), newAccount.getMaintenanceDeficit(),
				newAccount.getMinMaintenanceDeficit(), null, 0.0, 0.0, "Abierta", new DNIHandler(clientDNI),
				newAccount.getAnnualDays(), newAccount.getLiquidationPeriod());

		account.setAccountNumber(
				StringUtils.leftPad(Integer.toString(currentAccountsRepo.findAll().size() + 1), 10, '0'));

		currentAccountsRepo.save(account);
		logger.info(principal.getName() + " " + req.getRemoteAddr()
				+ " has registered a new current account for the client: " + clientDNI);
		return "redirect:/o/u?uin=" + clientDNI;
	}

	@GetMapping(value = "/c")
	public String viewAccount(ModelMap model, HttpServletRequest req, Principal principal,
			@RequestParam("accn") String accnNumber, HttpServletResponse response) {
		/* If account doesn't exist, it redirects to 404 */
		
		CurrentAccount account = currentAccountsRepo.findByAccountNumber(accnNumber);
		if (account == null) {
			logger.warn(principal.getName() + " " + req.getRemoteAddr()
					+ " has tried to see the account with number: " + accnNumber
					+ " which doesn't exists. Returning 404.");
			return "redirect:/e/404";
		}
		
		model.addAttribute("subledgerAccount", new CurrentAccountMovementsAux());
		model.addAttribute("account", account);
		response.addCookie(new Cookie("lastLiquidationDate", account.getLastLiquidationDate()));
		
		accountNumber = account.getAccountNumber();
		return "currentaccountnew";
	}

	@PostMapping(value = "/c")
	public String registerMovements(ModelMap model, HttpServletRequest req, Principal principal,
			@Valid @ModelAttribute("subledgerAccount") CurrentAccountMovementsAux movementsNewAccount,
			BindingResult movementsResults) {

		if (movementsResults.hasErrors()) {
			logger.info(principal.getName() + " " + req.getRemoteAddr()
					+ " has tried to register movements in account: " + accountNumber
					+ " which contains errors.");
			return "currentaccount";
		}

		CurrentAccount currentAccount = currentAccountsRepo.findByAccountNumber(accountNumber);
		CurrentAccountMovement newMovement;
		DateTimeFormatter formatter = DateTimeFormat.forPattern("yy-MM-dd");
		DateTime movementDate;
		double balanceAux = 0.0;

		/*
		 * It's checked if currentAccount has initialized the list of
		 * movements to avoid nullPointerException. 
		 */
		if (currentAccount.getMovements() == null) {
			currentAccount.setMovementes(new ArrayList<CurrentAccountMovement>());
		}

		for (CurrentAccountMovementPOJO movement : movementsNewAccount.getMovements()) {

			movementDate = formatter.parseDateTime(movement.getValueDate());
			newMovement = new CurrentAccountMovement(movement.getValue(), movement.getConcept(),
					movementDate.toDate(), movement.getOperation());

			balanceAux = "D".equals(movement.getOperation()) ? balanceAux - movement.getValue()
					: balanceAux + movement.getValue();

			currentAccount.addMovement(newMovement);
		}

		logger.info(principal.getName() + " " + req.getRemoteAddr() + " has added new movements to the account: "
				+ accountNumber);
		currentAccount.setTotalBalance(BigDecimal.valueOf(Math.rint(currentAccount.getTotalBalance() + balanceAux * 100) / 100)
				.setScale(2, RoundingMode.HALF_UP).doubleValue());
		currentAccountsRepo.save(currentAccount);

		return "redirect:/o/u/c?accn=" + accountNumber;
	}

	@PostMapping(value = "/c", params = { "initLiquidationDate", "finalLiquidationDate" })
	public String liquidate(ModelMap model, HttpServletRequest req, Principal principal,
			@RequestParam("initLiquidationDate") String initLiquidationDate,
			@RequestParam("finalLiquidationDate") String finalLiquidationDate,
			@CookieValue(value="persist", defaultValue="false") String doesPersist,
			HttpServletResponse response) {
		
		logger.debug("I've detected a liquidation request. Init date: " + initLiquidationDate + 
				". Final date: " + finalLiquidationDate);

		DateTimeFormatter formatter = DateTimeFormat.forPattern("yy-MM-dd");
		DateTime initDate = formatter.parseDateTime(initLiquidationDate);
		DateTime endDate = formatter.parseDateTime(finalLiquidationDate);
		boolean isPermanent = Boolean.parseBoolean(doesPersist);

		CurrentAccount account = currentAccountsRepo.findByAccountNumber(accountNumber);
		
		logger.info(principal.getName() + " " + req.getRemoteAddr() + " has made the liquidation of account: "
				+ account.getAccountNumber());
		
		model.addAttribute("table", account.makeLiquidation(initDate.toDate(), endDate.toDate(), isPermanent));
        model.addAttribute("account", account);
        currentAccountsRepo.save(account);
        
		if(!isPermanent) {
			response.addCookie(new Cookie("resultados", "1"));
		}
		response.addCookie(new Cookie("lastLiquidationDate", account.getLastLiquidationDate()));
        response.addCookie(new Cookie("initDate", initLiquidationDate));
        response.addCookie(new Cookie("finalDate", finalLiquidationDate));
        
		return "currentaccountnew";
	}
	
	@PostMapping(value = "/c", params = { "deletedMovementNumber" })
	public String deleteMovement(ModelMap model, HttpServletRequest req, Principal principal,
			@RequestParam("deletedMovementNumber") String deletedMovementNumber,
			HttpServletResponse response) {

		CurrentAccount account = currentAccountsRepo.findByAccountNumber(accountNumber);
		logger.info("I've detected a movement deletion. Movement number: " + deletedMovementNumber 
				+ " of account: " + accountNumber);

		account.removeMovement(Integer.valueOf(deletedMovementNumber));
		currentAccountsRepo.save(account);
		
		model.addAttribute("account", account);
		return "currentaccountnew";
	}

}
