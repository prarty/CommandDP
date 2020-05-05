package com.dth.command;

import com.dth.modal.Customer;

import java.util.List;

public class AddChannel implements Command {
    private final Customer customer;
    private final List<String> channels;

    public AddChannel(Customer customer, List<String> channels) {
        this.customer = customer;
        this.channels = channels;
    }

    @Override
    public void execute() {
        customer.addChannel(channels);
    }
}
