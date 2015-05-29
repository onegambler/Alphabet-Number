package com.ink.alphabeticalcounter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@RunWith(MockitoJUnitRunner.class)
public class WordNumberProcessorTest {

    @Mock
    private NumberWordConverter converter;

    private NumberWordProcessor processor;

    @Before
    public void initTest() {
        processor = new NumberWordProcessor(converter);
    }

    @Test
    public void whenConvertNumberToLiteralIsCalledThenDelegateToConverter() {
        processor.convertNumberToLiteral(100);
        verify(converter, times(1)).getNumberAsWord(100);
        verifyNoMoreInteractions(converter);
    }

    @Test(expected = NullPointerException.class)
    public void whenNoConverterIsPassedThenThrowNullPointerException() {
        new NumberWordProcessor(null);
    }
}