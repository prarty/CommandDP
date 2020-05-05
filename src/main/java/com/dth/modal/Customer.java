package com.dth.modal;

import java.util.List;

public class Customer {
    double balance;
    SubscribedPlan subscribedPlan;
    D2HServiceProvider d2HServiceProvider;
    private String email;
    private String phoneNumber;

    public Customer(double balance, D2HServiceProvider d2HServiceProvider) {
        this.balance = balance;
        this.d2HServiceProvider = d2HServiceProvider;
        this.email = "";
        this.phoneNumber = "";
        this.subscribedPlan = SubscribedPlan.emptyPlan();
    }

    public void displayBalance() {
        System.out.println("Current balance is " + balance + " Rs.");
    }

    public void rechargeAccount(int amount) {
        this.balance += amount;
        System.out.print("Recharge completed successfully. ");
        displayBalance();
    }

    public void subscribePack(String pack, int noOfMonths) {
        double charge = d2HServiceProvider.calculateSubscriptionCost(pack, noOfMonths);
        if (charge > this.balance) {
            System.out.println("InSufficient Balance");
            return;
        }
        ChannelPack packToSubscribe = d2HServiceProvider.getPack(pack);
        subscribedPlan = subscribedPlan.updatePlan(packToSubscribe, noOfMonths);
        subscribedPlan.displayDetails();
        this.balance -= subscribedPlan.subscriptionAmount();
        System.out.println("Account balance: " + this.balance);
        System.out.println("Email notification sent successfully");
        System.out.println("SMS notification sent successfully");
    }

    public void addChannel(List<String> channelNames) {
        channelNames.forEach(channelName -> {
            Channel channel = d2HServiceProvider.getChannel(channelName);
            subscribedPlan.addChannel(channel);
            this.balance -= channel.channelCharge();
        });
        System.out.println("Channels added successfully.");
        System.out.println("Account balance: " + this.balance + " Rs.");
    }

    public void subscribeService(String serviceName) {
        Service specialService = d2HServiceProvider.getSpecialServiceFor(serviceName);
        subscribedPlan.addSpecialService(specialService);
        this.balance -= specialService.serviceCharge();
        System.out.println("Service subscribed successfully");
        System.out.println("Account balance: " + this.balance + " Rs.");
        System.out.println("Email notification sent successfully");
        System.out.println("SMS notification sent successfully");
    }

    public void displaySubscriptionDetails() {
        subscribedPlan.subscriptionDetails();
    }

    public void updateEmailAndPhoneNumber(String email, String phoneNumber) {
        this.email = email;
        this.phoneNumber = phoneNumber;
        System.out.println("Email and Phone updated successfully");
    }
}
