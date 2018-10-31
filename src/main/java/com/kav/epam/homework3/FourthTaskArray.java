package com.kav.epam.homework3;

/**
 * @author Andrey Kudarenko
 * @version 1.0
 * @since 1.8
 */
public class FourthTaskArray extends ThirdTaskArray {
    /**
     * Method which solve task №12.273 from Zlotopolsky
     *
     * @param charsArray is array of chars [int]x[int]
     * @return String
     * @throws IllegalArgumentException when {@param charsArray} smaller then [1x1]
     */
    public String getWordFromEvenElementsRows(char[][] charsArray) {
        stringBuilder = new StringBuilder();
        if (charsArray.length <= 0 || charsArray[0].length <= 0) {
            throw new IllegalArgumentException("Quantity of rows and columns should be greater then 0");
        }
        for (char[] aCharsArray : charsArray) {
            for (int j = 0; j < aCharsArray.length; j++) {
                if (ThirdTaskArray.isEven(j)) {
                    stringBuilder.append(aCharsArray[j]);
                }
            }
        }
        return stringBuilder.toString();
    }
}
