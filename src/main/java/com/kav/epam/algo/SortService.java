package com.kav.epam.algo;

import java.util.Arrays;

public class SortService {
    private static int[] arr;

    public static void main(String[] args) {
        demonstrate();
    }

    private static void demonstrate() {
        BubbleSortable bubbleSort = new BubbleSortable();
        Qsort qsort = new Qsort();
        RadixSortable radixSort = new RadixSortable();
        MergeSortable mergeSort = new MergeSortable();

        Sortable[] sortableArray = new Sortable[]{bubbleSort, qsort, radixSort, mergeSort};
        for (Sortable sortable : sortableArray) {
            demo(sortable);
        }
        BinarySearch binarySearch = new BinarySearch();
        System.out.println("Position of 5 in sorted array is: " + binarySearch.search(arr, 5));
    }

    private static void demo(Sortable sortable) {
        System.out.println(sortable.getClass().getSimpleName() + ": ");
        System.out.print(Arrays.toString(arr = new int[]{3, 4, 5, 2, 1, 6, 9, 8, 7}));
        sortable.sort(arr);
        System.out.println(" -> " + Arrays.toString(arr));
    }
}
