package com.kav.epam.algo;

public class BubbleSort {
    private int[] inputArray;
    private int countToSwap;

    public void sort(int[] inputArray) {
        this.inputArray = inputArray;
        for (int i = 0; i < inputArray.length - 1; i++) {
            for (int j = 0; j < inputArray.length - 1; j++) {
                if (inputArray[j] > inputArray[j + 1]) {
                    countToSwap = inputArray[j];
                    inputArray[j] = inputArray[j + 1];
                    inputArray[j + 1] = countToSwap;
                }
            }
        }
    }
}
