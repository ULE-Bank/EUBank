package es.unileon.ulebankoffice.domain;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;


/**
 * The entry date is automatically established at the moment of the creation of the object
 * @author Razvan Raducu
 *
 */

@Document(collection = "Clients")
public class Client {

	@Id
	private String id;

	private String name;
	private String lastName;
	private String email;
	private String citizenship;
	private Date birthDate;
	private Date entryDate;

	@Indexed(unique = true)
	private Handler dni;
	private Documentos documents;

	/**
	 * Default builder to instantiate objects of this class when the object 
	 * is received through mongo. <b>
	 * 
	 * @PersistanceConstructor indicates that this is the builder for that task.
	 * <b> Reference <b>
	 * http://docs.spring.io/spring-data/data-mongo/docs/1.1.0.RELEASE/reference
	 * /html/#mapping-chapter
	 * 
	 * @param name
	 * @param lastName
	 * @param email
	 * @param birthDate
	 * @param dni
	 * @param citizenship
	 * @param documents
	 * @param entryDate
	 * @throws ParseException
	 */
	@PersistenceConstructor
	public Client(String name, String lastName, String email, Date birthDate, Handler dni,
			 String citizenship, Documentos documents, Date entryDate) throws ParseException {

		this.name = name;
		this.lastName = lastName;
		this.email = email;
		this.birthDate = birthDate;
		this.citizenship = citizenship;
		this.dni = dni;
		this.documents = documents;
		this.entryDate = entryDate;
		
	}

	/**
	 * 
	 * Builder used to manually instantiate objects of the class Client. 
	 * 
	 * 
	 * @param name
	 * @param lastName
	 * @param email
	 * @param birthDate
	 * @param dni
	 * @param citizenship
	 * @param entryDate
	 * @throws ParseException
	 * @throws DNIException
	 */
	public Client(String name, String lastName, String email, String birthDate, String dni,
			 String citizenship, Date entryDate) throws ParseException, DNIException {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date userDate = df.parse(birthDate);

		this.name = name;
		this.lastName = lastName;
		this.email = email;
		this.birthDate = userDate;
		setDni(dni);
		this.citizenship = citizenship;
		this.documents = new Documentos(new ArrayList<String>());
		this.entryDate = entryDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastname) {
		this.lastName = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public Handler getDni() {
		return dni;
	}

	public void setDni(String dni) throws DNIException {
		this.dni = new DNIHandler(dni);
	}

	public void setDni(Handler dni) throws DNIException {
		this.dni = dni;
	}

	/**
	 * Method that adds a document to the class's attribute list of documents assigned 
	 * to the client, using the document's id. 
	 * 
	 * @param document
	 */
	public void addDocument(DocumentoAdjunto document) {
		documents.add(document);
	}

	/**
	 * Method that gets a concrete iterator of the instance of the aggregated class.
	 * The iterator goes one by one, gathering all elements of the collection and
	 * returning them as a list.
	 * 
	 * @return A list with all the documents in the collection
	 * @throws EmptyCollectionException 
	 */
	public List<DocumentoAdjunto> getDocuments() throws EmptyCollectionException {
		
		Iterator<DocumentoAdjunto> iterator = documents.createIterator();
		List<DocumentoAdjunto> docsList = new ArrayList<>();

		for (iterator.firstElement(); iterator.hasMoreElements(); iterator.nextElement()) {

			docsList.add((DocumentoAdjunto) iterator.currentElement());

		}
		return docsList;
	}

	public String getCitizenship() {
		return citizenship;
	}

	public void setCitizenship(String citizenship) {
		this.citizenship = citizenship;
	}

	public Date getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}
	
	

	@Override
	public String toString() {
		return "ClienteDomain [name=" + name + ", lastname=" + lastName + ", email=" + email + ", nacionalidad="
				+ citizenship + ", fechaNacimiento=" + birthDate + ", fechaDeAlta=" + entryDate + ", dni="
				+ dni + ", documentos=" + documents + "]";
	}

	public String getId() {
		return id;
	}

}
