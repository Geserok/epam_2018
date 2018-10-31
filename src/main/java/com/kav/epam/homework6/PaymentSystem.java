package com.kav.epam.homework6;

import java.math.BigDecimal;

/**
 * Singleton payment system with volatile cashAccount
 *
 * @author Andrey Kudarenko
 * @version 1.0
 * @since 1.8
 */
public class PaymentSystem {
    private volatile BigDecimal cashAccount;

    private static volatile PaymentSystem instance;

    /**
     * Method which return instance of singleton
     *
     * @return Singleton instance
     */
    public static PaymentSystem getInstance() {
        PaymentSystem localInstance = instance;
        if (localInstance == null) {
            synchronized (PaymentSystem.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new PaymentSystem();
                }
            }
        }
        return localInstance;
    }

    /**
     * Constructor for default payment system with 1000 on cashAccount
     */
    private PaymentSystem() {
        this.cashAccount = BigDecimal.valueOf(1000L);
    }

    /**
     * Synchronized method which add money on the cashAccount
     *
     * @param money amount of cash to add on cashAccount
     * @return new cashAccount
     */
    public synchronized BigDecimal addMoney(BigDecimal money) {
        checkMoney(money);
        cashAccount = cashAccount.add(money);
        return cashAccount;
    }

    /**
     * Synchronized method which subtract money on the cashAccount
     *
     * @param money amount of cash to subtract on cashAccount
     * @return new cashAccount
     */
    public synchronized BigDecimal subtractMoney(BigDecimal money) {
        checkMoney(money);
        if (cashAccount.compareTo(money) >= 0) {
            cashAccount = cashAccount.subtract(money);
        } else if (cashAccount.compareTo(money) < 0) {
            throw new IllegalArgumentException("Wrong! There is not enough money on your account! ");
        }
        return cashAccount;
    }

    /**
     * Method which check money for true format
     *
     * @param money must be greater than 0
     * @throws IllegalArgumentException if param{@money} less or equals zero
     */
    private void checkMoney(BigDecimal money) {
        if (money.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Wrong argument! Money should be greater than zero! ");
        }
    }

    /**
     * getter for cashAccount
     *
     * @return cashAccount
     */
    public BigDecimal getCashAccount() {
        return cashAccount;
    }
}
