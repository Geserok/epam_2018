package com.kav.epam.homework5;

public class Main {
    public static void main(String[] args) {
        Changer<Integer> integerChanger = count -> count * count;
        Changer<Double> doubleChanger = count -> count * 2.0d;
        Changer<Long> longChanger = count -> count * count * count;
        Changer<String> stringChanger = String::toUpperCase;

        System.out.println(integerChanger.change(11));
        System.out.println(doubleChanger.change(3.0d));
        System.out.println(longChanger.change(3L));
        System.out.println(stringChanger.change("string"));
    }
}
