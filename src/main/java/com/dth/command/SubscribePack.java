package com.dth.command;

import com.dth.modal.Customer;

public class SubscribePack implements Command {
    private final Customer customer;
    private final String pack;
    private final int noOfMonths;

    public SubscribePack(Customer customer, String pack, int noOfMonths) {
        this.customer = customer;
        this.pack = pack;
        this.noOfMonths = noOfMonths;
    }

    @Override
    public void execute() {
        customer.subscribePack(pack, noOfMonths);
    }
}
