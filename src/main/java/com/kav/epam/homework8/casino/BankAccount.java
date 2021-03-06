package com.kav.epam.homework8.casino;

import java.math.BigDecimal;

/**
 * BankAccount
 *
 * @author Andrey Kudarenko
 * @version 1.0
 * @since 1.8
 */
public class BankAccount {
    private BigDecimal cashAccount;

    public BankAccount(BigDecimal cashAccount) {
        this.cashAccount = cashAccount;
    }

    /**
     * Method which deposit money on cash acc
     *
     * @param cash money to deposit
     */
    public void deposit(BigDecimal cash) {
        setCashAccount(cashAccount.add(cash));
    }

    /**
     * Method which subtract money from cash acc
     *
     * @param cash money to subtract
     */
    public void subs(BigDecimal cash) {
        if (cashAccount.compareTo(cash) > 0) {
            setCashAccount(cashAccount.subtract(cash));
        }
    }

    public BigDecimal getCashAccount() {
        return cashAccount;
    }

    public void setCashAccount(BigDecimal cashAccount) {
        this.cashAccount = cashAccount;
    }
}
