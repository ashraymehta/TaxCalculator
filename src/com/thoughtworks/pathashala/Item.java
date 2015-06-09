package com.thoughtworks.pathashala;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class Item {
    private int quantity;
    private Money price;
    private int category;
    private String descriptionString;
    private boolean isImported;

    public Item(int quantity, Money price, int category, String descriptionString, boolean isImported) {
        this.quantity = quantity;
        this.price = price;
        this.category = category;
        this.descriptionString = descriptionString;
        this.isImported = isImported;
    }

    public static Item parse(String itemDetails) {
        ArrayList<String> bookKeywords = new ArrayList<>();
        bookKeywords.add("book");

        ArrayList<String> foodKeywords = new ArrayList<>();
        bookKeywords.add("chocolate");

        ArrayList<String> medicalKeywords = new ArrayList<>();
        bookKeywords.add("headache pills");

        boolean isImported = false;
        if (itemDetails.toLowerCase().contains("imported"))
            isImported = true;

        String[] splitDetails = itemDetails.split(" at ");
        Money price = Money.parse(splitDetails[1]);
        String restOfDetails = splitDetails[0];
        int category = -1;
        if (isStringInList(restOfDetails, bookKeywords)) {
            category = Category.BOOK;
        } else if (isStringInList(restOfDetails, foodKeywords)) {
            category = Category.FOOD;
        } else if (isStringInList(restOfDetails, medicalKeywords)) {
            category = Category.MEDICAL;
        } else
            category = Category.OTHER;

        String[] spaceSplit = restOfDetails.split(" ");
        int quantity = Integer.parseInt(spaceSplit[0]);

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i < spaceSplit.length; i++) {
            stringBuilder.append(spaceSplit[i].trim()).append(" ");
        }
        String descriptionString = stringBuilder.toString().trim();

        return new Item(quantity, price, category, descriptionString, isImported);
    }

    private static boolean isStringInList(String string, List<String> collection) {
        for (String item : collection) {
            if (string.toLowerCase().contains(item.toLowerCase()))
                return true;
        }
        return false;
    }

    public Money getBasicSalesTax() {
        if (category != Category.OTHER)
            return new Money(0.0);
        else
            return price.calculatePercentage(10).roundOff();
    }

    @Override
    public String toString() {
        return quantity + " " + descriptionString + " : " + price;
    }

    public Money getImportTax() {
        if(isImported)
            return price.calculatePercentage(5).roundOff();
        else
            return new Money(0.0);
    }
}

