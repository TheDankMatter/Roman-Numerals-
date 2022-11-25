package org.example;

import static org.junit.jupiter.api.Assertions.*;

class RomanNumberTest {

    @org.junit.jupiter.api.Test
    void toArabicThreeConsecutiveSymbols() {
        assertEquals(new RomanNumber("III").toArabic(),3);
    }

    @org.junit.jupiter.api.Test
    void toArabicSubtractiveNumber() {
        assertEquals(new RomanNumber("IV").toArabic(),4);
    }

    @org.junit.jupiter.api.Test
    void toArabicSingleValue() {
        assertEquals(new RomanNumber("V").toArabic(),5);
    }

    @org.junit.jupiter.api.Test
    void toArabicTwoDifferentConsecutiveNumbers() {
        assertEquals(new RomanNumber("VI").toArabic(),6);
    }

    @org.junit.jupiter.api.Test
    void toArabicTwoSameConsecutiveNumbersAfterANumber() {
        assertEquals(new RomanNumber("VII").toArabic(),7);
    }

    @org.junit.jupiter.api.Test
    void toArabicThreeSameConsecutiveNumbersAfterANumber() {
        assertEquals(new RomanNumber("VIII").toArabic(),8);
    }

    @org.junit.jupiter.api.Test
    void toArabicFourDifferentCharacters() {
        assertEquals(new RomanNumber("XLIV").toArabic(),44);
    }

    @org.junit.jupiter.api.Test
    void toArabicNineDifferentCharacters() {
        assertEquals(new RomanNumber("MCMLXXXVI").toArabic(),1986);
    }

    @org.junit.jupiter.api.Test
    void toArabicWrongCharacters() {
        String exceptionMessage = null;
        try{
            new RomanNumber("ABC").toArabic();
        }
        catch(RuntimeException re) {
            exceptionMessage = re.getMessage();
        }
        String expectedMessage = "Incorrect roman character";
        assertEquals(expectedMessage, exceptionMessage);
    }

    @org.junit.jupiter.api.Test
    void toArabicTwoWrongConsecutiveNumbers() {
        String exceptionMessage = null;
        try{
            new RomanNumber("LL").toArabic();
        }
        catch(RuntimeException re) {
            exceptionMessage = re.getMessage();
        }
        String expectedMessage = "L Cannot be repeated";
        assertEquals(expectedMessage, exceptionMessage);
    }

    @org.junit.jupiter.api.Test
    void toArabicFourConsecutiveNumbers() {
        String exceptionMessage = null;
        try{
            new RomanNumber("IIII").toArabic();
        }
        catch(RuntimeException re) {
            exceptionMessage = re.getMessage();
        }
        String expectedMessage = "Characters can be only repeated up to 3 times";
        assertEquals(expectedMessage, exceptionMessage);
    }

    @org.junit.jupiter.api.Test
    void toArabicIncorrectSequenceWithSubtractiveNumber() {
        String exceptionMessage = null;
        try{
            new RomanNumber("LILI").toArabic();
        }
        catch(RuntimeException re) {
            exceptionMessage = re.getMessage();
        }
        String expectedMessage = "Incorrect subtractive number";
        assertEquals(expectedMessage, exceptionMessage);
    }

}