/**
 * 
 */
package es.unileon.ulebankoffice.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Razvan Raducu
 *
 */
@Document(collection = "Solicitudes")
public class Solicitud {

	@Id
	private String id;

	private String estado;
	private Date fechaApertura;
	private Date fechaResolucion;
	private String productId;

	private Documentos documentos;

	/**
	 * Constructor utilizado para la base de datos.
	 * 
	 * @param estado
	 * @param fechaApertura
	 * @param fechaResolucion
	 * @param productId
	 * @param documentos
	 */
	@PersistenceConstructor
	public Solicitud(String estado, Date fechaApertura, Date fechaResolucion, String productId,
			Documentos documentos) {
		this.estado = estado;
		this.fechaApertura = fechaApertura;
		this.fechaResolucion = fechaResolucion;
		this.productId = productId;
		this.documentos = documentos;
	}

	/**
	 * Constructor utilizado para instanciar por primera vez una nueva solicitud
	 * (SolicitudDomain). En este constructor se crea la instancia de Documentos
	 * que se persistirá
	 * 
	 * @param estado
	 * @param fechaApertura
	 * @param fechaResolucion
	 * @param productId
	 */
	public Solicitud(String estado, Date fechaApertura, Date fechaResolucion, String productId) {
		this.estado = estado;
		this.fechaApertura = fechaApertura;
		this.fechaResolucion = fechaResolucion;
		this.productId = productId;
		this.documentos = new Documentos(new ArrayList<String>());
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaApertura() {
		return fechaApertura;
	}

	public void setFechaApertura(Date fechaApertura) {
		this.fechaApertura = fechaApertura;
	}

	public Date getFechaResolucion() {
		return fechaResolucion;
	}

	public void setFechaResolucion(Date fechaResolucion) {
		this.fechaResolucion = fechaResolucion;
	}

	/**
	 * Este método delega la función de guardar en la base de datos el documento
	 * al atributo Documentos y, además, inserta en el atributo List
	 * <String> idDocs la id del documento recién guardado.
	 * 
	 * @param documento
	 */
	public void addDocument(DocumentoAdjunto documento) {
		this.documentos.add(documento);
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public List<DocumentoAdjunto> getDocumentos() throws EmptyCollectionException {
		// Este código sustituye a return documentos.getDocumentos()
		
		Iterator<DocumentoAdjunto> iterator = documentos.createIterator();
		List<DocumentoAdjunto> listaDocs = new ArrayList<>();

		for (iterator.firstElement(); iterator.hasMoreElements(); iterator.nextElement()) {

			listaDocs.add((DocumentoAdjunto) iterator.currentElement());

		}
		return listaDocs;
		
	}

	@Override
	public String toString() {
		return "SolicitudDomain [id=" + id + ", estado=" + estado + ", fechaApertura=" + fechaApertura
				+ ", fechaResolucion=" + fechaResolucion + ", productId=" + productId + ", documentos=" + documentos
				+ "]";
	}

}
