package com.dth.command;

import com.dth.modal.Customer;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class SubscribePackTest {
    @Test
    void shouldExecuteSubscribePackCommand() {
        Customer customer = Mockito.mock(Customer.class);
        String packName = "Gold";
        int noOfMonths = 9;
        Command subscribePack = new SubscribePack(customer, packName, noOfMonths);

        subscribePack.execute();

        Mockito.verify(customer).subscribePack(packName, noOfMonths);
    }
}