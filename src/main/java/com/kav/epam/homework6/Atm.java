package com.kav.epam.homework6;

import java.math.BigDecimal;

/**
 * ATM for working with payment system
 *
 * @author Andrey Kudarenko
 * @version 1.0
 * @since 1.8
 */
public class Atm implements Runnable {
    private int id;
    private int quantityOfOperations;

    public Atm(int id, int quantityOfOperations) {

        if (id < 0 || quantityOfOperations < 0) {
            throw new IllegalArgumentException("Wrong! id and quantityOfOperations must be greater than 0");
        }
        this.id = id;
        this.quantityOfOperations = quantityOfOperations;
    }

    /**
     * Gets a instance of PaymentSystem and quantity of operations
     * try to add or subtract money to/from cashAccount.
     * Type of operation is random.
     * Each loop has sleep 100 mills.
     */
    @Override
    public void run() {
        PaymentSystem paymentSystem = PaymentSystem.getInstance();

        for (int i = 0; i < quantityOfOperations; i++) {
            BigDecimal money = randomBigDecimal(BigDecimal.ONE, BigDecimal.valueOf(1000l));
            synchronized (PaymentSystem.class) {
                if (getTypeOfOperation()) {
                    try {
                        paymentSystem.subtractMoney(money);
                        System.out.println("Client take " + money + " from ATM№ " + id
                                + ". Cash account deposit is " + paymentSystem.getCashAccount());
                    } catch (IllegalArgumentException e) {
                        System.err.println(e.getMessage() + "Atm №" + id + " can't put cash " + money +
                                " to client. Cash account deposit is " + paymentSystem.getCashAccount());
                    }
                } else if (getTypeOfOperation() == false) {
                    paymentSystem.addMoney(money);
                    System.out.println("Client put " + money + " on cash account by Atm №" + id +
                            ". Cash account deposit is " + paymentSystem.getCashAccount());
                }
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Method which return random BigDecimal from min to max;
     *
     * @param min low bound of range
     * @param max high bound of range
     * @return BigDecimal from min to max range
     */
    private BigDecimal randomBigDecimal(BigDecimal min, BigDecimal max) {
        if (min.compareTo(max) > 0) {
            throw new IllegalArgumentException("Wrong arguments! min must be greater than max");
        }
        BigDecimal money = min.add(new BigDecimal(Math.random()).multiply(max.subtract(min)));
        return money.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * Method which return random Boolean;
     *
     * @return Boolean
     */
    private boolean getTypeOfOperation() {
        return Math.random() >= 0.5;
    }
}
