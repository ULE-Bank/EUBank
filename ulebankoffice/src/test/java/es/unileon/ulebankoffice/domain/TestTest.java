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
}