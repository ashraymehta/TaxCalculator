package com.thoughtworks.pathashala;

import org.junit.Test;

import static org.junit.Assert.*;

public class ItemTest {
    @Test
    public void shouldBeRepresentedAsProperString() throws Exception {
        Item item = new Item(1, new Money(5.50), Category.BOOK, "book", false);

        String actualString = item.toString();
        String expectedString = "1 book : 5.50";

        assertEquals(expectedString, actualString);
    }

    @Test
    public void shouldParseStringToCreateItself() throws Exception {
        String parsedString = "1 book at 12.49";
        Item createdItem = Item.parse(parsedString);

        String actualString = createdItem.toString();
        String expectedString = "1 book : 12.49";

        assertEquals(expectedString, actualString);
    }

    @Test
    public void shouldCalculateBasicSalesTax() throws Exception {
        String parsedString = "1 bottle of perfume at 18.99";
        Item createdItem = Item.parse(parsedString);

        Money basicTax = createdItem.getBasicSalesTax();

        String actualString = basicTax.toString();
        String expectedString = "1.90";

        assertEquals(expectedString, actualString);
    }
}