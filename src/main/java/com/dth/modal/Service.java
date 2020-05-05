package com.dth.modal;

public class Service {
    String name;
    double subscriptionCharge;

    public Service(String name, double subscriptionCharge) {
        this.name = name;
        this.subscriptionCharge = subscriptionCharge;
    }

    public void displayDetails() {
        System.out.println(name + ": " + subscriptionCharge + " Rs.");
    }

    public boolean matchName(String serviceName) {
        return name.toLowerCase().contains(serviceName.toLowerCase());
    }

    public double serviceCharge() {
        return subscriptionCharge;
    }

    public void displayName() {
        System.out.println(name);
    }
}
