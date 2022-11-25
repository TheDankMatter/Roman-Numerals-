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

}