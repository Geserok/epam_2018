package com.kav.epam.lesson12.strategy;

/**
 * Created by zstudent on 15/10/2018.
 */
public class Main {
    public static void main(String[] args) {
        Duck redHeadDuck = new RedHatDuck();
        redHeadDuck.display();
        redHeadDuck.performFly();
        redHeadDuck.perfomSwim();
        Duck rubberDuck = new RubberDuck();
        rubberDuck.display();
        rubberDuck.performFly();
        rubberDuck.perfomSwim();
    }

}
