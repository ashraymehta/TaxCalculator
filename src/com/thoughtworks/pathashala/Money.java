package com.thoughtworks.pathashala;

import java.awt.event.MouseEvent;

public class Money {

    private double totalPaise;

    public Money(double value) {
        this.totalPaise = value * 100;
    }

    public Money roundOff() {
        int integralPart = (int) totalPaise / 100;
        double decimalPart = totalPaise % 100;
        double decimalFraction = decimalPart % 1;
        if(decimalFraction >= .5) {
            decimalPart += 5 - decimalPart % 5;
        }
        else {
            decimalPart -= decimalPart % 5;
        }
        double totalNewValue = Double.parseDouble(integralPart + "." + (int)decimalPart);
        return new Money(totalNewValue);
    }

    @Override
    public String toString() {
        return (int)(totalPaise / 100) + "." + (int)(totalPaise % 100);
    }

    public static Money parse(String splitDetail) {
        splitDetail = splitDetail.trim();
        double value = Double.parseDouble(splitDetail);
        return new Money(value);
    }

    public Money calculatePercentage(int percent) {
        return new Money((totalPaise * percent / 100) / 100);
    }

    public Money add(Money secondMoney) {
        return new Money((totalPaise + secondMoney.totalPaise) / 100);
    }
}
