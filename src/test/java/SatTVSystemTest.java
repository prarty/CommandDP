import com.dth.SatTVSystem;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SatTVSystemTest {
    private static final String EOL = System.getProperty("line.separator");
    private ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private PrintStream originalOutputStream = System.out;

    @BeforeEach
    void setUpOutputStream() {
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void restoreStream() {
        System.setOut(originalOutputStream);
    }

    @Test
    void shouldDisplayCurrentBalanceWhenOption1IsSelected() {
        System.setIn(new ByteArrayInputStream(getInputForOption1()));

        String[] args = {""};
        SatTVSystem.main(args);

        assertEquals(menu() + "\n" + balance(), outputStream.toString().trim());
    }

    @Test
    void shouldRechargeAccountWhenOption2isSelected() {
        System.setIn(new ByteArrayInputStream(getInputForOption2()));

        String[] args = {""};
        SatTVSystem.main(args);

        assertEquals(menu() + "\n" + rechargeAmount(), outputStream.toString().trim());
    }

    @Test
    @DisplayName("should display available packs, channels and service details")
    void shouldDisplayDetailsWhenOption3isSelected() {
        System.setIn(new ByteArrayInputStream(getInputForOption3()));

        String[] args = {""};
        SatTVSystem.main(args);

        assertEquals(menu() + "\n" + allDetails(), outputStream.toString().trim());
    }

    @Test
    void shouldDisplayPackDetailsWhenOption4isSelected() {
        System.setIn(new ByteArrayInputStream(getInputForOption4()));

        String[] args = {""};
        SatTVSystem.main(args);

        assertEquals(menu() + "\n" + rechargeAmount() + "\n" + subscribePackDetails(), outputStream.toString().trim());
    }

    @Test
    void shouldAddChannelToExistingSubscriptionWhenOption5isSelected() {
        System.setIn(new ByteArrayInputStream(getInputForOption5()));

        String[] args = {""};
        SatTVSystem.main(args);

        assertEquals(menu() + "\n" + displayAddedChannelDetails(), outputStream.toString().trim());
    }

    @Test
    void shouldSubscribeToSpecialServiceWhenOption6isSelected() {
        System.setIn(new ByteArrayInputStream(getInputForOption6()));

        String[] args = {""};
        SatTVSystem.main(args);

        assertEquals(menu() + "\n" + specialServiceDetails(), outputStream.toString().trim());
    }

    private String specialServiceDetails() {
        return "Subscribe to special services\n" +
                "Enter the service name: Service subscribed successfully\n" +
                "Account balance: 0.0 Rs.\n" +
                "Email notification sent successfully\n" +
                "SMS notification sent successfully";
    }

    private String displayAddedChannelDetails() {
        return "Add channels to existing subscription\n" +
                "Enter channel names to add (separated by commas): Channels added successfully.\n" +
                "Account balance: 90.0 Rs.";
    }

    private String subscribePackDetails() {
        return "Subscribe to channel packsEnter the Pack you wish to subscribe: (Silver: 'S', Gold: 'G'): Enter the months: You have successfully subscribed the following packs - Gold Pack\n" +
                "Monthly price: 100.0\n" +
                "No of months: 3\n" +
                "Discount applied: 30.0\n" +
                "Final Price after discount: 270.0\n" +
                "Account balance: 330.0\n" +
                "Email notification sent successfully\n" +
                "SMS notification sent successfully";
    }

    private String allDetails() {
        return "View available packs, channels and servicesView available packs, channels and services\n" +
                "Available packs for subscription\n" +
                "Silver Pack: [Zee, Sony, Star Plus]: 50.0 Rs.\n" +
                "Gold Pack: [Zee, Sony, Star Plus, Discovery, NatGeo]: 100.0 Rs.\n" +
                "Available channels for subscription\n" +
                "Zee: 10.0 Rs.\n" +
                "Sony: 15.0 Rs.\n" +
                "Star Plus: 20.0 Rs.\n" +
                "Discovery: 10.0 Rs.\n" +
                "NatGeo: 20.0 Rs.\n" +
                "Available services for subscription\n" +
                "LearnEnglish Service: 200.0 Rs.\n" +
                "LearnCooking Service: 100.0 Rs.";
    }

    private String rechargeAmount() {
        return "Enter the amount to recharge: Recharge completed successfully. Current balance is 600.0 Rs.";
    }

    private String balance() {
        return "Current balance is 100.0 Rs.";
    }

    private String menu() {
        return "Welcome to SatTV\n" +
                "1. View current balance in the account\n" +
                "2. Recharge Account\n" +
                "3. View available packs, channels and services\n" +
                "4. Subscribe to base packs\n" +
                "5. Add channels to an existing subscription\n" +
                "6. Subscribe to special services\n" +
                "7. View current subscription details\n" +
                "8. Update email and phone number for notifications\n" +
                "9. Exit";
    }

    private byte[] getInputForOption1() {
        String input = "1" + EOL + "9";
        return input.getBytes();
    }

    private byte[] getInputForOption2() {
        String input = "2" + EOL + "500" + EOL + "9";
        return input.getBytes();
    }

    private byte[] getInputForOption3() {
        String input = "3" + EOL + "9";
        return input.getBytes();
    }

    private byte[] getInputForOption4() {
        String input = "2" + EOL + "500" + EOL + "4" + EOL + "G" + EOL + "3" + EOL + "9";
        return input.getBytes();
    }

    private byte[] getInputForOption5() {
        String input = "5" + EOL + "Discovery" + EOL + "9";
        return input.getBytes();
    }

    private byte[] getInputForOption6() {
        String input = "6" + EOL + "LearnCooking" + EOL + "9";
        return input.getBytes();
    }

}