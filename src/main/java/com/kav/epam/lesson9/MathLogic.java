package com.kav.epam.lesson9;

/**
 * Created by zstudent on 08/10/2018.
 */
public class MathLogic {

    public boolean isEven(int number) {
        if (number < 0 ){
            throw new IllegalArgumentException("Number should be possitive!");
        }
        return number % 2 == 0;
    }
    public int mult(int num1, int num2){
        return num1 * num2;
    }
}
