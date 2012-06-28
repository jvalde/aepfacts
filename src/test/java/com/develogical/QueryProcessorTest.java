package com.develogical;

import org.junit.Test;

import java.util.Map;

import static junit.framework.Assert.assertNotNull;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;

public class QueryProcessorTest {

    @Test
    public void canGreetYou() {
        String result = new QueryProcessor().process("hi");
        assertNotNull(result);
        assertThat(result, is("hello"));
    }

    @Test
    public void ourName() {
        String result = new QueryProcessor().process("what is your name");
        assertNotNull(result);
        assertThat(result, is("Lean Fighter"));
    }

    @Test
    public void returnsEmptyStringForUnknownQueries() {
        String result = new QueryProcessor().process("unknown");
        assertNotNull(result);
        assertThat(result, is(""));
    }

    @Test
     public void sumRequest() {
        String result = new QueryProcessor().process("32b4e260: what is 10 plus 17");
        assertNotNull(result);
        assertThat(result, is("27"));
    }

    @Test
    public void largestRequest() {
        String result = new QueryProcessor().process("04d115D0: which of the following numbers is the largest: 6, 8, 5, 3, 853");
        assertNotNull(result);
        assertThat(result, is("853"));
    }
}



