/**
 * 
 */
package es.unileon.ulebankoffice.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import es.unileon.ulebankoffice.domain.DocumentoAdjunto;

/**
 * @author Razvan Raducu
 *
 */
@Repository
public interface DocumentoRepository extends MongoRepository<DocumentoAdjunto, String> {

	/**
	 * Método que se encarga de obtener de la base de datos el documento. Este
	 * método es equivalente a findOne de CrudRepository. He decicido crear este
	 * método para aumentar la legibilidad del código ya que este nombre es más
	 * adecuado.
	 * 
	 * @param id
	 *            del documento a buscar
	 * @return El objeto DocumentoAdjuntoDomain encontrado o null en caso de no
	 *         existir tal documento.
	 */
	public DocumentoAdjunto findById(String id);

	/**
	 * Método encargado de borrar todos los documentos cuyas ids coinciden con
	 * las especificadas
	 * 
	 * @param id
	 *            Lista de ids cuyos documentos han de ser borrados
	 */
	public void deleteByIdIn(List<String> id);

	/**
	 * Método encargado de obtener todos los documentos cuyas ids coinciden con
	 * las especificadas. (Las ids de los documentos son únicas). Este método es
	 * equivalente a findAll(Iterable) al cuál habría que hacerle un cast
	 * para indicarle cuál es el iterable que devuelve. En este caso la
	 * signatura sería (List<DocumentoAdjunto>) repo.findAll(listaIds);.
	 * He decicido crear este método para evitar hacer el casteo y para aumentar
	 * la legibilidad del código ya que este nombre es más adecuado.
	 * 
	 * @param id
	 *            Lista de ids de documentos a obtener
	 * @return La lista de los documentos obtenidos o una lista vacía en caso de
	 *         no existir tales documentos.
	 */
	public List<DocumentoAdjunto> findByIdIn(List<String> id);

	/**
	 * Método equivalente a findByIdIn con la única diferencia de que los
	 * elementos de la lista están ordenados de forma ascendente en función de
	 * su fecha de creación.
	 * 
	 * @param idLista
	 *            de ids de documentos a obtener
	 * @returnLa lista de los documentos obtenidos o una lista vacía en caso de
	 *           no existir tales documentos.
	 * @see es.unileon.ulebankoffice.repository.DocumentoRepository#findByIdIn(List)
	 */
	public List<DocumentoAdjunto> findByIdInOrderByFechaCreacionAsc(List<String> id);
}
