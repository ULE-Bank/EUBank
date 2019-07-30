package es.unileon.ulebankoffice.domain;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.Field;

import org.junit.Before;
import org.junit.Test;

public class AnswerTest {
    private QuestionStore questionStore;

    @Before
    public void setUp() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        Field instance = QuestionStore.class.getDeclaredField("singleton");
        instance.setAccessible(true);
        instance.set(null, null);
        this.questionStore = QuestionStore.getInstance();
    }
    
    @Test
    public void answerTest () throws Exception {
        String questionText = "Question text";
        String optionText = "Option text";

        Question question = new Question(questionText);
        Simple simple = new Simple(optionText, 2.3f);
        question.add(simple);
        questionStore.add(question);

        Answer answer = new Answer(question.getHandler(), simple.getHandler());
        assertEquals(answer.getQuestion().getText(), questionText);
        assertEquals(answer.getOption().getText(), optionText);

    }

    @Test(expected = Exception.class) 
    public void answerTestWrongOption () throws Exception {
        Question question = new Question("Question text 2");
        Simple simple = new Simple("Simple option text", 2.3f);
        questionStore.add(question);

        Answer answer = new Answer(question.getHandler(), simple.getHandler());
    }
}