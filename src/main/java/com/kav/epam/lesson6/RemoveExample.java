package com.kav.epam.lesson6;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * RemoveExample
 *
 * @author Andrey Kudarenko
 * @version 1.0
 * @since 1.8
 */
public class RemoveExample {
    public static void main(String[] args) {
        String[] arr = new String[]{"cat", "cat1"};
        List<String> stringList = new LinkedList<>();
        stringList.add("Barsik");
        stringList.add("Murzik");
        stringList.add("Barsik");
        stringList.add("Barsik");
        System.out.println(stringList);

        stringList.addAll(Arrays.asList(arr));

        stringList.removeIf(name -> name.equals("Barsik"));
        System.out.println(stringList);
    }


}
