package com.kav.epam.homework5;

@FunctionalInterface
public interface Changer<T> {
    T change(T count);
}
