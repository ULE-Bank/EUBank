/**
 * 
 */
package es.unileon.ulebankoffice.domain;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Razvan Raducu
 * @tipo Hipotecario
 * ESTA CLASE ESTÁ AÚN INCOMPLETA
 */
@Document(collection="Prestamos")
public class PrestamoHipotecario implements FinancialProduct {
	
	@Id
	private String id;
	
	private String tipo;
	
	private Double interes, amortizacion;
	
	@Min(0)
	private Double capital;
//	private Solicitud solicitud;
//	private Handler id;
	
	@NotBlank @NotEmpty
	private String name, estado;
//	private List<Documento> listaDocs;
	
	@NotBlank @NotEmpty @Past
	private Date fechaSolicitud;
	
	private Date fechaResolucion, fechaFinalizacion;
	
	@NotBlank @NotEmpty
	private String dni;

	public PrestamoHipotecario() {
		this.tipo = "Hipotecario";
	}
//	@Override
//	public void crearSolicitud() {
//		
//		this.solicitud = new Solicitud();
//	}
//
//	@Override
//	public Solicitud getSolicitud() {
//		
//		return this.solicitud;
//	}
//
//	@Override
//	public void setId(Handler id) {
//		this.id = id;	
//	}
//
//	@Override
//	public Handler getId() {
//		
//		return id;
//	}

	
	public void setName(String name) {
		this.name = name;
	}


	@Override
	public Date getApplicationDate() {
		return null;
	}


	@Override
	public Date getResolutionDate() {
		return null;
	}


	@Override
	public Date getFinalizationDate() {
		return null;
	}


	@Override
	public String getStatus() {
		return null;
	}


	@Override
	public Handler getDni() {
		return null;
	}

//	@Override
//	public void addDocument(Documento documento) {
//		this.listaDocs.add(documento);
//	}
//
//		/**
//		 * Pendiente de revisión
//		 * 
//		 *
//		 */
//	@Override
//	public void removeDocument(String name) {
//		
//		int index = -1;
//		for (Documento documento : listaDocs) {
//			if(documento.getName().equals(name)){
//				index = listaDocs.indexOf(documento);
//			}
//		}
//		if(index != -1){
//		listaDocs.remove(index);
//		}
//	}
//
//	@Override
//	public List<Documento> getListaDocs() {
//		
//		return this.listaDocs;
//	}


	
}
