package com.kav.epam.homework4;

/**
 * @author Andrey Kudarenko
 * @version 1.0
 * @since 1.8
 */
public class RecursionTaskFirst {
    int result = 1;

    /**
     * Method which solve 10.41 from Zlotopolsky
     *
     * @param n max number i recursion
     * @return int
     */
    public int getFactorial(int n) {
        if (n > 1) {
            result = n * getFactorial(n - 1);
        } else if (n == 0) {
            return 1;
        } else if (n < 0) {
            throw new IllegalArgumentException("Wrong argument! n must be greater then 0");
        }
        return result;
    }
}
