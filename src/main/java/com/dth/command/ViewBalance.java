package com.dth.command;

import com.dth.modal.Customer;

public class ViewBalance implements Command {
    private Customer customer;

    public ViewBalance(Customer customer) {
        this.customer = customer;
    }

    @Override
    public void execute() {
        customer.displayBalance();
    }
}
