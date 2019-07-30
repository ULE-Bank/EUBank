package es.unileon.ulebankoffice.domain;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;

public class Question {
	
	@Id
	private String id;
    private Handler handler;
    private String text;
    private Options options;

    public Question(String text) {
        this.text = text;
        this.handler = new QuestionHandler();
        this.options = new Options();
        this.id = this.handler.toString();
    }
    
    @PersistenceConstructor
    public Question(Handler handler, String text, Options options) {
        this.text = text;
        this.handler = handler;
        this.options = options;
    }
    
    public void setText(String text){
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    public String getId() {
    	return this.id;
    }
    
    public void setId(String id) {
    	this.id = id;
    }
    
    public Handler getHandler() {
        return this.handler;
    }
    
    public void setHandler(Handler handler) {
         this.handler = handler;
    }

    public void add(Option option) {
        if (this.search(option.getHandler()) == null) {
            this.options.add(option);
        }
    }

    public Option search(Handler handler) {
    	return this.options.search(handler);
    }

    public void remove(Handler handler) {
        this.options.remove(handler);
    }

    public String toString() {
        return this.text;
    }

    public List<Option> getOptions() {
        return this.options.getOptions();
    }
}