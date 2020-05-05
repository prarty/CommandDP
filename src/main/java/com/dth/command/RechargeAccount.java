package com.dth.command;

import com.dth.modal.Customer;

public class RechargeAccount implements Command {
    private Customer customer;
    private int amount;

    public RechargeAccount(Customer customer, int amount) {
        this.customer = customer;
        this.amount = amount;
    }

    @Override
    public void execute() {
        customer.rechargeAccount(amount);
    }
}
