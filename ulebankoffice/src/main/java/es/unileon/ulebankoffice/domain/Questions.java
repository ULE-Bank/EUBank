package es.unileon.ulebankoffice.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;

public class Questions {
	
	@Id
	private long id;
	
    private List<Question> questions;

    public Questions(){
        this.questions = new ArrayList<>();
        this.id = new Date().getTime();
    }
    
    @PersistenceConstructor
    public Questions(List<Question> questions){
        this.questions = questions;
    }
    
    public List<Question> getQuestions() {
    	return this.questions;
    }
    
    public void setQuestions(List<Question> questions) {
    	this.questions = questions;
    }
    
    public void add(Question question) {
        if(this.search(question.getHandler()) == null) {
            this.questions.add(question);
        }
    }

    public Question search(Handler questionHandler) {
    	for (Question question: this.questions) {
    		if (question.getHandler().compareTo(questionHandler)) {
    	    	return question;
    		}
    	}
    	
    	return null;
    }
    
    public void remove(Handler questionHandler) {
        Question question = this.search(questionHandler);
        if(question != null) {
            this.questions.remove(question);
        }
    }

    public java.util.Iterator<Question> getIterator() {
        return questions.iterator();
    }
    
    public int getMaxPosition() {
    	int maxPosition = -1;
    	for(Question question: this.questions) {
    		if(question.getPosition() > maxPosition || maxPosition == -1) {
    			maxPosition = question.getPosition();
    		}
    	}
    	return maxPosition != -1 ? maxPosition : 0;
    }
}