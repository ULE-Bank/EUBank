package es.unileon.ulebankoffice.domain;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import es.unileon.ulebankoffice.service.InvestorProfile;

public class InvestorProfileTest {
    private InvestorProfile investorProfile;
    private Answers answers;
    private QuestionStore questionStore;

    @Before
    public void setUp() throws Exception {
        this.investorProfile = new InvestorProfile();
    	ArrayList<double[]> list = new ArrayList<double[]>();
    	list.add(new double[]{0, 50});
    	list.add(new double[]{50, 100});
    	HashMap<Integer, String> hm = new HashMap<>();
    	hm.put(0, "first");
    	hm.put(1, "second");
        this.investorProfile.setRanges(list);
        this.investorProfile.setTypes(hm);
        Field instance = QuestionStore.class.getDeclaredField("singleton");
        instance.setAccessible(true);
        instance.set(null, null);
        QuestionStore questionStore = QuestionStore.getInstance();
        Question question = new Question("Question text 1");
        Simple simple = new Simple("Simple option text", 2f);
        question.add(simple);
        questionStore.add(question);
        
        Answer answer = new Answer(question.getHandler(), simple.getHandler());

        this.answers = new Answers();
        this.answers.add(answer);
    }

    @Test
    public void getFirst() throws Exception {
    	Field instance = QuestionStore.class.getDeclaredField("singleton");
        instance.setAccessible(true);
        instance.set(null, null);
        Question question = new Question("Question text 1");
        Simple simple = new Simple("Simple option text", 2f);
        question.add(simple);
        QuestionStore questionStore = QuestionStore.getInstance();
        questionStore.add(question);
        
        Answer answer = new Answer(question.getHandler(), simple.getHandler());

        this.answers = new Answers();
        this.answers.add(answer);
    	assertEquals("first", this.investorProfile.getInvestorProfile(this.answers));
    }
    
    @Test
    public void getSecond() throws Exception {
    	Field instance = QuestionStore.class.getDeclaredField("singleton");
        instance.setAccessible(true);
        instance.set(null, null);
        questionStore = QuestionStore.getInstance();
    	Question question = new Question("Question text 2");
        Simple simple = new Simple("Simple option text 2", 70f);
        question.add(simple);
        questionStore.add(question);
         
        Answer answer = new Answer(question.getHandler(), simple.getHandler());
 		this.answers = new Answers();
        this.answers.add(answer);

        assertEquals("second", this.investorProfile.getInvestorProfile(this.answers));
    }
    
    @Test
    public void getEdge() throws Exception {
    	Field instance = QuestionStore.class.getDeclaredField("singleton");
        instance.setAccessible(true);
        instance.set(null, null);
        questionStore = QuestionStore.getInstance();
		Question question = new Question("Question text 2");
		Simple simple = new Simple("Simple option text 2", 50f);
		question.add(simple);
		questionStore.add(question);
		 
		Answer answer = new Answer(question.getHandler(), simple.getHandler());
		this.answers = new Answers();
		this.answers.add(answer);
    	assertEquals("second", this.investorProfile.getInvestorProfile(this.answers));
    }
    
    @Test
    public void getEmpty() throws Exception {
    	this.investorProfile = new InvestorProfile(); 
    	ArrayList<double[]> list = new ArrayList<double[]>();
    	HashMap<Integer, String> hm = new HashMap<>();
        this.investorProfile.setRanges(list);
        this.investorProfile.setTypes(hm);
    	assertEquals(InvestorProfile.EMPTY, this.investorProfile.getInvestorProfile(this.answers));
    }
    
    @Test
    public void getValue() throws Exception {
    	assertEquals(2d, this.investorProfile.getResultTest(this.answers), 0.0);
    }
    
    @Test
    public void getRanges() throws Exception {
    	this.investorProfile = new InvestorProfile(); 
    	ArrayList<double[]> list = new ArrayList<double[]>();
        this.investorProfile.setRanges(list);
    	assertEquals(list, this.investorProfile.getRanges());
    }
    
    @Test
    public void getTypes() throws Exception {
    	this.investorProfile = new InvestorProfile(); 
    	HashMap<Integer, String> hm = new HashMap<>();
        this.investorProfile.setTypes(hm);
    	assertEquals(hm, this.investorProfile.getTypes());
    }
}