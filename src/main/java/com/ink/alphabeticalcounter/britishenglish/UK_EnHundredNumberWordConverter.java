package com.ink.alphabeticalcounter.britishenglish;

import com.ink.alphabeticalcounter.NumberWordConverter;
import com.ink.alphabeticalcounter.britishenglish.domain.UK_EnBaseWordNumber;
import com.ink.alphabeticalcounter.britishenglish.domain.UK_EnTensWordNumber;
import com.ink.alphabeticalcounter.WordNumber;

import java.util.Map;
import java.util.TreeMap;

public class UK_EnHundredNumberWordConverter implements NumberWordConverter {

    private static final Map<Integer, WordNumber> BASE_NUMBER_MAP = new TreeMap<>();
    private static final Map<Integer, WordNumber> TENS_NUMBER_MAP = new TreeMap<>();
    public static final String SPACE_STRING = " ";
    public static final String HUNDRED_STRING = "hundred";
    public static final String AND_STRING = "and";

    static {
        for (UK_EnBaseWordNumber number : UK_EnBaseWordNumber.values()) {
            BASE_NUMBER_MAP.put(number.getValue(), number);
        }
        for (UK_EnTensWordNumber number : UK_EnTensWordNumber.values()) {
            TENS_NUMBER_MAP.put(number.getValue(), number);
        }
    }

    public String getNumberAsWord(int number) {
        if (number > 999 || number < 0) {
            throw new IllegalArgumentException("Number cannot be bigger than 999 or smaller than 0");
        }

        StringBuilder resultBuilder = new StringBuilder();

        int hundredDigit = number / 100;

        if (hundredDigit > 0) {
            resultBuilder.append(BASE_NUMBER_MAP.get(hundredDigit).getValueAsWord());
            resultBuilder.append(SPACE_STRING);
            resultBuilder.append(HUNDRED_STRING);
        }

        int decimalNumber = number % 100;

        if (decimalNumber > 0) {

            if (hundredDigit > 0) {
                resultBuilder.append(String.format(" %s ", AND_STRING));
            }

            if (decimalNumber < 20) {
                resultBuilder.append(BASE_NUMBER_MAP.get(decimalNumber).getValueAsWord());
            } else {
                resultBuilder.append(TENS_NUMBER_MAP.get(decimalNumber / 10).getValueAsWord());

                int lastDigit = decimalNumber % 10;
                if (lastDigit > 0) {
                    resultBuilder.append(SPACE_STRING);
                    resultBuilder.append(BASE_NUMBER_MAP.get(lastDigit).getValueAsWord());
                }
            }
        }

        return resultBuilder.toString();
    }
}
