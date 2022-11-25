package org.example;

import java.util.Map;
import java.util.Set;

public class RomanNumber {
    private String romanNumber = "";
    private final Map<Character, Integer> romanToArabic = Map.of(
            'I',1,
            'V',5,
            'X',10,
            'L',50,
            'C',100,
            'D',500,
            'M',1000);
    private final Map<String, Integer> subtractionToArabic = Map.of(
            "IV",4,
            "IX",9,
            "XL",40,
            "XC",90,
            "CD",400,
            "CM",900);
    private final Set<Character> repeatingNumbers = Set.of('I', 'X', 'C', 'D');


    RomanNumber(String romanNumber) {
        this.romanNumber = romanNumber;
    }

    int toArabic() {
        int value = 0;
        int currentNumber = 0;
        int consecutiveCounter = 0;
        Character previousSubtraction = null;
        for (int i = 0; i < romanNumber.length(); i++) {
            if (i+2 > (romanNumber.length())){
                currentNumber = romanToArabic.get(romanNumber.charAt(i));
                value = value + currentNumber;
                break;
            }
            if (romanToArabic.get(romanNumber.charAt(i)) == null) {
                throw new java.lang.RuntimeException("Incorrect roman character");
            }
            if (previousSubtraction != null && romanToArabic.get(previousSubtraction) <= romanToArabic.get(romanNumber.charAt(i))) {
                throw new java.lang.RuntimeException("Incorrect order of roman characters");
            } else {
                previousSubtraction = null;
            }
            if (romanToArabic.get(romanNumber.charAt(i)) > romanToArabic.get(romanNumber.charAt(i+1))) {
                currentNumber = romanToArabic.get(romanNumber.charAt(i));
            }
            if ((romanToArabic.get(romanNumber.charAt(i)) == romanToArabic.get(romanNumber.charAt(i+1)))) {
                if (!repeatingNumbers.contains(romanNumber.charAt(i))) {
                    throw new java.lang.RuntimeException(romanNumber.charAt(i) + " Cannot be repeated");
                }
                consecutiveCounter++;
                if (consecutiveCounter == 3) {
                    throw new java.lang.RuntimeException("Characters can be only repeated up to 3 times");
                }
                currentNumber = romanToArabic.get(romanNumber.charAt(i));
            } else {
                consecutiveCounter = 0;
            }
            if (romanToArabic.get(romanNumber.charAt(i)) < romanToArabic.get(romanNumber.charAt(i+1))) {
                String romanString = String.valueOf(romanNumber.charAt(i)) + romanNumber.charAt(i+1);
                if (subtractionToArabic.containsKey(romanString)) {
                    currentNumber = subtractionToArabic.get(romanString);
                    i++;
                    previousSubtraction = romanNumber.charAt(i);
                } else {
                    throw new java.lang.RuntimeException("Incorrect subtractive number");
                }
            }
            value = value + currentNumber;
        }
        return value;
    }
}
