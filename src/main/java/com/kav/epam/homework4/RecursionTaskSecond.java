package com.kav.epam.homework4;

/**
 * @author Andrey Kudarenko
 * @version 1.0
 * @since 1.8
 */
public class RecursionTaskSecond {
    double result = 1;

    /**
     * Method which solve 10.42 from Zlotopolsky
     *
     * @param number count which powered
     * @param power  count which number is powered
     * @return
     */
    public double getPoweredNumber(int number, int power) {
        if (number == 0) {
            return 0.0;
        }
        if (power > 0) {
            result = number * getPoweredNumber(number, --power);
        } else if (power < 0) {
            result = 1 / (getPoweredNumber(number, -power));
        } else if (power == 0) {
            return 1;
        }
        return result;
    }
}
