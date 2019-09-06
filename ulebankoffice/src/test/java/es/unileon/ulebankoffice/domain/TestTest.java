package es.unileon.ulebankoffice.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.lang.reflect.Field;

import org.junit.Before;
import org.junit.Test;

public class TestTest {
    private es.unileon.ulebankoffice.domain.Test test;

    @Before
    public void setUp() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        Field instance = es.unileon.ulebankoffice.domain.Test.class.getDeclaredField("singleton");
        instance.setAccessible(true);
        instance.set(null, null);
        this.test = es.unileon.ulebankoffice.domain.Test.getInstance();
    }

    @Test
    public void getInstanceTest() {
        es.unileon.ulebankoffice.domain.Test test2 = es.unileon.ulebankoffice.domain.Test.getInstance();
        Question question = new Question("Question text");
        this.test.add(question);

        assertEquals(question, this.test.search(question.getHandler()));
        assertEquals(question, test2.search(question.getHandler()));

    }
    
    @Test
    public void addTest() {
        Question question = new Question("Question text");
        assertNull(this.test.search(question.getHandler()));
        this.test.add(question);
        assertEquals(question, this.test.search(question.getHandler()));
    }

    @Test
    public void searchTest() {
        Question question = new Question("Question text");
        this.test.add(question);
        assertEquals(question, this.test.search(question.getHandler()));
    }

    @Test
    public void searchInexistentTest() {
        Question question = new Question("Question text");
        assertNull(this.test.search(question.getHandler()));
    }

    @Test
    public void removeTest() {
        Question question = new Question("Question text");
        this.test.add(question);
        this.test.remove(question.getHandler());
        assertNull(this.test.search(question.getHandler()));
    }

    @Test
    public void removeInexistentTest() {
        Question question = new Question("Question text");
        this.test.remove(question.getHandler());
        assertNull(this.test.search(question.getHandler()));
    }
    
    @Test
    public void getMaxPositionTest() {
        Question question = new Question("Question text");
        question.setPosition(1);
        this.test.add(question);
        assertEquals(1, this.test.getMaxPosition());
    }
    
    @Test
    public void updatePositionsBefore() {
    	Question question = new Question("Question text");
        question.setPosition(1);
        Question question2 = new Question("Question text");
        question2.setPosition(2);
        question2.setHandler(new QuestionHandler(2));
        Question question3 = new Question("Question text");
        question3.setPosition(3);
        question3.setHandler(new QuestionHandler(3));
        Question question4 = new Question("Question text");
        question4.setPosition(4);
        question4.setHandler(new QuestionHandler(4));
        this.test.add(question);
        this.test.add(question2);
        this.test.add(question3);
        this.test.add(question4);
        
        this.test.updatePositions(question3.getHandler(), 2);
        
        assertEquals(this.test.getQuestions().get(0), question);
        assertEquals(this.test.getQuestions().get(1), question3);
        assertEquals(this.test.getQuestions().get(2), question2);
        assertEquals(this.test.getQuestions().get(3), question4);
    }
    
    @Test
    public void updatePositionsAfter() {
    	Question question = new Question("Question text");
        question.setPosition(1);
        Question question2 = new Question("Question text");
        question2.setPosition(2);
        question2.setHandler(new QuestionHandler(2));
        Question question3 = new Question("Question text");
        question3.setPosition(3);
        question3.setHandler(new QuestionHandler(3));
        Question question4 = new Question("Question text");
        question4.setPosition(4);
        question4.setHandler(new QuestionHandler(4));
        this.test.add(question);
        this.test.add(question2);
        this.test.add(question3);
        this.test.add(question4);
        
        this.test.updatePositions(question2.getHandler(), 3);
        
        assertEquals(this.test.getQuestions().get(0), question);
        assertEquals(this.test.getQuestions().get(1), question3);
        assertEquals(this.test.getQuestions().get(2), question2);
        assertEquals(this.test.getQuestions().get(3), question4);
    }
    
    @Test
    public void updatePositionsFirst() {
    	Question question = new Question("Question text");
        question.setPosition(1);
        Question question2 = new Question("Question text");
        question2.setPosition(2);
        question2.setHandler(new QuestionHandler(2));
        Question question3 = new Question("Question text");
        question3.setPosition(3);
        question3.setHandler(new QuestionHandler(3));
        Question question4 = new Question("Question text");
        question4.setPosition(4);
        question4.setHandler(new QuestionHandler(4));
        this.test.add(question);
        this.test.add(question2);
        this.test.add(question3);
        this.test.add(question4);
        
        this.test.updatePositions(question3.getHandler(), 1);
        
        assertEquals(this.test.getQuestions().get(0), question3);
        assertEquals(this.test.getQuestions().get(1), question);
        assertEquals(this.test.getQuestions().get(2), question2);
        assertEquals(this.test.getQuestions().get(3), question4);
    }
    
    @Test
    public void updatePositionsLast() {
    	Question question = new Question("Question text");
        question.setPosition(1);
        Question question2 = new Question("Question text");
        question2.setPosition(2);
        question2.setHandler(new QuestionHandler(2));
        Question question3 = new Question("Question text");
        question3.setPosition(3);
        question3.setHandler(new QuestionHandler(3));
        Question question4 = new Question("Question text");
        question4.setPosition(4);
        question4.setHandler(new QuestionHandler(4));
        this.test.add(question);
        this.test.add(question2);
        this.test.add(question3);
        this.test.add(question4);
        
        this.test.updatePositions(question2.getHandler(), 4);
        
        assertEquals(this.test.getQuestions().get(0), question);
        assertEquals(this.test.getQuestions().get(1), question3);
        assertEquals(this.test.getQuestions().get(2), question4);
        assertEquals(this.test.getQuestions().get(3), question2);
    }
    
    @Test
    public void updatePositionsNone() {
    	Question question = new Question("Question text");
        question.setPosition(1);
        Question question2 = new Question("Question text");
        question2.setPosition(2);
        question2.setHandler(new QuestionHandler(2));
        Question question3 = new Question("Question text");
        question3.setPosition(3);
        question3.setHandler(new QuestionHandler(3));
        Question question4 = new Question("Question text");
        question4.setPosition(4);
        question4.setHandler(new QuestionHandler(4));
        this.test.add(question);
        this.test.add(question2);
        this.test.add(question3);
        this.test.add(question4);
        
        this.test.updatePositions(question3.getHandler(), 3);
        
        assertEquals(this.test.getQuestions().get(0), question);
        assertEquals(this.test.getQuestions().get(1), question2);
        assertEquals(this.test.getQuestions().get(2), question3);
        assertEquals(this.test.getQuestions().get(3), question4);
    }
}