package com.kav.epam.lesson2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by zstudent on 19/09/2018.
 */
public class EvenOrNot {

    public static void main(String[] args) {

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            EvenOrNot evenOrNot = new EvenOrNot();
            String param = reader.readLine();
          int digit = Integer.parseInt(param);
            System.out.println("Digit " + digit + " is even: " + evenOrNot.isEven(digit));
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    private boolean isEven(int digit){
        return digit % 2 == 0;
    }
}
