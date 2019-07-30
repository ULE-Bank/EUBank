package es.unileon.ulebankoffice.web;

import java.security.Principal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import es.unileon.ulebankoffice.domain.Client;
import es.unileon.ulebankoffice.domain.CurrentAccount;
import es.unileon.ulebankoffice.domain.DNIHandler;
import es.unileon.ulebankoffice.domain.Address;
import es.unileon.ulebankoffice.domain.Documentos;
import es.unileon.ulebankoffice.domain.Handler;
import es.unileon.ulebankoffice.domain.UleBankEmployee;
import es.unileon.ulebankoffice.repository.ClientRepository;
import es.unileon.ulebankoffice.repository.CurrentAccountRepository;
import es.unileon.ulebankoffice.repository.AdressRepository;
import es.unileon.ulebankoffice.repository.UleBankEmployeeRepository;
import es.unileon.ulebankoffice.service.ClientPOJO;
import es.unileon.ulebankoffice.service.CurrentAccountClientAddressPOJO;
import es.unileon.ulebankoffice.service.CurrentAccountPOJO;
import es.unileon.ulebankoffice.service.AddressPOJO;
import es.unileon.ulebankoffice.service.UleBankEmployeePOJO;

/**
 * @author Razvan Raducu
 *
 */
@Controller
@RequestMapping(value = "/o")
public class OfficeIndexController {

	@Autowired
	private ClientRepository repoClientes;

	@Autowired
	private CurrentAccountRepository repoCuentas;

	@Autowired
	private AdressRepository repoDirecciones;

	@Autowired
	private BCryptPasswordEncoder bcrypt;

	@Autowired
	private UleBankEmployeeRepository employeesRepo;

	private static final Logger logger = Logger.getLogger("ulebankLogger");
	private static final String CLIENTSVIEWATTRIBUTE = "clients";
	private static final String CLIENTERROR = "clientError";
	private static final String OFFICEINDEXVIEW = "officeindex";
	private static final String REDIRECTOFFICE = "redirect:/o";

	@ModelAttribute("newEmployee")
	public UleBankEmployeePOJO addEmployee() {
		return new UleBankEmployeePOJO();
	}

	@ModelAttribute("newClient")
	public CurrentAccountClientAddressPOJO addClient() {
		return new CurrentAccountClientAddressPOJO();
	}

	@ModelAttribute("clients")
	public List<Client> getClients() {
		return repoClientes.findAll();
	}

	@ModelAttribute("employees")
	public List<UleBankEmployee> getEmployees(HttpServletRequest req) {
		if (req.isUserInRole("ROLE_ADMIN")) {
			return employeesRepo.findAll();
		}
		return new ArrayList<>();
	}

	@RequestMapping(method = RequestMethod.GET)
	public String comingSoon(ModelMap model, Principal principal, HttpServletRequest req) {
		logger.info(principal.getName() + " has access the main page of the office");
		return OFFICEINDEXVIEW;
	}

	@RequestMapping(method = RequestMethod.GET, params = "uin")
	public String showMeAclient(ModelMap model, @RequestParam("uin") String dni, HttpServletRequest req,
			Principal principal) {

		logger.info(principal.getName() + " " + req.getRemoteAddr() + " has searched the client with DNI " + dni);
		
		/*
		 * It's clever to capture the language rather than the country because it
		 * could be es_ES or es_MX. The language is the same but it isn't the same country.
		 * It could cause problems if only the country is captured.
		 */
		
		String locale = req.getLocale().getLanguage();
		String noClientFoundError = "";
		if (locale.equals(new Locale("en").getLanguage())) {
			noClientFoundError = "No client found with such identifier " + dni;
		} else if (locale.equals(new Locale("es").getLanguage())) {
			noClientFoundError = "No hay ningún cliente con el identificador " + dni;
		}

		Client clienteFound = repoClientes.findByDni(dni);
		if (clienteFound == null) {
			logger.debug("The client couldn't be found and the locale is: " + locale);
			logger.info("Nonexistent client");
			model.addAttribute(CLIENTERROR, noClientFoundError);
			model.addAttribute(CLIENTSVIEWATTRIBUTE, repoClientes.findAll());
		} else {
			logger.info("Client found");

			List<Client> foundClients = new ArrayList<>();
			foundClients.add(clienteFound);

			model.addAttribute(CLIENTSVIEWATTRIBUTE, foundClients);
		}

		return OFFICEINDEXVIEW;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String saveNewClient(@ModelAttribute("nuevoCliente") @Valid CurrentAccountClientAddressPOJO nuevoCliente,
			BindingResult clienteResult, BindingResult empleadoResult, HttpServletRequest req, HttpServletResponse resp,
			ModelMap model, Principal principal) throws ParseException {

		ClientPOJO clientePojo = nuevoCliente.getClient();
		AddressPOJO direccionPojo = nuevoCliente.getAddress();
		CurrentAccountPOJO cuentaPojo = nuevoCliente.getCurrentAccount();

		Client cliente;
		Address direccion;
		CurrentAccount cuentaCorriente;

		Handler DNI;

		logger.debug("LA FECHA DEL CLIENTE LLEGA COMO: ->> " + clientePojo.getBirthDate());
		if (clienteResult.hasErrors()) {
			logger.warn(principal.getName() + " " + req.getRemoteAddr()
					+ " ha intentando crear un nuevo cliente y ha habido errores.");
			logger.debug("HA HABIDO ERRORES ->" + clienteResult.getAllErrors().toString());
			return OFFICEINDEXVIEW;
		}

		try {
			DNI = new DNIHandler(clientePojo.getDni());
		} catch (Exception e) {
			clienteResult.addError(new FieldError("nuevoCliente", "cliente.dni", e.getMessage()));
			logger.error(principal.getName() + " " + req.getRemoteAddr()
					+ " ha intentado crear un cliente y se ha producido un error: " + e.getMessage() + " ||\n " + e
					+ "||" + e.getLocalizedMessage());
			return OFFICEINDEXVIEW;
		}

		DateTimeFormatter formatter = DateTimeFormat.forPattern("yy-MM-dd");
		DateTime fechaNacimientoCliente = formatter.parseDateTime(clientePojo.getBirthDate());
		DateTime fechaActual = new DateTime();

		cliente = new Client(clientePojo.getName(), clientePojo.getLastName(), clientePojo.getEmail(),
				fechaNacimientoCliente.toDate(), DNI, clientePojo.getCitizenship(),
				new Documentos(new ArrayList<String>()), new Date());
		direccion = new Address(direccionPojo.getStreet(), direccionPojo.getCity(),
				direccionPojo.getAutonomousRegion(), direccionPojo.getNumber(), DNI, direccionPojo.getPostalCode());

		cuentaCorriente = new CurrentAccount(fechaActual.toDate(), cuentaPojo.getCreditorInterests(),
				cuentaPojo.getDebtorInterestOverNegativeBalance(), cuentaPojo.getCapitalPerformanceRetention(),
				cuentaPojo.getMaintenanceComission(), cuentaPojo.getMaintenanceDeficit(),
				cuentaPojo.getMinMaintenanceDeficit(), new Date(), 0.0, 0.0, "Abierta", DNI, cuentaPojo.getAnnualDays(),
				cuentaPojo.getLiquidationPeriod());

		/*
		 * Gracias a StringUtils puedo obtener el número de cuentas totales y
		 * rellenarlo con ceros a la izquierda hasta los 10 caracteres
		 */
		cuentaCorriente
				.setAccountNumber(StringUtils.leftPad(Integer.toString(repoCuentas.findAll().size() + 1), 10, '0'));

		try {
			repoDirecciones.save(direccion);
			repoCuentas.save(cuentaCorriente);
			repoClientes.save(cliente);
		} catch (Exception e) {
			model.addAttribute(CLIENTERROR, "Ya existe un cliente con ese DNI/NIE");
			logger.error(principal.getName() + " " + req.getRemoteAddr()
					+ " ha intentado crear un cliente que ya existe (" + cliente.getDni().toString() + ")." + e);
			return OFFICEINDEXVIEW;
		}

		logger.info("Se ha creado el nuevo cliente con dni: " + cliente.getDni() + " e identificación en MognoDB: "
				+ cliente.getId());
		logger.info("Se ha creado la nueva cuenta corriente perteneciente al dni: " + cuentaCorriente.getDni()
				+ " e identificación en MognoDB: " + cuentaCorriente.getId());
		logger.info("Se ha creado la nueva dirección perteneciente al dni: " + direccion.getDni()
				+ " e identificación en MognoDB: " + direccion.getId());
		return "newClientVerification";

	}

	@RequestMapping(value = "/admin/submitEmployee", method = RequestMethod.POST)
	public String saveNewClient(@ModelAttribute("nuevoEmpleado") @Valid UleBankEmployeePOJO nuevoEmpleado,
			BindingResult empleadoResult, HttpServletRequest req, HttpServletResponse resp, ModelMap model,
			Principal principal) {

		if (empleadoResult.hasErrors()) {

			logger.warn("Se ha tratado de crear un empleado. Los datos son incorrectos."
					+ empleadoResult.getAllErrors().toString());
			return REDIRECTOFFICE;
		}

		UleBankEmployee empleado = new UleBankEmployee(nuevoEmpleado.getUserName(),
				bcrypt.encode(nuevoEmpleado.getPassword()), nuevoEmpleado.getRole());

		try {
			employeesRepo.save(empleado);
		} catch (Exception e) {
			model.addAttribute("errorRegisterEmployee", "Ya existe un empleado con ese nombre de usuario");
			logger.info("Se ha tratado de crear el usuario de la sucursal:" + empleado.getUserName()
					+ " con privilegios: " + empleado.getRole() + " pero ya existía. " + e);
			return REDIRECTOFFICE;
		}

		logger.info(principal.getName() + " " + req.getRemoteAddr() + " " + req.getLocalAddr()
				+ " Ha creado el usuario de la sucursual: " + empleado.getUserName() + " con privilegios: "
				+ empleado.getRole());
		return REDIRECTOFFICE;

	}

	@RequestMapping(value = "/admin/d", method = RequestMethod.GET, params = "ein")
	public String deleteEmployee(ModelMap model, @RequestParam("ein") String employeeUserName, Principal principal,
			HttpServletRequest req) {

		if ("cjrulebank".equalsIgnoreCase(employeeUserName)) {
			logger.fatal(principal.getName() + " " + req.getRemoteAddr() + " " + req.getLocalAddr()
					+ " ha intentado borrar al usuario administrador.");
			return REDIRECTOFFICE;
		}

		UleBankEmployee empleado = employeesRepo.findByUserName(employeeUserName);

		/*
		 * Por si a alguien se le ocurre introducir la URL directamente en el
		 * navegador con un "ein" inexistente. Con esto se evita la excepción
		 * IllegalArgumentException del método .delete()
		 */
		if (empleado == null) {
			logger.warn(principal.getName() + " " + req.getRemoteAddr() + " " + req.getLocalAddr()
					+ " Ha tratado de borrar un empleado inexistente. Alguien ha accedido a una URL que no debía. Empleado inexistente: "
					+ employeeUserName);
			return REDIRECTOFFICE;
		}
		logger.info(principal.getName() + " " + req.getRemoteAddr() + " " + req.getLocalAddr()
				+ " Ha eliminado el empleado de la oficina: " + employeeUserName);
		employeesRepo.delete(empleado);
		return REDIRECTOFFICE;

	}

}
