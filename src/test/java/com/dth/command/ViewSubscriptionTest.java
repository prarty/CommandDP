package com.dth.command;

import com.dth.modal.Customer;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;

class ViewSubscriptionTest {
    @Test
    void shouldExecuteViewSubscriptionCommand() {
        Customer customer = Mockito.mock(Customer.class);
        Command viewSubscription = new ViewSubscription(customer);

        viewSubscription.execute();

        verify(customer).displaySubscriptionDetails();
    }
}