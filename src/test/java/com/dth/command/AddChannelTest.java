package com.dth.command;

import com.dth.modal.Customer;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.mockito.Mockito.mock;

class AddChannelTest {
    @Test
    void shouldExecuteAddChannelCommand() {
        Customer customer = mock(Customer.class);
        ArrayList<String> channels = mock(ArrayList.class);
        Command addChannel = new AddChannel(customer, channels);

        addChannel.execute();

        Mockito.verify(customer).addChannel(channels);
    }
}