package com.kav.epam.algo;

/**
 * MergeSortable
 *
 * @author Andrey Kudarenko
 * @version 1.0
 * @since 1.8
 */
public class MergeSortable implements Sortable {
    private int[] inputArray;
    private int[] helperArray;

    /**
     * Method which initialise the Merge sorting
     *
     * @param inputArray the input array of ints
     */
    public void sort(int[] inputArray) {
        this.inputArray = inputArray;
        this.helperArray = new int[inputArray.length];
        mergeSort(0, inputArray.length - 1);
    }

    /**
     * Method which separate parts of InputArray for sorting by pairs
     *
     * @param lowerBoundary  the low bound
     * @param higherBoundary the high bound
     */
    private void mergeSort(int lowerBoundary, int higherBoundary) {
        if (lowerBoundary < higherBoundary) {
            int middleBoundary = lowerBoundary + (higherBoundary - lowerBoundary) / 2;
            mergeSort(lowerBoundary, middleBoundary);
            mergeSort(middleBoundary + 1, higherBoundary);
            merge(lowerBoundary, middleBoundary, higherBoundary);
        }
    }

    /**
     * Method which sort and merge the sub arrays
     *
     * @param lowerBoundary  the low bound
     * @param middleBoundary the middle bound
     * @param higherBoundary the high bound
     */
    private void merge(int lowerBoundary, int middleBoundary, int higherBoundary) {
        if (higherBoundary + 1 - lowerBoundary >= 0)
            System.arraycopy(this.inputArray, lowerBoundary,
                    this.helperArray, lowerBoundary, higherBoundary + 1 - lowerBoundary);

        int i = lowerBoundary;
        int j = middleBoundary + 1;
        int k = lowerBoundary;

        while (i <= middleBoundary && j <= higherBoundary) {
            if (this.helperArray[i] <= this.helperArray[j]) {
                this.inputArray[k] = this.helperArray[i];
                i++;
            } else {
                this.inputArray[k] = this.helperArray[j];
                j++;
            }
            k++;
        }

        while (i <= middleBoundary) {
            this.inputArray[k] = this.helperArray[i];
            k++;
            i++;
        }
    }
}
