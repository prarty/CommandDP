package com.dth.command;

import com.dth.modal.Customer;

public class SubscribeService implements Command {
    private final Customer customer;
    private final String serviceName;

    public SubscribeService(Customer customer, String serviceName) {
        this.customer = customer;
        this.serviceName = serviceName;
    }

    @Override
    public void execute() {
        customer.subscribeService(serviceName);
    }
}
