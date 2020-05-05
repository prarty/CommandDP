package com.dth.command;

import com.dth.modal.Customer;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;

class SubscribeServiceTest {
    @Test
    void shouldExecuteSubscribeServiceCommand() {
        Customer customer = mock(Customer.class);
        String serviceName = "Learn";
        Command subscribeService = new SubscribeService(customer, serviceName);

        subscribeService.execute();

        Mockito.verify(customer).subscribeService(serviceName);
    }
}