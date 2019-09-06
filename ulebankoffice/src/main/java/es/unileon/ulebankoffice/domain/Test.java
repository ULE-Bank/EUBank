package es.unileon.ulebankoffice.domain;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import es.unileon.ulebankoffice.repository.TestRepository;

@Document(collection = "Survey")
public class Test {
	
	@Id
	private String id = "0";
	
	@Transient
    private static Test singleton;
    private Questions questions;

    private Test() {
        questions = new Questions();
    }
    
	@PersistenceConstructor
	public Test(Questions questions) throws ParseException {
		this.questions = questions;
	}

    public static Test getInstance() {
        if(singleton == null){
            singleton = new Test();
        }
        
        return singleton;
    }

    public static void populateSingleton(TestRepository repo) {
    	Test.singleton = repo.findOne("0");
    }
    
    public void add(Question question) {
        questions.add(question);
    }

    public Question search(Handler questionHandler) {
        return questions.search(questionHandler);
    }

    public void remove(Handler questionHandler) {
        questions.remove(questionHandler);
    }

    public List<Question> getQuestions() {
        List<Question> questionList = new ArrayList<>();
        Iterator<Question> iterator = questions.getIterator(); 
        
        while(iterator.hasNext()) {
            questionList.add(iterator.next());
        }
        
        Collections.sort(questionList);
        
        return questionList;
    }
    
    public int getMaxPosition() {
    	return questions.getMaxPosition();
    }
    
    public void updatePositions(Handler oldQuestionHandler, int newPosition) {
    	int oldPosition = this.questions.search(oldQuestionHandler).getPosition();
    	for(Question question: this.questions.getQuestions()) {
    		if(question.getPosition() >= newPosition && question.getPosition() < oldPosition && newPosition < oldPosition) {
    			question.setPosition(question.getPosition() + 1);
    		}
    		else if (question.getPosition() > oldPosition && question.getPosition() <= newPosition && newPosition > oldPosition) {
    			question.setPosition(question.getPosition() - 1);
			}
    		else if (question.getHandler().compareTo(oldQuestionHandler)) {
    			question.setPosition(newPosition);
    		}
    	}
    }
    
    
}