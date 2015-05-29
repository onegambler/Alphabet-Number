package com.ink.alphabeticalcounter;

import com.ink.alphabeticalcounter.britishenglish.UK_EnCompositeWordNumberConverter;

import static java.util.Objects.requireNonNull;

public class NumberWordProcessor {

    public NumberWordConverter converter;

    public NumberWordProcessor(NumberWordConverter converter) {
        requireNonNull(converter, "Converter cannot be null");
        this.converter = converter;
    }

    public String convertNumberToLiteral(int number) {
        return converter.getNumberAsWord(number);
    }
}
