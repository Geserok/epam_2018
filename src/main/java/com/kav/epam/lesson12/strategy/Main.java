package com.kav.epam.lesson12.strategy;

/**
 * Main
 *
 * @author Andrey Kudarenko
 * @version 1.0
 * @since 1.8
 */
public class Main {
    public static void main(String[] args) {
        Duck redHeadDuck = new RedHeadDuck();
        redHeadDuck.display();
        redHeadDuck.performFly();
        redHeadDuck.performSwim();

        Duck rubberDuck = new RubberDuck();
        rubberDuck.display();
        rubberDuck.performFly();
        rubberDuck.performSwim();
    }

}
