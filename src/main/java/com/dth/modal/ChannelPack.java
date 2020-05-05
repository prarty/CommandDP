package com.dth.modal;


import java.util.List;

public class ChannelPack {
    private String packName;
    private List<String> channels;
    private double monthlyPrice;

    public ChannelPack(String packName, List<String> channels, double monthlyPrice) {
        this.packName = packName;
        this.channels = channels;
        this.monthlyPrice = monthlyPrice;
    }

    public void displayDetails() {
        System.out.println(packName + ": " + channels + ": " + monthlyPrice + " Rs.");
    }

    public boolean matchName(String packName) {
        return this.packName.toLowerCase().charAt(0) == packName.toLowerCase().charAt(0);
    }

    public double calculateSubscriptionForMonths(int noOfMonths) {
        double totalAmount = monthlyPrice * noOfMonths;
        if (noOfMonths >= 3) {
            totalAmount -= (.10 * totalAmount);
        }
        return totalAmount;
    }

    public void packName() {
        System.out.println(packName);
    }

    public void monthlyPrice() {
        System.out.println("Monthly price: " + monthlyPrice);
    }

    public void displayDiscountForMonths(int monthOfSubscription) {
        double discount = monthlyPrice * .10 * monthOfSubscription;
        System.out.println("Discount applied: " + discount);
    }

    public void displayName() {
        System.out.print(packName);
    }
}
