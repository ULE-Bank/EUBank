package es.unileon.ulebankoffice.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.lang.reflect.Field;

import org.junit.Before;
import org.junit.Test;

public class QuestionStoreTest {
    private QuestionStore questionStore;

    @Before
    public void setUp() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        Field instance = QuestionStore.class.getDeclaredField("singleton");
        instance.setAccessible(true);
        instance.set(null, null);
        this.questionStore = QuestionStore.getInstance();
    }

    @Test
    public void getInstanceTest() {
        QuestionStore questionStore2 = QuestionStore.getInstance();
        assertEquals(questionStore, questionStore2);
    }

    @Test
    public void addTest() {
        Question question = new Question("Question text");
        questionStore.add(question);
        assertEquals(question, questionStore.search(question.getHandler()));
    }

    @Test
    public void addAlreadyExistsTest() {
        Question question = new Question("Question text");
        questionStore.add(question);
        questionStore.add(question);
        assertEquals(question, questionStore.search(question.getHandler()));
    }

    @Test
    public void addSingletonTest() {
        Question question = new Question("Question text");
        QuestionStore questionStore2 = QuestionStore.getInstance();

        questionStore.add(question);
        assertEquals(question, questionStore.search(question.getHandler()));
        assertEquals(question, questionStore2.search(question.getHandler()));
    }

    @Test
    public void searchTest() {
        Question question = new Question("Question text");
        questionStore.add(question);
        assertEquals(question, questionStore.search(question.getHandler()));
    }

    @Test
    public void searchDoesntExistsTest() {
        Question question = new Question("Question text");
        assertNull(questionStore.search(question.getHandler()));
    }

    @Test
    public void searchSingletonTest() {
        Question question = new Question("Question text");
        QuestionStore questionStore2 = QuestionStore.getInstance();

        questionStore.add(question);
        assertEquals(question, questionStore.search(question.getHandler()));
        assertEquals(question, questionStore2.search(question.getHandler()));
    }
}