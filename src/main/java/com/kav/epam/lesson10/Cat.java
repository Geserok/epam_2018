package com.kav.epam.lesson10;

/**
 * Cat
 *
 * @author Andrey Kudarenko
 * @version 1.0
 * @since 1.8
 */
public abstract class Cat implements Animal {
    private String name;
    private String gender;
    private String description;

    public Cat() {
    }

    public Cat(String name, String gender, String description, byte age) {

        this.name = name;
        this.gender = gender;
        this.description = description;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    private byte age;
}
