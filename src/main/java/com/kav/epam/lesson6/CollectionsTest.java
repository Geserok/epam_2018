package com.kav.epam.lesson6;


import java.util.HashSet;
import java.util.Set;

/**
 * CollectionsTest
 *
 * @author Andrey Kudarenko
 * @version 1.0
 * @since 1.8
 */
public class CollectionsTest {
    public static void main(String[] args) {
        Set<Cat> cats = new HashSet<>();
        Cat barsik = new Cat("Barsik");
        Cat murzik = new Cat("Murzik");
        Cat riska = new Cat("Riska");

        cats.add(barsik);
        cats.add(murzik);
        cats.add(riska);

        System.out.println(barsik.hashCode());
        System.out.println(cats.contains(barsik));

        barsik.setName("barsik");
        System.out.println(barsik.hashCode());

        System.out.println(cats.contains(barsik));

        cats.add(barsik);

        System.out.println(cats.contains(barsik));

        for (Cat cat : cats) {
            System.out.println(cat);
        }

        Set<Cat> catSet = new HashSet<>();
        catSet.addAll(cats);
        System.out.println(catSet);
    }
}
