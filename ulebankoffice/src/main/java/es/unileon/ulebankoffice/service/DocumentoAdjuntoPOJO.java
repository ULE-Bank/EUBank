package es.unileon.ulebankoffice.service;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author Razvan Raducu
 *
 */

public class DocumentoAdjuntoPOJO {
	
	@NotEmpty @NotBlank
	private String name;
	
	@NotEmpty @NotBlank
	private String ruta;
	
	private String solicitudId; //ID de la solicitud al que está asociado
	private String productoFinancieroID; // ID del producto al que está asociado;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRuta() {
		return ruta;
	}
	public void setRuta(String ruta) {
		this.ruta = ruta;
	}
	public String getSolicitudId() {
		return solicitudId;
	}
	public void setSolicitudId(String solicitudId) {
		this.solicitudId = solicitudId;
	}
	public String getProductoFinancieroID() {
		return productoFinancieroID;
	}
	public void setProductoFinancieroID(String productoFinancieroID) {
		this.productoFinancieroID = productoFinancieroID;
	}
	
	
	
}
