package com.dth.command;

import com.dth.modal.Customer;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;

class UpdateEmailAndPhoneNumberTest {
    @Test
    void shouldExecuteUpdateEmailAndPhoneNumberCommand() {
        Customer customer = mock(Customer.class);
        String phoneNumber = "999999999";
        String email = "abc@gmail.com";
        Command updateEmailAndPhoneNumber = new UpdateEmailAndPhoneNumber(customer, email, phoneNumber);

        updateEmailAndPhoneNumber.execute();

        Mockito.verify(customer).updateEmailAndPhoneNumber(email, phoneNumber);
    }
}