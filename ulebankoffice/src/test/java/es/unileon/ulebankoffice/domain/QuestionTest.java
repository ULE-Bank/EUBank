package es.unileon.ulebankoffice.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class QuestionTest {
    private Question question;

    @Before
    public void setUp() {
        this.question = new Question("Question test");
    }

    @Test
    public void testAdd() {
        Option option = new Simple("Option simple", 0.2f);
        assertNull(question.search(option.getHandler()));
        question.add(option);
        assertEquals(option, question.search(option.getHandler()));
    }

    @Test
    public void testSame() {
        Option option = new Simple("Option simple", 0.2f);
        assertNull(question.search(option.getHandler()));
        question.add(option);
        question.add(option);
        assertEquals(option, question.search(option.getHandler()));
    }


    @Test
    public void testSearchExistsSimple() {
        Option option = new Simple("Option simple", 0.2f);
        question.add(option);
        assertEquals(option, question.search(option.getHandler()));
    }

    @Test
    public void testSearchExistsCompund() {
        Option option = new Compound("Option compound");
        question.add(option);
        assertEquals(option, question.search(option.getHandler()));
    }

    @Test
    public void testSearchDoesntExists() {
        Option option = new Simple("Option simple", 0.2f);
        assertNull(question.search(option.getHandler()));
    }

    @Test
    public void testSearchExistsSimpleInsideCompound() {
    	long timestamp = new Date().getTime();
        Compound optionCompound = new Compound("Option compound",new Options(), new OptionHandler(timestamp));
        Simple optionSimple = new Simple("Option simple", 0.2f, new OptionHandler(timestamp + 1));
        optionCompound.add(optionSimple);
        question.add(optionCompound);
        assertEquals(optionSimple, question.search(optionSimple.getHandler()));
    }

    @Test
    public void testRemoveExistsSimple() {
        Option option = new Simple("Option simple", 0.2f);
        question.add(option);
        question.remove(option.getHandler());
        assertNull(question.search(option.getHandler()));
    }

    @Test
    public void testRemoveExistsCompund() {
        Option option = new Compound("Option compound");
        question.add(option);
        question.remove(option.getHandler());
        assertNull(question.search(option.getHandler()));
    }

    @Test
    public void testRemoveDoesntExists() {
        Option option = new Simple("Option simple", 0.2f);
        question.remove(option.getHandler());
        assertNull(question.search(option.getHandler()));
    }

    @Test
    public void testRemoveExistsSimpleInsideCompound() {
        Compound optionCompound = new Compound("Option compound");
        Simple optionSimple = new Simple("Option simple", 0.2f);
        optionCompound.add(optionSimple);
        question.add(optionCompound);
        question.remove(optionSimple.getHandler());
        assertNull(question.search(optionSimple.getHandler()));
    }

}