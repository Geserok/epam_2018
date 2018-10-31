package com.kav.epam.lesson3;

/**
 * Created by zstudent on 21/09/2018.
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
