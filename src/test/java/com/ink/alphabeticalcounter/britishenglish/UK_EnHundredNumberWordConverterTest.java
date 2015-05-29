package com.ink.alphabeticalcounter.britishenglish;

import com.ink.alphabeticalcounter.NumberWordConverter;
import com.ink.alphabeticalcounter.AbstractWordConverterTest;
import com.ink.alphabeticalcounter.britishenglish.domain.UK_EnBaseWordNumber;
import org.junit.Test;

import static org.junit.Assert.*;

public class UK_EnHundredNumberWordConverterTest extends AbstractWordConverterTest {

    private UK_EnHundredNumberWordConverter converter = new UK_EnHundredNumberWordConverter();

    @Test
    public void when_1_IsPassedConvert() {
        testCounter(1, UK_EnBaseWordNumber.ONE.getValueAsWord());
    }

    @Test
    public void when_11_IsPassedConvert() {
        testCounter(11, UK_EnBaseWordNumber.ELEVEN.getValueAsWord());
    }

    @Test
    public void when_27_IsPassedConvert() {
        testCounter(21, "twenty one");
    }

    @Test
    public void when_100_IsPassedConvert() {
        testCounter(100, "one hundred");
    }

    @Test
    public void when_127_IsPassedConvert() {
        testCounter(127, "one hundred and twenty seven");
    }

    @Test
    public void when_105_IsPassedConvert() {
        testCounter(105, "one hundred and five");
    }

    @Test
    public void when_150_IsPassedConvert() {
        testCounter(150, "one hundred and fifty");
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenBiggerThan_999_IsPassedThenThrowIllegalArgumentException() {
        converter.getNumberAsWord(1000);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenNegativeNumberIsPassedThenThrowIllegalArgumentException() {
        converter.getNumberAsWord(-1);
    }

    private void testCounter(int number, String expectedWordNumber) {
        String result = converter.getNumberAsWord(number);
        assertEquals(expectedWordNumber, result);
    }

    @Override
    protected NumberWordConverter getConverter() {
        return converter;
    }
}