package com.kav.epam.lesson7;

/**
 * Created by zstudent on 05/10/2018.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(new Main().getCount());
    }
    private int getCount(){
        int a = 10;

        try{
            throw new RuntimeException();
        } catch (RuntimeException e){
            return a;
        } finally {
            a = 11;
            return a;
        }
    }
}
