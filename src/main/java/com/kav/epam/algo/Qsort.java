package com.kav.epam.algo;

/**
 * Qsort
 *
 * @author Andrey Kudarenko
 * @version 1.0
 * @since 1.8
 */
public class Qsort implements Sortable {
    /**
     * Method which initialise qsort
     * @param inputArray
     */
    public void sort(int[] inputArray){
        int low = 0;
        int high = inputArray.length - 1;
        qsort(inputArray, low, high);
    }

    /**
     * Method which qsort inputArray
     * @param inputArray
     * @param low
     * @param high
     */
    public void qsort(int[] inputArray, int low, int high){
        if (inputArray == null && inputArray.length == 0){
            return;
        }
        if (low >= high){
            return;
        }
        int middle = low + (high - low) / 2;
        int pivot = inputArray[middle];
        int i = low;
        int j = high;

        while (i <= j ){
            while (inputArray[i] < pivot){
                i++;
            }
            while (inputArray[j] > pivot){
                j--;
            }
            if(i <= j){
                swapPosition(inputArray, i, j);
                i++;
                j--;
            }
        }
        if(low < j){
            qsort(inputArray, low, j);
        }
        if(high > i){
            qsort(inputArray, i, high);
        }
    }

    /**
     * Method which swap two elements in inputArray
     * @param inputArray
     * @param i
     * @param j
     */
    private void swapPosition(int[] inputArray, int i, int j) {
        int temp = inputArray[i];
        inputArray[i] = inputArray[j];
        inputArray[j] = temp;
    }
}
