package com.kav.epam.homework1;

import java.util.Scanner;

/**
 * @author Andrey Kudarenko
 * @version 1.0
 * @since 1.8
 */
public class TrafficLight {
    private final static int RED = 2;
    private final static int YELLOW = 3;
    private final static int GREEN = 5;

    /**
     * Prints a color which is on in certain minute
     */
    public static void getColor() {
        System.out.println("Please insert number of minute: ");
        int minute = TrafficLight.scanMinute();
        if (minute <= RED) {
            System.out.println("red");
        } else if (minute <= YELLOW + RED) {
            System.out.println("yellow");
        } else {
            System.out.println("green");
        }
    }

    /**
     * Count a durability of traffic light cycle
     */
    private static int countCycleTime() {
        return RED + YELLOW + GREEN;
    }

    /**
     * Scan inputs String
     * Check it for truly format
     */
    private static int scanMinute() {
        int minute;
        try {
            int cycleTime = TrafficLight.countCycleTime();
            Scanner in = new Scanner(System.in);
            minute = Integer.parseInt(in.next());
            if (minute >= 0 && minute <= cycleTime) {
                return minute;
            } else if (minute > cycleTime) {
                minute %= cycleTime;
                return minute;
            } else if (minute < 0) {
                throw new NumberFormatException("Number of minute should be greater than zero.");
            }
        } catch (NumberFormatException e) {
            System.err.println("Wrong number, " + e + "\n" + "Please insert number of minute: ");
            minute = TrafficLight.scanMinute();
        }
        return minute;
    }
}
