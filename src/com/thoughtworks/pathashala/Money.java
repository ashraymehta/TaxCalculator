package com.thoughtworks.pathashala;

public class Money {

    private double totalPaise;

    public Money(long rupees, long paise) {
        this.totalPaise = rupees * 100 + paise;
    }

    public Money roundOff() {
        return new Money(0, Math.round(totalPaise));
    }

    @Override
    public String toString() {
        return ((int)totalPaise / 100) + "." + (int)(totalPaise % 100);
    }
}
