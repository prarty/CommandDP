package com.dth.modal;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class CustomerTest {
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    PrintStream originalOutputStream = System.out;
    Customer customer;
    double balance;
    D2HServiceProvider d2HServiceProvider;

    @BeforeEach
    void setOutputStream() {
        System.setOut(new PrintStream(outputStream));
        balance = 100.0;
        d2HServiceProvider = mock(D2HServiceProvider.class);
        customer = new Customer(balance, d2HServiceProvider);
    }

    @AfterEach
    void restoreOutputStream() {
        System.setOut(originalOutputStream);
    }

    @Test
    void shouldDisplayBalanceForTheCustomer() {
        customer.displayBalance();

        assertEquals(getExpectedBalanceMessage(balance), getActualOutputStream());
    }

    @Test
    void shouldRechargeAccountWithAmount500() {
        int amount = 500;
        customer.rechargeAccount(amount);

        assertEquals("Recharge completed successfully. " + getExpectedBalanceMessage((balance + amount)), getActualOutputStream());
    }

    @Test
    void shouldSubscribeGoldPack() {
        String pack = "gold";
        int noOfMonths = 3;
        ChannelPack mockPack = mock(ChannelPack.class);
        when(d2HServiceProvider.calculateSubscriptionCost(pack, noOfMonths)).thenReturn((double) 27);
        when(d2HServiceProvider.getPack(pack)).thenReturn(mockPack);
        customer.subscribePack(pack, noOfMonths);

        assertEquals(expectedMessageForPackSubscription(), outputStream.toString().trim());
    }

    @Test
    void shouldAddChannelInThePack() {
        String channel = "Discovery";
        Channel mockChannel = mock(Channel.class);
        when(d2HServiceProvider.getChannel(channel)).thenReturn(mockChannel);
        List<String> channelList = Arrays.asList(channel);
        doNothing().when(mock(SubscribedPlan.class)).addChannel(mockChannel);
        double subscriptionCharge = 20;
        when(mockChannel.channelCharge()).thenReturn(subscriptionCharge);

        customer.addChannel(channelList);

        assertEquals(expectedMessageForAddChannel(), outputStream.toString().trim());
    }

    @Test
    void shouldSubscribeLearnEnglishService() {
        String serviceName = "LearnEnglish";
        Service mockService = mock(Service.class);
        when(d2HServiceProvider.getSpecialServiceFor(serviceName)).thenReturn(mockService);
        when(mockService.serviceCharge()).thenReturn((double) 50);
        customer.subscribeService(serviceName);

        assertEquals(expectedMessageToSubscribeService(), outputStream.toString().trim());
    }

    private String expectedMessageToSubscribeService() {
        return "Service subscribed successfully\n" +
                "Account balance: 50.0 Rs.\n" +
                "Email notification sent successfully\n" +
                "SMS notification sent successfully";
    }


    private String expectedMessageForAddChannel() {
        return "Channels added successfully.\n" +
                "Account balance: 80.0 Rs.";
    }

    private String expectedMessageForPackSubscription() {
        return "You have successfully subscribed the following packs - No of months: 3\n" +
                "Final Price after discount: 0.0\n" +
                "Account balance: 100.0\n" +
                "Email notification sent successfully\n" +
                "SMS notification sent successfully";
    }

    private String getActualOutputStream() {
        return outputStream.toString().trim();
    }

    private String getExpectedBalanceMessage(double balanceToDisplay) {
        return "Current balance is " + balanceToDisplay + " Rs.";
    }
}
