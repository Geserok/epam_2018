package com.kav.epam.homework4;

/**
 * @author Andrey Kudarenko
 * @version 1.0
 * @since 1.8
 */
public class RecursionTaskThird {
    int result;

    /**
     * Method which solve 10.43a from Zlotopolsky
     *
     * @param number must be natural
     * @return the sum of each count in number
     */
    public int sumOfCountNumber(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Wrong argument! Number must be greater then 0!");
        }

        String numberString = String.valueOf(number);
        char[] charsOfCounts = numberString.toCharArray();
        result = 0;
        for (char count : charsOfCounts) {
            result += Integer.parseInt(String.valueOf(count));
        }
        return result;
    }

    /**
     * Method which solve 10.43b from Zlotopolsky
     *
     * @param number must be natural
     * @return the quantity of count in number
     */
    public int quantityOfCount(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Wrong argument! Number must be greater then 0!");
        }

        String numberString = String.valueOf(number);
        return numberString.length();
    }
}
