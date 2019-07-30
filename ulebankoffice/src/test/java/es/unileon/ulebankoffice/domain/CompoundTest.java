package es.unileon.ulebankoffice.domain;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class CompoundTest {
    private Compound compound;

    @Before
    public void setUp() {
        this.compound = new Compound("Compound option test");
    }

    @Test
    public void searchTest() {
    	long timestamp = new Date().getTime();
        Simple simpleOption = new Simple("Simple option", 2.3f, new OptionHandler(timestamp));
        Simple simpleOption2 = new Simple("Simple option 2", 2.8f, new OptionHandler(timestamp + 1));

        assertNull(this.compound.search(simpleOption.getHandler()));
        assertNull(this.compound.search(simpleOption2.getHandler()));

        this.compound.add(simpleOption);
        assertEquals(simpleOption, this.compound.search(simpleOption.getHandler()));

        this.compound.add(simpleOption2);
        assertEquals(simpleOption2, this.compound.search(simpleOption2.getHandler()));
    }

    @Test
    public void addTest() {
        Simple simpleOption = new Simple("Simple option", 2.3f);
        assertNull(this.compound.search(simpleOption.getHandler()));
        this.compound.add(simpleOption);
        assertEquals(simpleOption, this.compound.search(simpleOption.getHandler()));
    }

    @Test
    public void removeTest() {
        Simple simpleOption = new Simple("Simple option", 2.3f);
        assertNull(this.compound.search(simpleOption.getHandler()));
        
        this.compound.add(simpleOption);
        assertEquals(simpleOption, this.compound.search(simpleOption.getHandler()));

        this.compound.remove(simpleOption.getHandler());
        assertNull(this.compound.search(simpleOption.getHandler()));
    }
}