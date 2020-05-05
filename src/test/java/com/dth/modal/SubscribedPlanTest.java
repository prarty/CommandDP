package com.dth.modal;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SubscribedPlanTest {
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
    void shouldAddChannelInSubscribedPlan() {
        SubscribedPlan subscribedPlan = new SubscribedPlan();

        Channel channel = new Channel("Sony", 100);
        subscribedPlan.addChannel(channel);

        assertEquals(100, subscribedPlan.subscriptionAmount());
    }

    @Test
    void shouldAddSpecialServiceInSubscribedPlan() {
        SubscribedPlan subscribedPlan = new SubscribedPlan();

        Service service = new Service("Learn", 50);
        subscribedPlan.addSpecialService(service);

        assertEquals(50, subscribedPlan.subscriptionAmount());
    }

}