package com.kav.epam.algo;

/**
 * BinarySearch
 *
 * @author Andrey Kudarenko
 * @version 1.0
 * @since 1.8
 */

public class BinarySearch {

    /**
     * Method which search the place of element in Array
     *
     * @param inputArray
     * @param count
     * @return the place of {@param count} in the {@param inputArray}
     */
    public int search(int[] inputArray, int count) {
        int result = -1;
        int lowBoundary = 0;
        int highBoundary = inputArray.length;
        int middleBoundary;

        while (lowBoundary < highBoundary) {
            middleBoundary = (lowBoundary + highBoundary) / 2;

            if (inputArray[middleBoundary] == count) {
                result = middleBoundary;
                break;
            } else {
                if (count <= inputArray[middleBoundary]) {
                    highBoundary = middleBoundary;
                } else if (count > inputArray[middleBoundary]) {
                    lowBoundary = middleBoundary + 1;
                }
            }
        }
        return result;
    }

}
