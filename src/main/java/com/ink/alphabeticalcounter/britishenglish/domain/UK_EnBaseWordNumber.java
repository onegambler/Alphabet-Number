package com.ink.alphabeticalcounter.britishenglish.domain;

import com.ink.alphabeticalcounter.WordNumber;

public enum UK_EnBaseWordNumber implements WordNumber {

    ZERO(0, "zero"),
    ONE(1, "one"),
    TWO(2, "two"),
    THREE(3, "three"),
    FOUR(4, "four"),
    FIVE(5, "five"),
    SIX(6, "six"),
    SEVEN(7, "seven"),
    EIGHT(8, "eight"),
    NINE(9, "nine"),
    TEN(10, "ten"),
    ELEVEN(11, "eleven"),
    TWELVE(12, "twelve"),
    THIRTEEN(13, "thirteen"),
    FOURTEEN(14, "fourteen"),
    FIFTEEN(15, "fifteen"),
    SIXTEEN(16, "sixteen"),
    SEVENTEEN(17, "seventeen"),
    EIGHTEEN(18, "eighteen"),
    NINETEEN(19, "nineteen");

    private int value;
    private String wordValue;

    UK_EnBaseWordNumber(int value, String wordValue) {

        this.value = value;
        this.wordValue = wordValue;
    }

    public int getValue() {
        return value;
    }

    public String getValueAsWord() {
        return wordValue;
    }

}
