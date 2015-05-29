package com.ink.alphabeticalcounter.britishenglish;


import com.ink.alphabeticalcounter.NumberWordConverter;
import com.ink.alphabeticalcounter.britishenglish.domain.UK_EnBaseWordNumber;
import com.ink.alphabeticalcounter.britishenglish.domain.UK_EnTensWordNumber;
import com.ink.alphabeticalcounter.WordNumber;

import java.util.Map;
import java.util.TreeMap;

public class UK_EnTensNumberWordConverter implements NumberWordConverter {

    protected static final Map<Integer, WordNumber> BASE_NUMBER_MAP = new TreeMap<>();
    private static final Map<Integer, WordNumber> TENS_NUMBER_MAP = new TreeMap<>();

    static {
        for(UK_EnBaseWordNumber number : UK_EnBaseWordNumber.values()) {
            BASE_NUMBER_MAP.put(number.getValue(), number);
        }
        for(UK_EnTensWordNumber number : UK_EnTensWordNumber.values()) {
            TENS_NUMBER_MAP.put(number.getValue(), number);
        }
    }

    @Override
    public String getNumberAsWord(int number) {
        if(number > 99 || number < 0) {
            throw new IllegalArgumentException("Number cannot be bigger than 99 or negative");
        }
        StringBuilder numberBuilder = new StringBuilder();

        if(number >= 10) {
            numberBuilder.append(TENS_NUMBER_MAP.get(number / 10).getValueAsWord());
            numberBuilder.append(" ");
        }

        int digit = number % 10;
        if(digit > 0) {
            numberBuilder.append(BASE_NUMBER_MAP.get(digit).getValueAsWord());
        }

        return numberBuilder.toString();
    }
}
