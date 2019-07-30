package es.unileon.ulebankoffice.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

public class QuestionsTest {
    private Questions questions;

    @Before
    public void setUp() {
        this.questions = new Questions();
    }

    @Test
    public void addTest() {
        Question question = new Question("Question test");
        assertNull(this.questions.search(question.getHandler()));
        this.questions.add(question);
        assertEquals(question, this.questions.search(question.getHandler()));
    }

    @Test
    public void addTestAlreadyExists() {
        Question question = new Question("Question test");
        assertNull(this.questions.search(question.getHandler()));
        this.questions.add(question);
        this.questions.add(question);
        assertEquals(question, this.questions.search(question.getHandler()));
        this.questions.remove(question.getHandler());
        assertNull(this.questions.search(question.getHandler()));
    }

    @Test
    public void searchTest() {
        Question question = new Question("Question test");
        this.questions.add(question);
        assertEquals(question, this.questions.search(question.getHandler()));
    }


    @Test
    public void searchTestDoesntExists() {
        Question question = new Question("Question test");
        assertNull(this.questions.search(question.getHandler()));
    }

    @Test
    public void removeTest() {
        Question question = new Question("Question test");
        this.questions.add(question);
        this.questions.remove(question.getHandler());
        assertNull(this.questions.search(question.getHandler()));

    }


    @Test
    public void removeTestDoesntExists() {
        Question question = new Question("Question test");
        this.questions.remove(question.getHandler());
        assertNull(this.questions.search(question.getHandler()));
    }

}