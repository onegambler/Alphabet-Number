package com.ink.alphabeticalcounter.britishenglish;

import com.ink.alphabeticalcounter.WordNumber;

public class UK_EnBigNumberWordConverter extends UK_EnHundredNumberWordConverter {

    private WordNumber number;

    public UK_EnBigNumberWordConverter(WordNumber numberName) {
        this.number = numberName;
    }

    public String getNumberAsWord(int tripletNumber) {

        if (tripletNumber > 999 || tripletNumber < 0) {
            throw new IllegalArgumentException("Number cannot be bigger than 999 or smaller than 0");
        }

        if(tripletNumber == 0) {
            return "";
        }

        return super.getNumberAsWord(tripletNumber) + " " + number.getValueAsWord();
    }
}
