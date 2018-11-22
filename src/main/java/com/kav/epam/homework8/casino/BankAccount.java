package com.kav.epam.homework8.casino;

import java.math.BigDecimal;

/**
 * Created by zstudent on 19/11/2018.
 */
public class BankAccount {
    private BigDecimal cashAccount;

    public BankAccount(BigDecimal cashAccount) {
        this.cashAccount = cashAccount;
    }

    public void deposit(BigDecimal cash){
        setCashAccount(cashAccount.add(cash));
    }

    public void subs(BigDecimal cash){
        if (cashAccount.compareTo(cash) > 0){
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
