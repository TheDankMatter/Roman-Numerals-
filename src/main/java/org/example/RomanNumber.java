package org.example;

import java.util.Map;

public class RomanNumber {
    String romanNumber = "";
    private Map<Character, Integer> romanToArabic = Map.of(
            'I',1,
            'V',5,
            'X',10,
            'L',50,
            'C',100,
            'D',500,
            'M',1000);


    RomanNumber(String romanNumber) {
        this.romanNumber = romanNumber;
    }

    int toArabic(){
        int value = 0;
        for (int i = 0; i < romanNumber.length(); i++) {
            if ((i < (romanNumber.length() - 1)) && (romanToArabic.get(romanNumber.charAt(i)) < romanToArabic.get(romanNumber.charAt(i + 1)))) {
                value = value + (romanToArabic.get(romanNumber.charAt(i + 1)) - romanToArabic.get(romanNumber.charAt(i)));
                i++;
            } else {
                value = value + romanToArabic.get(romanNumber.charAt(i));
            }
        }
        return value;
    }

}
