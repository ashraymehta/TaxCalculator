package com.thoughtworks.pathashala;

import org.junit.Test;

import static org.junit.Assert.*;

public class ItemTest {
    @Test
    public void shouldBeRepresentedAsProperString() throws Exception {
        Item item = new Item(1, new Money(5.50), Category.BOOK, "book");

        String actualString = item.toString();
        String expectedString = "1 book at 5.50";

        assertEquals(actualString, expectedString);
    }
}