package com.ink.alphabeticalcounter.britishenglish.domain;

import com.ink.alphabeticalcounter.WordNumber;

public enum UK_EnBigWordNumber implements WordNumber {

    THOUSAND(1, "thousand"),
    MILLION(2, "million");

    private int numberOfTriple;
    private String wordValue;

    UK_EnBigWordNumber(int value, String wordValue) {

        this.numberOfTriple = value;
        this.wordValue = wordValue;
    }

    public int getValue() {
        return numberOfTriple;
    }

    public String getValueAsWord() {
        return wordValue;
    }
}
