package com.dth.modal;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ChannelPackTest {
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    PrintStream originalOutputStream = System.out;
    String packName;
    List<String> channels;
    double monthlyPrice;
    ChannelPack channelPack;

    @BeforeEach
    void setOutputStream() {
        System.setOut(new PrintStream(outputStream));
        packName = "Gold";
        channels = Arrays.asList("Sony", "Sub");
        monthlyPrice = 200;
        channelPack = new ChannelPack(packName, channels, monthlyPrice);
    }

    @AfterEach
    void restoreOutputStream() {
        System.setOut(originalOutputStream);
    }

    @Test
    void shouldReturnSubscriptionFor3Months() {
        assertEquals(540, channelPack.calculateSubscriptionForMonths(3));
    }

    @Test
    void shouldDisplayDiscountFor3Months() {
        channelPack.displayDiscountForMonths(3);

        assertEquals("Discount applied: 60.0", outputStream.toString().trim());
    }

    @Test
    void shouldDisplayPackDetails() {
        channelPack.displayDetails();

        assertEquals(packName + ": " + channels + ": " + monthlyPrice + " Rs.", outputStream.toString().trim());
    }
}