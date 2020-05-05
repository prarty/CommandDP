package com.dth.command;

import com.dth.modal.Customer;

public class UpdateEmailAndPhoneNumber implements Command {
    private final Customer customer;
    private final String email;
    private final String phoneNumber;

    public UpdateEmailAndPhoneNumber(Customer customer, String email, String phoneNumber) {
        this.customer = customer;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void execute() {
        customer.updateEmailAndPhoneNumber(email, phoneNumber);
    }
}
