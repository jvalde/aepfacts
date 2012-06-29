package com.develogical;

import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.assertNotNull;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

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
    public void minusRequest() {
        String result = new QueryProcessor().process("f6e50330: what is 15 minus 7");
        assertNotNull(result);
        assertThat(result, is("8"));
    }

    @Test
    public void largestRequest() {
        String result = new QueryProcessor().process("04d115D0: which of the following numbers is the largest: 663, 78, 675, 94");
        assertNotNull(result);
        assertThat(result, is("675"));
    }

    @Test
    public void multiplyRequest() {
        String result = new QueryProcessor().process("b81b7400: what is 11 multiplied by 2");
        assertNotNull(result);
        assertThat(result, is("22"));
    }

    @Test
    public void fibonacciRequest() {
        String result = new QueryProcessor().process("18ee1bd0: what is the 6th number in the Fibonacci sequence");
        assertNotNull(result);
        assertThat(result, is("8"));
    }

    @Test
    public void powerRequest() {
        String result = new QueryProcessor().process("94c8ce10: what is 18 to the power of 15");
        assertNotNull(result);
        assertThat(result, is("6746640616477458432"));
    }

    @Test
    public void primeRequest() {
        String result = new QueryProcessor().process("d63ff100: which of the following numbers are primes: 347, 31, 61, 511");
        assertNotNull(result);
        assertThat(result, is("347, 31, 61"));
    }

    @Test
    public void hasTwoFunctionsReturnFalseRequest() {
        boolean result = new QueryProcessor().hasTwoOperations("d63ff100: which of the following numbers are primes: 347, 31, 61, 511");
        assertNotNull(result);
        assertThat(result, is(false));
    }

    @Test
    public void hasTwoFunctionsReturnTrueRequest() {
        boolean result = new QueryProcessor().hasTwoOperations("d63ff100: what is 23 plus 45 plus 34");
        assertNotNull(result);
        assertThat(result, is(true));
    }

    @Test
    public void getOperationsRequest() {
        List<String> result = new QueryProcessor().getOperations("d63ff100: what is 23 plus 45 plus 34");
        assertNotNull(result);
        assertThat(result.get(0), is("plus"));
        assertThat(result.get(1), is("plus"));
    }

    @Test
    public void getOperationsPlusMultipliedRequest() {
        List<String> result = new QueryProcessor().getOperations("d63ff100: what is 23 plus 45 multiplied 34");
        assertNotNull(result);
        assertThat(result.get(0), is("plus"));
        assertThat(result.get(1), is("multiplied"));
    }


}