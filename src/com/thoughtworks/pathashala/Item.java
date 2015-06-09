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

    public Item(int quantity, Money price, int category, String descriptionString) {
        this.quantity = quantity;
        this.price = price;
        this.category = category;
        this.descriptionString = descriptionString;
    }

    public static Item parse(String itemDetails) {
        ArrayList<String> bookKeywords = new ArrayList<>();
        bookKeywords.add("book");

        ArrayList<String> foodKeywords = new ArrayList<>();
        bookKeywords.add("chocolates");

        ArrayList<String> medicalKeywords = new ArrayList<>();
        bookKeywords.add("headache pills");

        String[] splitDetails = itemDetails.split("at");
        Money price = Money.parse(splitDetails[1]);
        String restOfDetails = splitDetails[0];
        int category = -1;
        if(isStringInList(restOfDetails, bookKeywords)) {
            category = Category.BOOK;
        }
        else if(isStringInList(restOfDetails, foodKeywords)) {
            category = Category.FOOD;
        }
        else if(isStringInList(restOfDetails, medicalKeywords)) {
            category = Category.MEDICAL;
        }
        else
            category = Category.OTHER;

        String[] spaceSplit = restOfDetails.split(" ");
        int quantity = Integer.parseInt(spaceSplit[0]);

        StringBuilder stringBuilder = new StringBuilder();
        for(int i=1; i<spaceSplit.length; i++) {
            stringBuilder.append(spaceSplit[i]).append(" ");
        }
        String descriptionString = stringBuilder.toString();

        return new Item(quantity, price, category, descriptionString);
    }

    private static boolean isStringInList(String string, List<String> collection) {
        for(String item : collection) {
            if(item.toLowerCase().contains(string.toLowerCase()))
                return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return quantity + " " + descriptionString + " at " + price;
    }
}

