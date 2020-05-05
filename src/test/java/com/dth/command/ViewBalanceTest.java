package com.dth.command;

import com.dth.modal.Customer;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ViewBalanceTest {
    @Test
    void shouldExecuteViewBalanceCommand() {
        Customer customer = Mockito.mock(Customer.class);
        Command viewBalance = new ViewBalance(customer);

        viewBalance.execute();

        Mockito.verify(customer).displayBalance();
    }
}