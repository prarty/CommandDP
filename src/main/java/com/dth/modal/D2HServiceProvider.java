package com.dth.modal;


import java.util.ArrayList;

import static java.util.Arrays.asList;

public class D2HServiceProvider {
    private ArrayList<Channel> availableChannels = new ArrayList<>();
    private ArrayList<Service> availableServices = new ArrayList<>();
    private ArrayList<ChannelPack> availablePacks = new ArrayList<>();

    public D2HServiceProvider() {
        this.availablePacks.addAll(packs());
        this.availableChannels.addAll(channels());
        this.availableServices.addAll(services());
    }

    public void displayAllServiceDetails() {
        System.out.println("View available packs, channels and services");
        System.out.println("Available packs for subscription");
        this.availablePacks.forEach(ChannelPack::displayDetails);
        System.out.println("Available channels for subscription");
        this.availableChannels.forEach(Channel::displayDetails);
        System.out.println("Available services for subscription");
        this.availableServices.forEach(Service::displayDetails);

    }

    private java.util.List<Service> services() {
        return asList(
                new Service("LearnEnglish Service", 200),
                new Service("LearnCooking Service", 100)
        );

    }


    private java.util.List<ChannelPack> packs() {
        ChannelPack silverPack = new ChannelPack("Silver Pack",
                asList("Zee", "Sony", "Star Plus"),
                50);
        ChannelPack goldPack = new ChannelPack("Gold Pack",
                asList("Zee", "Sony", "Star Plus", "Discovery", "NatGeo"),
                100);
        return asList(silverPack, goldPack);
    }

    private java.util.List<Channel> channels() {
        return asList(
                new Channel("Zee", 10),
                new Channel("Sony", 15),
                new Channel("Star Plus", 20),
                new Channel("Discovery", 10),
                new Channel("NatGeo", 20)
        );
    }

    public double calculateSubscriptionCost(String pack, int noOfMonths) {
        ChannelPack packToSubscribe = availablePacks.stream().filter(singlePack -> singlePack.matchName(pack)).findFirst().get();
        return packToSubscribe.calculateSubscriptionForMonths(noOfMonths);
    }

    public ChannelPack getPack(String pack) {
        return availablePacks.stream().filter(singlePack -> singlePack.matchName(pack)).findFirst().get();
    }

    public Channel getChannel(String channelName) {
        return availableChannels.stream().filter(channel -> channel.matchName(channelName)).findFirst().get();
    }

    public Service getSpecialServiceFor(String serviceName) {
        return availableServices.stream().filter(service -> service.matchName(serviceName)).findFirst().get();
    }
}
