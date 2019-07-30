package es.unileon.ulebankoffice.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

public abstract class Option {	
    protected Handler handler;
    protected String text;
    
    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    public Handler getHandler() {
        return this.handler;
    }
    
    public void setHandler(Handler handler) {
        this.handler = handler;
    }
    
    public List<Option> getOptions(){
        return new ArrayList<>();
    }
}