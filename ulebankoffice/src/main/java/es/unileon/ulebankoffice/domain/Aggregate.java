/**
 * 
 */
package es.unileon.ulebankoffice.domain;

/**
 * 
 * Interfaz de Agregados que deberán implementar todas las clases de este tipo.
 * A través de esta intrfaz se asegura que las clases agregadas tendrán la
 * capacidad de crear y devolver un iterador, así como permitirle a este añadir,
 * eliminar, obtener y conocer el tamaño de los elementos de la coleccion sobre
 * la cuál iterar.
 * 
 * @author Razvan Raducu
 *
 * @param <E>
 *            El tipo de objetos que se obtendrán a partir de la colección. Es
 *            decir, la clase de la cuál la clase que implementa esta interfaz
 *            es agregada. <b> He usado genéricos para evitar el casting
 *            explícito siempre a partir de la clase Object. Es decir, para
 *            evitar, por ejemplo, (DocumentoAdjuntoDomain)
 *            documentos.getElement(). El casting, al usar genéricos, se produce
 *            implícitamente. </b>
 */
public interface Aggregate<E> {

	/**
	 * Crea y devuelve la instancia del iterador que se usará para moverse por
	 * la colección de la que esa clase Agregada es responsable.
	 * 
	 * @return La instancia del iterador concreto.
	 */
	public Iterator<E> createIterator();

	/**
	 * Método para obtener el tamaño de la colección sobre la que se itera.
	 * 
	 * @return Número de elementos de la colección.
	 */
	public int getSize();

	/**
	 * Método para agregar un nuevo objeto a la colección de la que la clase
	 * Agregada es responable. Recibe como parámeto un objeto de tipo Object
	 * (superclase de Java) ya que esta es una interfaz, no una implementación
	 * concreta.
	 * 
	 * @param object
	 */
	public void add(E object);

	/**
	 * Método para eliminar un elemento de la colección. Se especifica el índice
	 * del elemento a borrar.
	 * 
	 * @param index
	 */
	public void remove(int index);

	/**
	 * Método para obtener un elemento concreto de la colección. Se especifica
	 * el índice del elemento a obtener.
	 * 
	 * @param index
	 * @return El elemento del índica indicado. <b>Importante. No olvidar hacer
	 *         casting a la implementación concreta ya que aquí se devuelve un
	 *         objeto del tipo Object</b>
	 * @throws EmptyCollectionException
	 *             Se lanza la excepción cuando se trata de iterar sobre una
	 *             colección que tiene 0 elementos.
	 */
	public E getElement(int index) throws EmptyCollectionException;
}
