package com.kav.epam.lesson3;

/**
 * Animal
 *
 * @author Andrey Kudarenko
 * @version 1.0
 * @since 1.8
 */
public class RussianCat extends Cat {

    public RussianCat(String name, int weight) {
        this.name = name;
        this.weight = weight;
        super.sleep();
        super.setAge(10);
    }

    @Override
    public String toString() {
        return "RussianCat{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }
}
