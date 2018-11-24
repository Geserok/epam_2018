package com.kav.epam.lesson3;

/**
 * Animal
 *
 * @author Andrey Kudarenko
 * @version 1.0
 * @since 1.8
 */
public class Animal {
    String name;
    int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void sleep() {
        System.out.println(this.toString() + " is sleeping");
    }
}
