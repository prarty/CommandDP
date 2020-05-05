package com.dth.modal;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ServiceTest {
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    PrintStream originalOutputStream = System.out;
    String serviceName;
    double subscriptionCharge;
    Service service;

    @BeforeEach
    void setOutputStream() {
        System.setOut(new PrintStream(outputStream));
        serviceName = "Learn";
        subscriptionCharge = 100.0;
        service = new Service(serviceName, subscriptionCharge);
    }

    @AfterEach
    void restoreOutputStream() {
        System.setOut(originalOutputStream);
    }

    @Test
    void shouldDisplayServiceDetails() {
        service.displayDetails();

        assertEquals(serviceName + ": " + subscriptionCharge + " Rs.", outputStream.toString().trim());
    }

    @Test
    void shouldReturnTrueWhenChannelNameMatches() {
        assertTrue(service.matchName("Learn"));
    }

    @Test
    void shouldReturnFalseWhenChannelNameDoesNotMatch() {
        assertFalse(service.matchName("Learn56"));
    }

}