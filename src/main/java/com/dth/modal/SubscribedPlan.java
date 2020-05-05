package com.dth.modal;

import java.util.ArrayList;
import java.util.List;

public class SubscribedPlan {
    ChannelPack subscribedPack;
    int monthOfSubscription;
    //Assuming channels are subscribed only for a month
    List<Channel> subscribedChannels;
    double subscriptionAmount;
    List<Service> subscribedService;

    public SubscribedPlan() {
        this.subscribedPack = null;
        this.monthOfSubscription = 0;
        this.subscriptionAmount = 0;
        this.subscribedChannels = new ArrayList<>();
        this.subscribedService = new ArrayList<>();
    }

    public static SubscribedPlan emptyPlan() {
        return new SubscribedPlan();
    }

    public void displayDetails() {
        System.out.print("You have successfully subscribed the following packs - ");
        subscribedPack.packName();
        subscribedPack.monthlyPrice();
        System.out.println("No of months: " + monthOfSubscription);
        if (monthOfSubscription >= 3) {
            subscribedPack.displayDiscountForMonths(monthOfSubscription);
        }
        System.out.println("Final Price after discount: " + subscriptionAmount);
    }

    public double subscriptionAmount() {
        return this.subscriptionAmount;
    }

    public void addChannel(Channel channel) {
        subscribedChannels.add(channel);
        this.subscriptionAmount += channel.channelCharge();
    }

    public void addSpecialService(Service specialService) {
        subscribedService.add(specialService);
        this.subscriptionAmount += specialService.serviceCharge();
    }

    public void subscriptionDetails() {
        System.out.print("Currently subscribed packs and channels: ");
        subscribedPack.displayName();
        subscribedChannels.forEach(channel -> {
            System.out.print(" + ");
            channel.displayName();
        });
        System.out.println();
        System.out.print("Currently subscribed services: ");
        subscribedService.forEach(Service::displayName);
    }

    public SubscribedPlan updatePlan(ChannelPack packToSubscribe, int noOfMonths) {
        this.subscribedPack = packToSubscribe;
        this.monthOfSubscription = noOfMonths;
        this.subscriptionAmount = subscribedPack.calculateSubscriptionForMonths(noOfMonths);
        return this;
    }

}
