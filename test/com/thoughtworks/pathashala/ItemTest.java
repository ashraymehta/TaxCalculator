package com.thoughtworks.pathashala;

import org.junit.Test;

import static org.junit.Assert.*;

public class ItemTest {
    @Test
    public void shouldBeRepresentedAsProperString() throws Exception {
        Item item = new Item(1, new Money(5.50), Category.BOOK, "book");

        String actualString = item.toString();
        String expectedString = "1 book : 5.50";

        assertEquals(actualString, expectedString);
    }

    @Test
    public void shouldParseStringToCreateItself() throws Exception {
        String parsedString = "1 book at 12.49";
        Item createdItem = Item.parse(parsedString);

        String actualString = createdItem.toString();
        String expectedString = "1 book : 12.49";

        assertEquals(actualString, expectedString);
    }
}