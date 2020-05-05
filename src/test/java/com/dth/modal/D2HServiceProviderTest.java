package com.dth.modal;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class D2HServiceProviderTest {
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    PrintStream originalOutputStream = System.out;

    @BeforeEach
    void setOutputStream() {
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void restoreOutputStream() {
        System.setOut(originalOutputStream);
    }

    @Test
    void shouldDisplayAllServiceDetails() {
        D2HServiceProvider d2HServiceProvider = new D2HServiceProvider();

        d2HServiceProvider.displayAllServiceDetails();

        assertEquals(getExpectedDetails(), outputStream.toString().replaceAll("\n", ""));
    }

    @Test
    void shouldCalculateSubscriptionCostGivenPackAndMonth() {
        D2HServiceProvider d2HServiceProvider = new D2HServiceProvider();
        String packName = "Gold";

        double actualCost = d2HServiceProvider.calculateSubscriptionCost(packName, 3);

        assertEquals(actualCost, 270.0);
    }

    private String getExpectedDetails() {
        return "View available packs, channels and servicesAvailable packs " +
                "for subscriptionSilver Pack: [Zee, Sony, Star Plus]: 50.0 Rs." +
                "Gold Pack: [Zee, Sony, Star Plus, Discovery, NatGeo]: 100.0 Rs." +
                "Available channels for subscriptionZee: 10.0 Rs.Sony: 15.0 Rs.Star Plus: 20.0 Rs.Discovery: 10.0 Rs." +
                "NatGeo: 20.0 Rs.Available services for subscriptionLearnEnglish Service: 200.0 Rs." +
                "LearnCooking Service: 100.0 Rs.";
    }

}