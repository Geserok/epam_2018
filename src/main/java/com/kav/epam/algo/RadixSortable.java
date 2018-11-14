package com.kav.epam.algo;

import java.util.Arrays;

/**
 * Radix LSD Search
 *
 * @author Andrey Kudarenko
 * @version 1.0
 * @since 1.8
 */
public class RadixSortable implements Sortable {

    /**
     * Method which initialise Radix sort
     *
     * @param inputArray the input array of ints
     */
    public void sort(int[] inputArray) {
        int maxNumber = getMaxNumber(inputArray);

        for (int rank = 1; maxNumber / rank > 0; rank *= 10) {
            countSort(inputArray, rank);
        }
    }

    /**
     * Method which return the MaxNumber in the inputArray
     *
     * @param inputArray the input array of ints
     * @return max number from {@param inputArray}
     */
    private int getMaxNumber(int[] inputArray) {
        int maxNumber = inputArray[0];

        for (int i = 1; i < inputArray.length; i++) {
            if (inputArray[i] > maxNumber) {
                maxNumber = inputArray[i];
            }
        }
        return maxNumber;
    }

    /**
     * Method which sort inputArray by rank
     *
     * @param inputArray the input array of ints
     * @param rank       the rank of countfrom {@param inputArray}
     */
    private void countSort(int[] inputArray, int rank) {
        int[] outputArray = new int[inputArray.length];
        int i;
        int[] count = new int[10];
        Arrays.fill(count, 0);

        for (i = 0; i < inputArray.length; i++) {
            count[(inputArray[i] / rank) % 10]++;
        }

        for (i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (i = inputArray.length - 1; i >= 0; i--) {
            outputArray[count[(inputArray[i] / rank) % 10] - 1] = inputArray[i];
            count[(inputArray[i] / rank) % 10]--;
        }

        for (i = 0; i < inputArray.length; i++) {
            inputArray[i] = outputArray[i];
        }
    }
}
