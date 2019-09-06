package es.unileon.ulebankoffice.domain;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;

public class Question implements Comparable<Question>{
	
	@Id
	private String id;
    private Handler handler;
    private String text;
    private Options options;
    private int position;

    public Question(String text) {
        this.text = text;
        this.handler = new QuestionHandler();
        this.options = new Options();
        this.id = this.handler.toString();
    }
    
    @PersistenceConstructor
    public Question(Handler handler, String text, Options options, int position) {
        this.text = text;
        this.handler = handler;
        this.options = options;
        this.position = position;
    }
    
    public void setPosition(int position) {
    	this.position = position;
    }
    
    public int getPosition() {
    	return this.position;
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
    
    @Override
    public int compareTo(Question question) {
      if (question == null) {
        return 0;
      }
      return this.getPosition() - question.getPosition();
    }
}