package com.kav.epam.algo;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{22, 10 , 1, 17, 123, 401, 0, -10, 1};

        Qsort qsort = new Qsort();
        qsort.sort(arr);
        System.out.println(Arrays.toString(arr));

    }
}
