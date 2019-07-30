/**
 * 
 */
package es.unileon.ulebankoffice.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Razvan Raducu
 *
 */
public class DNIHandler implements Handler {

	private String id;

	// La idea es que desde aquí se lance la excepción en caso de que el DNI sea
	// incorrecto y donde corresponda se capture para añadirlo al objeto Errors
	// que derivará en un hasErrors() de bindingResult
	/**
	 * La idea es que desde aquí se lance la excepción en caso de que el DNI sea
	 * incorrecto y donde corresponda se capture para añadirlo al objeto Errors
	 * que derivará en un hasErrors() de bindingResult
	 * 
	 * @param id
	 * @throws DNIException
	 */
	public DNIHandler(String id) throws DNIException {
		String idUpperCase = id.toUpperCase();
		if (!dniValido(idUpperCase)) {
			throw new DNIException("Documento de identificación inválido");
		} else {
			this.id = idUpperCase;
		}
	}
	
	@Override
	public boolean compareTo(Handler handler) {
		return toString().equals(handler.toString());

	}

	@Override
	public String toString() {
		return id;
	}

	public String getId() {
		return id;
	}

	private boolean dniValido(String nifNie) {
		StringBuilder aux;
		String nif;
		// Si es NIE, eliminar letra inicial para tratarlo como NIF
		/*
		 * Para el cálculo del dígito de control se sustituye:
		 * 
		 * X → 0 Y → 1 Z → 2 y se aplica el mismo algoritmo que para el NIF.
		 * http://www.interior.gob.es/web/servicios-al-ciudadano/dni/calculo-del
		 * -digito-de-control-del-nif-nie
		 * 
		 * Para ver qué son las letras L, K y M -> https://es.wikipedia.org/wiki/N%C3%BAmero_de_identificaci%C3%B3n_fiscal
		 * 
		 */
		if (nifNie.startsWith("L") || nifNie.startsWith("K") || nifNie.startsWith("M"))
			nif = nifNie.substring(1);
		else if (nifNie.startsWith("X")) {
			aux = new StringBuilder(nifNie);
			aux.setCharAt(0, '0');
			nif = aux.toString();
		} else if (nifNie.startsWith("Y")) {
			aux = new StringBuilder(nifNie);
			aux.setCharAt(0, '1');
			nif = aux.toString();
		} else if (nifNie.startsWith("Z")) {
			aux = new StringBuilder(nifNie);
			aux.setCharAt(0, '2');
			nif = aux.toString();
		} else {
			nif = nifNie;
		}
		// Compruebo que el patrón con 7 u 8 dígitos del 0-9 seguidos de una
		// sola letra se cumple con la cadena "nif" resultante. Los paréntesis
		// se usan para definir grupos. El blackslash se debe escapar
		Pattern nifPattern = Pattern.compile("(\\d{7,8})([TRWAGMYFPDXBNJZSQVHLCKEtrwagmyfpdxbnjzsqvhlcke])");
		Matcher matcher = nifPattern.matcher(nif);

		if (matcher.matches()) {
			String letra = matcher.group(2);
			// Extraer letra del NIF
			String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
			int dni = Integer.parseInt(matcher.group(1));
			dni = dni % 23;
			String reference = letras.substring(dni, dni + 1);
			return reference.equalsIgnoreCase(letra);
		} else {
			return false;
		}
	}

}
