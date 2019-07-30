/**
 * 
 */
package es.unileon.ulebankoffice.domain;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Razvan Raducu
 *
 */
@Document(collection = "Documents")
public class DocumentoAdjunto {

	@Id
	private String id;

	private String ruta;
	private String name;
	private Date fechaCreacion;

	/**
	 * Constructor para instanciar desde la base de datos. Si la fecha es null,
	 * se asigna automáticamente a la fecha actual.
	 * 
	 * @param ruta
	 * @param name
	 * @param fechaCreacion
	 */
	@PersistenceConstructor
	public DocumentoAdjunto(String ruta, String name, Date fechaCreacion) {
		this.ruta = ruta;
		this.name = name;
		this.fechaCreacion = fechaCreacion;
		checkCreationDate();
	}

	/**
	 * Constructor para instanciar documentos indicando sólo el nombre y la
	 * ruta. La fecha se asigna automáticamente al momento de instanciación
	 * siendo su valor la fecha actual.
	 * 
	 * @param ruta
	 * @param name
	 */
	public DocumentoAdjunto(String ruta, String name) {
		this.ruta = ruta;
		this.name = name;
		checkCreationDate();
	}

	/**
	 * Con este método se comprueba si la fecha de freación ha sido especificada
	 * a la hora de crear el documento. En caso de que no lo haya sido se asigna
	 * automáticamente a la fecha actual.
	 */
	private void checkCreationDate() {
		if (fechaCreacion == null) {
			fechaCreacion = new Date();
		}
	}

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	public String getId() {
		return id;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "DocumentoAdjuntoDomain [ruta=" + ruta + ", name=" + name + ", fechaCreacion=" + fechaCreacion + "]";
	}
	
}
