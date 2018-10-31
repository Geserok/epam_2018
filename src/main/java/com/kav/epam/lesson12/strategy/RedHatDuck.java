package com.kav.epam.lesson12.strategy;

/**
 * Created by zstudent on 15/10/2018.
 */
public class RedHatDuck extends Duck {
    public RedHatDuck() {
        flyBehavior = new FlyWithWings();
        swimBehavior = new Swim();

    }

    @Override
    public void display() {
        System.out.println("I am redhat duck");
    }
}
