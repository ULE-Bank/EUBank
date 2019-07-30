package es.unileon.ulebankoffice.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;

public class Options implements Aggregate<Option> {
	@Id
	private long id;
	private List<Option> options;

	@PersistenceConstructor
	public Options(List<Option> options) {
		this.options = options;
	}
	
	public Options() {
		this.options = new ArrayList<>();
		this.id = new Date().getTime();
	}
	
	@Override
	public Iterator<Option> createIterator() {
		return new ListIterator<>(this);
	}

	@Override
	public int getSize() {
		return options.size();
	}

	@Override
	public void add(Option option) {
		this.options.add(option);
	}

	@Override
	public void remove(int index) {
		if(index < 0 || index >= getSize()) {
			throw new IndexOutOfBoundsException("Index can't be less than 0 or greater than size.");
		}
		this.options.remove(index);
	}
	
	public void remove(Handler handler) {
		Option option = search(handler);
		if(option != null) {
			this.options.remove(option);
		}
	}


	@Override
	public Option getElement(int index) throws EmptyCollectionException {
		return this.options.get(index);
	}
	
	public Option search(Handler handler) {
		for (Option option: options) {
			if (option.getHandler().compareTo(handler)) {
				return option;
			}
			
			for(Option subOption: option.getOptions()) {
				if (subOption.getHandler().compareTo(handler)) {
					return subOption;
				}
			}
		}
		
		return null;
	}
	
	public List<Option> getOptions() {		
		return options;
	}

}
