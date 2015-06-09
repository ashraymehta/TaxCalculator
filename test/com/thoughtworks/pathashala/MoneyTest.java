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
    public void shouldRoundOffWhen() throws Exception {
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
}