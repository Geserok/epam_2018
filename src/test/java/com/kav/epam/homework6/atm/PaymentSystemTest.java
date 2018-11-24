package com.kav.epam.homework6.atm;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class PaymentSystemTest {
    PaymentSystem paymentSystem;

    @Before
    public void init() {
        paymentSystem = PaymentSystem.getInstance();
    }

    @Test
    public void testGetInstance1() {
        Assert.assertNotNull(paymentSystem);
    }

    @Test
    public void testGetInstance2() {
        PaymentSystem paymentSystemNew = PaymentSystem.getInstance();
        Assert.assertEquals(paymentSystem, paymentSystemNew);
    }

    @Test
    public void testAddMoney() {
        BigDecimal cashAccountTest = paymentSystem.getCashAccount();
        paymentSystem.addMoney(BigDecimal.valueOf(100));
        Assert.assertEquals(paymentSystem.getCashAccount(), cashAccountTest.add(BigDecimal.valueOf(100)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddMoneyException() {
        paymentSystem.addMoney(BigDecimal.valueOf(-10));
    }

    @Test
    public void testSubtractMoney() {
        BigDecimal cashAccountTest = paymentSystem.getCashAccount();
        paymentSystem.subtractMoney(BigDecimal.valueOf(100));
        Assert.assertEquals(paymentSystem.getCashAccount(), cashAccountTest.subtract(BigDecimal.valueOf(100)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSubtractMoneyException() {
        paymentSystem.addMoney(BigDecimal.valueOf(-10));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSubtractMoneyException2() {
        paymentSystem.subtractMoney(BigDecimal.valueOf(100000));
    }
}
