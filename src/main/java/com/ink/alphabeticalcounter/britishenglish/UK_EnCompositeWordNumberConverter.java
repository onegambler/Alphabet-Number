package com.ink.alphabeticalcounter.britishenglish;


import com.ink.alphabeticalcounter.NumberWordConverter;
import com.ink.alphabeticalcounter.WordNumber;
import com.ink.alphabeticalcounter.britishenglish.domain.UK_EnBaseWordNumber;
import com.ink.alphabeticalcounter.britishenglish.domain.UK_EnBigWordNumber;
import java.util.HashMap;
import java.util.Map;

public class UK_EnCompositeWordNumberConverter implements NumberWordConverter {

    private static final double TRIPLET_LENGTH = 3d;
    public static final String AND_STRING = "and";
    private Map<Integer, NumberWordConverter> numberConverterMap = new HashMap<>();


    public UK_EnCompositeWordNumberConverter() {
        for (WordNumber wordNumber : UK_EnBigWordNumber.values()) {
            numberConverterMap.put(wordNumber.getValue(), new UK_EnBigNumberWordConverter(wordNumber));
        }

        numberConverterMap.put(0, new UK_EnHundredNumberWordConverter());
    }


    public String getNumberAsWord(int number) {

        int numberLength = String.valueOf(number).length();

        if(!canHandleNumber(numberLength)) {
            throw new IllegalArgumentException("The number inserted is not valid, can handle numbers between -/+ ");
        }
        if(number == 0) {
            return UK_EnBaseWordNumber.ZERO.getValueAsWord();
        }

        int tripletCount = (int) Math.ceil(numberLength / TRIPLET_LENGTH);
        int tripletValue;

        StringBuilder numberBuilder = new StringBuilder();

        for (int i = 0; i < tripletCount; i++) {
            tripletValue = number % 1000;

            if (tripletValue > 0) {
                numberBuilder.insert(0, " ");
            }

            numberBuilder.insert(0, numberConverterMap.get(i).getNumberAsWord(tripletValue));

            if (i == 0 && number > 999 && tripletValue > 0 && tripletValue < 100) {
                numberBuilder.insert(0, AND_STRING + " ");
            }

            number /= 1000;
        }

        return numberBuilder.toString().trim();
    }

    private boolean canHandleNumber(int numberLength) {
        int values = UK_EnBigWordNumber.values().length;
        int bigWordNumberScale = UK_EnBigWordNumber.values()[values - 1].getValue();
        return numberLength <= bigWordNumberScale * 3 + 3;
    }
}
