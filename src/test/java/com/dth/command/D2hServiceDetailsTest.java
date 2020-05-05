package com.dth.command;

import com.dth.modal.D2HServiceProvider;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;

class D2hServiceDetailsTest {
    @Test
    void shouldExecuteD2hServiceDetailsCommand() {
        D2HServiceProvider d2HServiceProvider = mock(D2HServiceProvider.class);
        Command d2hServiceDetails = new D2hServiceDetails(d2HServiceProvider);

        d2hServiceDetails.execute();

        Mockito.verify(d2HServiceProvider).displayAllServiceDetails();
    }
}