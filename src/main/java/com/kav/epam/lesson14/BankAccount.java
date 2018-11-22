package com.kav.epam.lesson14;

import java.math.BigDecimal;

/**
 * Created by zstudent on 19/11/2018.
 */
public class BankAccount {
    private BigDecimal cashAccount;

    public BankAccount(BigDecimal cashAccount) {
        this.cashAccount = cashAccount;
    }

    private void deposit(BigDecimal cash){
        cashAccount = cashAccount.add(cash);
    }

    private void subs(BigDecimal cash){
        if (cashAccount.compareTo(cash) > 0){
            cashAccount.subtract(cash);
        }
    }

    public BigDecimal getCashAccount() {
        return cashAccount;
    }

    public void setCashAccount(BigDecimal cashAccount) {
        this.cashAccount = cashAccount;
    }
}
