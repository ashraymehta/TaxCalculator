package com.thoughtworks.pathashala;

import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;

public class ReceiptTest {

    @Test
    public void shouldCalculateSalesTaxesForAllItemsForParticularSet() throws Exception {
        ArrayList<Item> items = new ArrayList<>();
        items.add(Item.parse("1 book at 12.49"));
        items.add(Item.parse("1 music CD at 14.99"));
        items.add(Item.parse("1 chocolate bar at 0.85"));
        Receipt receipt = new Receipt(items);
        Money tax = receipt.calculateSalesTax();

        String actualString = tax.toString();
        String expectedString = "1.50";

        assertEquals(expectedString, actualString);
    }

    @Test
    public void shouldCalculateSalesTaxesForAllItemsIncludingImportedItems() throws Exception {
        ArrayList<Item> items = new ArrayList<>();
        items.add(Item.parse("1 imported box of chocolates at 10.00"));
        items.add(Item.parse("1 imported bottle of perfume at 47.50"));
        Receipt receipt = new Receipt(items);
        Money tax = receipt.calculateSalesTax();

        String actualString = tax.toString();
        String expectedString = "7.65";

        assertEquals(expectedString, actualString);
    }
}
