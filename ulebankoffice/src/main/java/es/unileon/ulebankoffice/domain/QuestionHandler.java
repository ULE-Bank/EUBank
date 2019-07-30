package es.unileon.ulebankoffice.domain;

import java.security.Timestamp;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;

public class QuestionHandler implements Handler {

	@Id	
    private long id;

    public QuestionHandler() {
        this.id = new Date().getTime();
    }
    
    @PersistenceConstructor
    public QuestionHandler(long id){
        this.id = id;
    }

    @Override
    public boolean compareTo(Handler handler) {
        return this.toString().equals(handler.toString());
    }

    @Override
    public String toString() {
        return String.valueOf(this.id);
    }

}