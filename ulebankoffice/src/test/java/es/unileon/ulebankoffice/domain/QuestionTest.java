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
    	this.question.setPosition(1);
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
        Option option = new Simple("", 0.2f);
        option.setText("Option simple");
        assertNull(question.search(option.getHandler()));
        question.add(option);
        question.add(option);
        assertEquals(option, question.search(option.getHandler()));
        question.setId("5");
        assertEquals("5", question.getId());
    }

    @Test
    public void testGetOptions() {
    	Option option = new Simple("Option simple", 0.2f);
        assertNull(question.search(option.getHandler()));
        question.add(option);
        
        for(Option optionFromQuestion: question.getOptions()) {
        	assertEquals(option, optionFromQuestion);
        }
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
    
    @Test
    public void testCompareToBigger() {
    	Question biggerQuestion = new Question("");
    	biggerQuestion.setPosition(2);
    	assertEquals(this.question.compareTo(biggerQuestion), -1);
    }
    
    @Test
    public void testCompareToSmaller() {
    	Question smallerQuestion = new Question("");
    	smallerQuestion.setPosition(0);
    	assertEquals(this.question.compareTo(smallerQuestion), 1);
    }
    
    @Test
    public void testCompareToSame() {
    	assertEquals(this.question.compareTo(this.question), 0);
    }

}