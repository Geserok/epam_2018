package com.kav.epam.algo;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{22, 10 , 1, 17, 123, 401, 0, -10, 1};
        Arrays.sort(arr);
        BinarySearch binarySearch = new BinarySearch();
        System.out.println(Arrays.toString(arr));
        System.out.println(binarySearch.search(arr, 10));

    }
}
