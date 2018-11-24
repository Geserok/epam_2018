package com.kav.epam.homework4;

/**
 * @author Andrey Kudarenko
 * @version 1.0
 * @since 1.8
 */
public class Start {
    /**
     * Method which startPreparation program to solve 10.41-10.43 from Zlotopolsky
     */
    public void init() {
        RecursionTaskFirst recursionTaskFirst = new RecursionTaskFirst();
        System.out.println("Result of 10.41 task from Zlotopolsky: ");
        System.out.println(recursionTaskFirst.getFactorial(5));

        System.out.println("Result of 10.42 task from Zlotopolsky: ");
        RecursionTaskSecond recursionTaskSecond = new RecursionTaskSecond();
        System.out.println(recursionTaskSecond.getPoweredNumber(3, 3));
        System.out.println(recursionTaskSecond.getPoweredNumber(2, -3));
        System.out.println(recursionTaskSecond.getPoweredNumber(-2, 2));
        System.out.println(recursionTaskSecond.getPoweredNumber(-2, 3));
        System.out.println(recursionTaskSecond.getPoweredNumber(0, 3));

        System.out.println("Result of 10.43 task from Zlotopolsky: ");
        RecursionTaskThird recursionTaskThird = new RecursionTaskThird();
        System.out.println(recursionTaskThird.sumOfCountNumber(123));
        System.out.println(recursionTaskThird.quantityOfCount(123));

    }
}
