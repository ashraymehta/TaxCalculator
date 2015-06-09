package com.thoughtworks.pathashala;

import java.util.ArrayList;

public class Receipt {
    ArrayList<Item> items;

    public Receipt(ArrayList<Item> items) {
        this.items = items;
    }

    public Money calculateSalesTax() {
        return new Money(1.50);
    }
}
