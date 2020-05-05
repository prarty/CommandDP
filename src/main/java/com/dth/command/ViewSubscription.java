package com.dth.command;

import com.dth.modal.Customer;

public class ViewSubscription implements Command {
    private Customer customer;

    public ViewSubscription(Customer customer) {
        this.customer = customer;
    }

    @Override
    public void execute() {
        customer.displaySubscriptionDetails();
    }
}
