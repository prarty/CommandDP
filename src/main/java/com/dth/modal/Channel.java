package com.dth.modal;

public class Channel {
    private String name;
    private double subscriptionCharge;

    public Channel(String name, double subscriptionCharge) {
        this.name = name;
        this.subscriptionCharge = subscriptionCharge;
    }

    public void displayDetails() {
        System.out.println(this.name + ": " + subscriptionCharge + " Rs.");
    }

    public boolean matchName(String channelName) {
        return name.replaceAll(" ", "").equalsIgnoreCase(channelName.replaceAll(" ", ""));
    }

    public double channelCharge() {
        return this.subscriptionCharge;
    }

    public void displayName() {
        System.out.print(name);
    }
}
