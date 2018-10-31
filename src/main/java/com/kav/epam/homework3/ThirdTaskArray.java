package com.kav.epam.homework3;

/**
 * @author Andrey Kudarenko
 * @version 1.0
 * @since 1.8
 */
public class ThirdTaskArray {
    StringBuilder stringBuilder;

    /**
     * Method which solve task №12.272(a) from Zlotopolsky
     *
     * @param charsArray is array of chars(5x5)
     * @return String
     * @throws IllegalArgumentException when {@param charsArray} has not 5x5 size
     */
    public String getWordFromArrayInRows(char[][] charsArray) {
        stringBuilder = new StringBuilder();
        if (charsArray.length != 5 || charsArray[0].length != 5) {
            throw new IllegalArgumentException("Quantity of rows and columns should be equal 5");
        }
        for (int i = 0; i < charsArray.length; i++) {
            if (ThirdTaskArray.isEven(i)) {
                for (int j = 0; j < charsArray[i].length; j++) {
                    if (ThirdTaskArray.isEven(j)) {
                        stringBuilder.append(charsArray[i][j]);
                    }
                }
            } else if (!ThirdTaskArray.isEven(i)) {
                for (int j = 0; j < charsArray[i].length; j++) {
                    if (!ThirdTaskArray.isEven(j)) {
                        stringBuilder.append(charsArray[i][j]);
                    }
                }
            }
        }
        return stringBuilder.toString();
    }

    /**
     * Method which solve task №12.272(b) from Zlotopolsky
     *
     * @param charsArray is array of chars(5x5)
     * @return String
     * @throws IllegalArgumentException when {@param charsArray} has not 5x5 size
     */
    public String getWordFromArrayInColumns(char[][] charsArray) {
        stringBuilder = new StringBuilder();
        if (charsArray.length != 5 || charsArray[0].length != 5) {
            throw new IllegalArgumentException("Quantity of rows and columns should be equal 5");
        }
        for (int i = 0; i < charsArray.length; i++) {
            if (ThirdTaskArray.isEven(i)) {
                for (int j = 0; j < charsArray[i].length; j++) {
                    if (ThirdTaskArray.isEven(j)) {
                        stringBuilder.append(charsArray[j][i]);
                    }
                }
            } else if (!ThirdTaskArray.isEven(i)) {
                for (int j = 0; j < charsArray[i].length; j++) {
                    if (!ThirdTaskArray.isEven(j)) {
                        stringBuilder.append(charsArray[j][i]);
                    }
                }
            }
        }
        return stringBuilder.toString();
    }

    /**
     * Method return true is {@param number} is even and false if not
     *
     * @param number count which method checking for even
     * @return
     */
    public static boolean isEven(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Number should be positive");
        }
        return number % 2 == 0;
    }
}
