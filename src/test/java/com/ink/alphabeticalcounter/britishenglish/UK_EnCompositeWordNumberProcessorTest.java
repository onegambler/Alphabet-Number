package com.ink.alphabeticalcounter.britishenglish;

import com.ink.alphabeticalcounter.NumberWordConverter;
import com.ink.alphabeticalcounter.AbstractWordConverterTest;
import com.ink.alphabeticalcounter.britishenglish.domain.UK_EnBaseWordNumber;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class UK_EnCompositeWordNumberProcessorTest extends AbstractWordConverterTest {

    private UK_EnCompositeWordNumberConverter converter = new UK_EnCompositeWordNumberConverter();

    @Test
    public void when_0_IsPassedConvert() {
        testConverter(0, UK_EnBaseWordNumber.ZERO.getValueAsWord());
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
        testConverter(27, "twenty seven");
    }

    @Test
    public void when_100_IsPassedConvert() {
        testConverter(100, "one hundred");
    }

    @Test
    public void when_1000_IsPassedConvert() {
        testConverter(1000, "one thousand");
    }

    @Test
    public void when_1_000_000_IsPassedConvert() {
        testConverter(1_000_000, "one million");
    }

    @Test
    public void when_1004_IsPassedConvert() {
        testConverter(1_004, "one thousand and four");
    }

    @Test
    public void when_1_000_026_IsPassedConvert() {
        testConverter(1_000_026, "one million and twenty six");
    }

    @Test
    public void when_1_003_456_IsPassedConvert() {
        testConverter(1_003_456, "one million three thousand four hundred and fifty six");
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenNumberTooBigIsPassedThenThrowIllegalArgumentException() {
        testConverter(1_000_000_000, "one million three thousand four hundred and fifty six");
    }

    @Test
    public void when_127_IsPassedConvert() {
        testConverter(127, "one hundred and twenty seven");
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenNegativeNumberIsPassedThenThrowIllegalArgumentException() {
        converter.getNumberAsWord(-1);
    }

    @Test
    public void when_227_IsPassedConvert() {
        testConverter(227, "two hundred and twenty seven");
    }

    @Test
    public void when_56_945_781_IsPassedConvert() {
        testConverter(56_945_781, "fifty six million nine hundred and forty five thousand seven hundred and eighty one");
    }

    @Override
    protected NumberWordConverter getConverter() {
        return converter;
    }
}
