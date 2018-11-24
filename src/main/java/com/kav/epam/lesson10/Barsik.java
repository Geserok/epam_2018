package com.kav.epam.lesson10;

/**
 * Barsik
 *
 * @author Andrey Kudarenko
 * @version 1.0
 * @since 1.8
 */
public class Barsik extends Cat {
    public Barsik(String name, String gender, String description, byte age) {
        super(name, gender, description, age);
    }

    public String talkToSpirits(){
        return "spirits talk with me...";
    }

    @Override
    public void status() {
        System.out.println("I am " + Cat.class.getName());
    }
}
