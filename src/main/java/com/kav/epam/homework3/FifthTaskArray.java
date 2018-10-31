package com.kav.epam.homework3;

/**
 * @author Andrey Kudarenko
 * @version 1.0
 * @since 1.8
 */
public class FifthTaskArray extends ThirdTaskArray {
    /**
     * Method which solve task №12.274 from Zlotopolsky
     *
     * @param charsArray is array of chars
     * @return String
     * @throws IllegalArgumentException when {@param charsArray} smaller then [1x1]
     */
    public String getWordFromUnevenElementsColumn(char[][] charsArray) {
        stringBuilder = new StringBuilder();
        if (charsArray.length <= 0 || charsArray[0].length <= 0) {
            throw new IllegalArgumentException("Quantity of rows and columns should be greater then 0");
        }
        for (int i = 0; i < charsArray.length; i++) {
            for (int j = 0; j < charsArray[i].length; j++) {
                if (!ThirdTaskArray.isEven(j)) {
                    stringBuilder.append(charsArray[j][i]);
                }
            }
        }
        return stringBuilder.toString();
    }
}

