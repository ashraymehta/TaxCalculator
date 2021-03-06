package com.thoughtworks.pathashala;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class MoneyTest {
    @Test
    public void shouldBeRepresentedAsProperString() throws Exception {
        Money money = new Money(5.55);

        String actualString = money.toString();
        String expectedString = "5.55";

        assertEquals(expectedString, actualString);
    }

    @Test
    public void shouldRoundOffWhenNothingToRound() throws Exception {
        Money money = new Money(5.55);
        Money roundOff = money.roundOff();
        String actualString = roundOff.toString();
        String expectedString = "5.55";

        assertEquals(expectedString, actualString);
    }

    @Test
    public void shouldRoundOff() throws Exception {
        Money money = new Money(7.625);
        Money roundOff = money.roundOff();

        String actualString = roundOff.toString();
        String expectedString = "7.65";

        assertEquals(expectedString, actualString);
    }

    @Test
    public void shouldParseMoneyValueString() throws Exception {
        Money money = Money.parse("7.90");

        String actualString = money.toString();
        String expectedString = "7.90";

        assertEquals(expectedString, actualString);
    }

    @Test
    public void shouldCalculatePercentage() throws Exception {
        Money money = Money.parse("10.00");
        Money percent = money.calculatePercentage(10);

        String actualString = percent.toString();
        String expectedString = "1.0";

        assertEquals(expectedString, actualString);
    }

    @Test
    public void shouldAddMoney() throws Exception {
        Money money = new Money(9.00);
        Money secondMoney = new Money(1.00);
        Money sum = money.add(secondMoney);

        String actualString = sum.toString();
        String expectedString = "10.0";

        assertEquals(expectedString, actualString);
    }
}