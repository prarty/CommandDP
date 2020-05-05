package com.dth.modal;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ChannelTest {
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    PrintStream originalOutputStream = System.out;
    String channelName;
    double subscriptionCharge;
    Channel channel;

    @BeforeEach
    void setOutputStream() {
        System.setOut(new PrintStream(outputStream));
        channelName = "Sony";
        subscriptionCharge = 10.0;
        channel = new Channel(channelName, subscriptionCharge);
    }

    @AfterEach
    void restoreOutputStream() {
        System.setOut(originalOutputStream);
    }

    @Test
    void shouldDisplayChannelDetails() {
        channel.displayDetails();

        assertEquals(channelName + ": " + subscriptionCharge + " Rs.", outputStream.toString().trim());
    }

    @Test
    void shouldReturnTrueWhenChannelNameMatches() {
        assertTrue(channel.matchName("sony"));
    }

    @Test
    void shouldReturnFalseWhenChannelNameDontMatch() {
        assertFalse(channel.matchName("SubTv"));
    }

    @Test
    void shouldReturnChannelCharge() {
        assertEquals(subscriptionCharge, channel.channelCharge());
    }

    @Test
    void shouldDisplayChannelName() {
        channel.displayName();

        assertEquals(channelName, outputStream.toString().trim());
    }
}