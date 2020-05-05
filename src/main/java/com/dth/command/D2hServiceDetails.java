package com.dth.command;

import com.dth.modal.D2HServiceProvider;

public class D2hServiceDetails implements Command {
    private D2HServiceProvider d2HServiceProvider;

    public D2hServiceDetails(D2HServiceProvider d2HServiceProvider) {
        this.d2HServiceProvider = d2HServiceProvider;
    }


    @Override
    public void execute() {
        d2HServiceProvider.displayAllServiceDetails();
    }
}
