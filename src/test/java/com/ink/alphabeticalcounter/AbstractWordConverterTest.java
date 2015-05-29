package com.ink.alphabeticalcounter;

import static org.junit.Assert.assertEquals;

public abstract class AbstractWordConverterTest {

    protected NumberWordConverter converter;

    protected void testConverter(int number, String expectedWordNumber) {
        String result = initializeAndGetConverter().getNumberAsWord(number);
        assertEquals(expectedWordNumber, result);
    }

    protected abstract NumberWordConverter getConverter();

    private NumberWordConverter initializeAndGetConverter() {
        if(converter == null) {
            converter = getConverter();
        }

        return converter;
    }
}
