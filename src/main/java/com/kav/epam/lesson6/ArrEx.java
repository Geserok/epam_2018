package com.kav.epam.lesson6;

import java.util.HashMap;
import java.util.Map;

/**
 * ArrEx
 *
 * @author Andrey Kudarenko
 * @version 1.0
 * @since 1.8
 */
public class ArrEx {
    public static void main(String[] args) {
        char[] arr = new char[]{'b', 'a', 'r', 's', 'i', 'k'};
        char[] arr1 = new char[]{'b', 'a', 'r', 's', 'i', 'k'};
        Map map = new HashMap<>();

        map.put(arr, arr);
        map.put(arr1, arr1);
        System.out.println(arr.hashCode());
        System.out.println(arr1.hashCode());

        System.out.println(map.containsKey(arr));

        System.out.println(map.containsKey(arr1));
    }
}
