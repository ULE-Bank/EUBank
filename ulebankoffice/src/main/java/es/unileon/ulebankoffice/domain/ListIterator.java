/**
 * 
 */
package es.unileon.ulebankoffice.domain;

/**
 * Implementación concreta de la interface Iterator.
 * 
 * @author Razvan Raducu
 *
 * @param <E>
 *            El uso de genéricos evita el casting explícito a partir de Object.
 *            Explicación más detallada en la interface Aggregate.
 */
public class ListIterator<E> implements Iterator<E> {

	private Aggregate<E> aggregate;
	private int current;

	/**
	 * Constructor para instanciar la implementación concreta de la interface
	 * Iterator.
	 * 
	 * @param aggregate
	 *            Un objeto que implementa la interface Aggregate cuya colección
	 *            ha de iterarse, o sobre ella.
	 */
	public ListIterator(Aggregate<E> aggregate) {
		this.aggregate = aggregate;
		current = 0;
	}

	@Override
	public void firstElement() {
		current = 0;
	}

	@Override
	public void nextElement() {
		current = current + 1;
	}

	@Override
	public boolean hasMoreElements() {
		return current < aggregate.getSize();
	}

	@Override
	public E currentElement() throws EmptyCollectionException {
		return aggregate.getElement(current);
	}
}
