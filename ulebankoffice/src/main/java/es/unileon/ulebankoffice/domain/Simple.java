package es.unileon.ulebankoffice.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

public class Simple extends Option{
    private float weight;

    @Id
    protected String id;
        
    @PersistenceConstructor
    public Simple(String text, float weight, OptionHandler handler) {
        this.text = text;
        this.weight = weight;
        this.handler = handler;
        this.id = handler.toString();
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getId() {
        return this.id;
    }
    
    public Simple(String text, float weight) {
        this.text = text;
        this.weight = weight;
        this.handler = new OptionHandler();
        this.id = handler.toString();
    }
    
    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getWeight() {
        return this.weight;
    }

    @Override
    public String toString() {
        return this.text + ": " + String.valueOf(this.weight);
    }

    @Override
    public List<Option> getOptions() {
        return new ArrayList<>();
    }
}