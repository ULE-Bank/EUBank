package es.unileon.ulebankoffice.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import es.unileon.ulebankoffice.repository.QuestionStoreRepository;

@Document(collection = "Questions")
public class QuestionStore {
	
	@Id
	private String id = "0";
	
	@Transient
    private static QuestionStore singleton;
    private Questions allQuestions;

    private QuestionStore() {
        allQuestions = new Questions();
    }
    
	@PersistenceConstructor
	public QuestionStore(Questions allQuestions){
		this.allQuestions = allQuestions;
	}

    public static QuestionStore getInstance() {
        if (singleton == null) {
            singleton = new QuestionStore();
        }

        return singleton;
    }

    public static void populateSingleton(QuestionStoreRepository repo) {
    	QuestionStore.singleton = repo.findOne("0");
    }
    
    public void add(Question question) {
        if(allQuestions.search(question.getHandler()) == null) {
            allQuestions.add(question);
        }
    }

    public Question search(Handler questionHandler) {
        return allQuestions.search(questionHandler);
    }
}