package com.kav.epam.lesson7;

import java.util.List;

/**
 * Cat
 *
 * @author Andrey Kudarenko
 * @version 1.0
 * @since 1.8
 */
public final class Cat {
    private final int age;
    private final List<String> names;

    public Cat(int age, List<String> names) {
        this.age = age;
        this.names = names;

    }

    public int getAge() {
        return age;
    }

    public String getNames(int[] num) {
        StringBuilder result = new StringBuilder();
        for (int number : num) {
            result.append(" ").append(names.get(number));
        }
        return result.toString();
    }
}
