package com.kav.epam.lesson5;

/**
 * @author Andrey Kudarenko
 * @version 1.0
 * @since 1.8
 */
public class ArraysTest {
    public static void main(String[] args) {
        
        int[] array = new int[0];
        System.out.println(new ArraysTest().getMaxFromArray(array));

    }

    private int getMaxFromArray(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array is null or is empty.");
        }
        int max = array[0];
        if (array.length == 1) {
            return array[0];
        } else if (array.length > 1) {

            for (int i = 1; i < array.length; i++) {
                if (max < array[i]) {
                    max = array[i];
                }
            }
        }
        return max;
    }
}
