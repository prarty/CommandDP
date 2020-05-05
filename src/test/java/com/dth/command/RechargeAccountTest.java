package com.dth.command;

import com.dth.modal.Customer;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class RechargeAccountTest {
    @Test
    void shouldExecuteRechargeAccountCommand() {
        Customer customer = Mockito.mock(Customer.class);
        int amount = 500;
        Command viewBalance = new RechargeAccount(customer, amount);

        viewBalance.execute();

        Mockito.verify(customer).rechargeAccount(amount);
    }
}