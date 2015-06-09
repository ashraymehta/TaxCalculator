package com.thoughtworks.pathashala;

import java.util.ArrayList;

public class Receipt {
    ArrayList<Item> items;

    public Receipt(ArrayList<Item> items) {
        this.items = items;
    }

    public Money calculateSalesTax() {
        Money sum = new Money(0.0);
        for (Item item : items) {
            sum = sum.add(item.getImportTax());
            sum = sum.add(item.getBasicSalesTax());
        }
        return sum;
    }
}
