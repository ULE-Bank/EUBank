package es.unileon.ulebankoffice.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;
import java.util.Iterator;

public class AnswersTest {
    private Answers answers;

    @Before
    public void setUp() {
        this.answers = new Answers();
    }

    @Test
    public void addTest() throws Exception {
        QuestionStore questionStore = QuestionStore.getInstance();
        Question question = new Question("Question text 2");
        Simple simple = new Simple("Simple option text", 2.3f);
        question.add(simple);
        questionStore.add(question);

        Answer answer = new Answer(question.getHandler(), simple.getHandler());
        assertNull(this.answers.search(answer.getHandler()));
        this.answers.add(answer);
        assertEquals(answer, this.answers.search(answer.getHandler()));
    }

    @Test
    public void addTestDuplicated() throws Exception {
        QuestionStore questionStore = QuestionStore.getInstance();
        Question question = new Question("Question text 2");
        Simple simple = new Simple("Simple option text", 2.3f);
        question.add(simple);
        questionStore.add(question);

        Answer answer = new Answer(question.getHandler(), simple.getHandler());
        assertNull(this.answers.search(answer.getHandler()));
        this.answers.add(answer);
        assertEquals(answer, this.answers.search(answer.getHandler()));
        this.answers.add(answer);

        int total = 0;
        Iterator<Answer> iterator = this.answers.getIterator();

        while(iterator.hasNext()) {
            total++;
            iterator.next();
        }

        assertEquals(1, total);

    }

    @Test
    public void searchTest() throws Exception {
        QuestionStore questionStore = QuestionStore.getInstance();
        Question question = new Question("Question text 2");
        Simple simple = new Simple("Simple option text", 2.3f);
        question.add(simple);
        questionStore.add(question);

        Answer answer = new Answer(question.getHandler(), simple.getHandler());
        assertNull(this.answers.search(answer.getHandler()));
        this.answers.add(answer);
        assertEquals(answer, this.answers.search(answer.getHandler()));
    }

    @Test
    public void removeTest() throws Exception {
        QuestionStore questionStore = QuestionStore.getInstance();
        Question question = new Question("Question text 2");
        Simple simple = new Simple("Simple option text", 2.3f);
        question.add(simple);
        questionStore.add(question);

        Answer answer = new Answer(question.getHandler(), simple.getHandler());
        this.answers.add(answer);
        assertEquals(answer, this.answers.search(answer.getHandler()));
        this.answers.remove(answer.getHandler());
        assertNull(this.answers.search(answer.getHandler()));

    }
}