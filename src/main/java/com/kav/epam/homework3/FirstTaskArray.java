package com.kav.epam.homework3;

/**
 * @author Andrey Kudarenko
 * @version 1.0
 * @since 1.8
 */
public class FirstTaskArray {

    /**
     * method which solve task №12.270 from Zlotopolsky
     *
     * @param charArray
     * @return String the String which consist of corners char from {@param charArray}
     * @throws IllegalArgumentException when quantity of
     *                                  rows in {@param charArray}
     */
    public String getStringFromCornersChars(char[][] charArray) {
        int numberOfRows = charArray.length;
        if (numberOfRows < 2) {
            throw new IllegalArgumentException("Number of rows must be equal or more then 2");
        }
        String topCornersChars = getFirstAndLastChar(charArray[0]);
        String bottomCornerChars = getFirstAndLastChar(charArray[numberOfRows - 1]);
        return topCornersChars + bottomCornerChars;
    }

    /**
     * @param charArr
     * @return the String which consist of the 1st and the 2nd chars from {@param charArr}
     */
    private String getFirstAndLastChar(char[] charArr) {
        int length = charArr.length;
        if (length < 2) {
            throw new IllegalArgumentException("Length of row must be equal or more then 2");
        }
        return String.valueOf(charArr[0]) + String.valueOf(charArr[length - 1]);
    }
}
