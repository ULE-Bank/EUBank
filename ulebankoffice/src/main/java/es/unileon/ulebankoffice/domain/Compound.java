package es.unileon.ulebankoffice.domain;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;

public class Compound extends Option {
    private Options subOptions;

    @Id
    private String id;
    
    @PersistenceConstructor
    public Compound(String text, Options subOptions, OptionHandler handler) {
        this.text = text;
        this.handler = handler;
        this.subOptions = subOptions;
        this.id = handler.toString();

    }
    
    public Compound(String text) {
        this.text = text;
        this.subOptions = new Options();
        this.handler = new OptionHandler();
        this.id = handler.toString();
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getId() {
        return this.id;
    }
    
    public void add(Simple option) {
        this.subOptions.add(option);
    }

    public Simple search(Handler optionHandler) {
        return (Simple) subOptions.search(optionHandler);
    }
    public void remove(Handler optionHandler) {
        this.subOptions.remove(optionHandler);
    }
    
    public Options getSubOptions() {
    	return this.subOptions;
    }
    
    public void setSubOptions(Options options) {
    	this.subOptions = options;
    }

    @Override
    public List<Option> getOptions() {
    	return this.subOptions.getOptions();
    }
}