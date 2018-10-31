package com.kav.epam.lesson12.strategy;

/**
 * Created by zstudent on 15/10/2018.
 */
public class SwimWithBoat implements SwimBehavior{


    @Override
    public void swimable() {
        System.out.println("I am swimming on the boat");
    }
}
