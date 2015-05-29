package com.ink.alphabeticalcounter.britishenglish;

import com.ink.alphabeticalcounter.NumberWordConverter;
import com.ink.alphabeticalcounter.AbstractWordConverterTest;
import com.ink.alphabeticalcounter.britishenglish.domain.UK_EnBaseWordNumber;
import com.ink.alphabeticalcounter.britishenglish.domain.UK_EnBigWordNumber;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UK_EnBigNumberWordConverterTest extends AbstractWordConverterTest {

    public static final UK_EnBigWordNumber BIG_WORD_NUMBER = UK_EnBigWordNumber.THOUSAND;
    private final UK_EnBigNumberWordConverter converter = new UK_EnBigNumberWordConverter(BIG_WORD_NUMBER);

    @Override
    protected NumberWordConverter getConverter() {
        return converter;
    }

    @Test
    public void when_1_IsPassedConvert() {
        testConverter(1, UK_EnBaseWordNumber.ONE.getValueAsWord());
    }

    @Test
    public void when_11_IsPassedConvert() {
        testConverter(11, UK_EnBaseWordNumber.ELEVEN.getValueAsWord());
    }

    @Test
    public void when_27_IsPassedConvert() {
        testConverter(21, "twenty one");
    }

    @Test
    public void when_100_IsPassedConvert() {
        testConverter(100, "one hundred");
    }

    @Test
    public void when_127_IsPassedConvert() {
        testConverter(127, "one hundred and twenty seven");
    }

    @Test
    public void when_105_IsPassedConvert() {
        testConverter(105, "one hundred and five");
    }

    @Test
    public void when_150_IsPassedConvert() {
        testConverter(150, "one hundred and fifty");
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenBiggerThan_999_IsPassedThenThrowIllegalArgumentException() {
        converter.getNumberAsWord(1000);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenNegativeNumberIsPassedThenThrowIllegalArgumentException() {
        converter.getNumberAsWord(-1);
    }

    protected void testConverter(int number, String expectedWordNumber) {
        String bigNumber = String.format("%s %s", expectedWordNumber, BIG_WORD_NUMBER.getValueAsWord());
        super.testConverter(number, bigNumber);
    }
}