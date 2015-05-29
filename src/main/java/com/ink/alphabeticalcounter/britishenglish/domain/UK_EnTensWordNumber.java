package com.ink.alphabeticalcounter.britishenglish.domain;

import com.ink.alphabeticalcounter.WordNumber;

public enum UK_EnTensWordNumber implements WordNumber {

    TWENTY(2, "twenty"),
    THIRTY(3, "thirty"),
    FORTY(4, "forty"),
    FIFTY(5, "fifty"),
    SIXTY(6, "sixty"),
    SEVENTY(7, "seventy"),
    EIGHTY(8, "eighty"),
    NINETY(9, "ninety");

    private int tenValue;
    private String wordValue;

    UK_EnTensWordNumber(int value, String wordValue) {

        this.tenValue = value;
        this.wordValue = wordValue;
    }

    public int getValue() {
        return tenValue;
    }

    public String getValueAsWord() {
        return wordValue;
    }

}
