package com.kav.epam.homework3;

/**
 * @author Andrey Kudarenko
 * @version 1.0
 * @since 1.8
 */
public class SecondTaskArray {
    /**
     * method which solve task №12.271 from Zlotopolsky
     *
     * @param numberOfRow if a number of rows which we use to get word
     * @param numbers     is array of numbers char in {@param charsArray}
     *                    which include in result String
     * @param charsArray  is array of chars which is using to
     *                    construct result String
     * @return String
     */
    public String getWordFromArray(int numberOfRow, int[] numbers, char[][] charsArray) {
        if (numberOfRow < 0 || numberOfRow >= charsArray.length) {
            throw new IllegalArgumentException("Wrong argument!");
        }
        for (int num : numbers) {
            if (num < 0 || num >= charsArray[numberOfRow].length) {
                throw new IllegalArgumentException("Wrong argument!");
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int num : numbers) {
            stringBuilder.append(String.valueOf(charsArray[numberOfRow][num]));
        }
        return stringBuilder.toString();
    }
}
