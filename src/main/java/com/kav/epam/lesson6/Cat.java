package com.kav.epam.lesson6;

/**
 * Cat
 *
 * @author Andrey Kudarenko
 * @version 1.0
 * @since 1.8
 */
public class Cat {
    private String name;

    public Cat(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cat cat = (Cat) o;

        return name != null ? name.equals(cat.name) : cat.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override

    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                '}';
    }
}
