package com.dth;

import com.dth.command.*;
import com.dth.modal.Customer;
import com.dth.modal.D2HServiceProvider;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//Solving D2H problem using Command design pattern
public class SatTVSystem {
    public static void main(String[] args) {
        String menu = getMenu();
        Scanner input = new Scanner(System.in);
        int balance = 100;
        D2HServiceProvider d2HServiceProvider = new D2HServiceProvider();
        Customer customer = new Customer(balance, d2HServiceProvider);
        System.out.println(menu);
        CommandMenu commandMenu = new CommandMenu();
        int option = input.nextInt();
        do {
            switch (option) {
                case 1:
                    Command viewBalance = new ViewBalance(customer);
                    commandMenu.setMenuOption(1, viewBalance);
                    commandMenu.runMenuOption(1);
                    break;
                case 2:
                    System.out.print("Enter the amount to recharge: ");
                    int amount = input.nextInt();
                    Command rechargeAccount = new RechargeAccount(customer, amount);
                    commandMenu.setMenuOption(2, rechargeAccount);
                    commandMenu.runMenuOption(2);
                    break;
                case 3:
                    System.out.print("View available packs, channels and services");
                    Command d2hServiceDetails = new D2hServiceDetails(d2HServiceProvider);
                    commandMenu.setMenuOption(3, d2hServiceDetails);
                    commandMenu.runMenuOption(3);
                    break;
                case 4:
                    System.out.print("Subscribe to channel packs");
                    System.out.print("Enter the Pack you wish to subscribe: (Silver: 'S', Gold: 'G'): ");
                    String pack = input.next();
                    System.out.print("Enter the months: ");
                    int noOfMonths = input.nextInt();
                    Command subscribePack = new SubscribePack(customer, pack, noOfMonths);
                    commandMenu.setMenuOption(4, subscribePack);
                    commandMenu.runMenuOption(4);
                    break;
                case 5:
                    //To skip the line for input
                    input.nextLine();
                    System.out.println("Add channels to existing subscription");
                    System.out.print("Enter channel names to add (separated by commas): ");
                    String channelInput = input.nextLine();
                    List<String> channels = Arrays.asList(channelInput.split("\\s*,\\s*"));
                    Command addChannel = new AddChannel(customer, channels);
                    commandMenu.setMenuOption(5, addChannel);
                    commandMenu.runMenuOption(5);
                    break;
                case 6:
                    System.out.println("Subscribe to special services");
                    System.out.print("Enter the service name: ");
                    String serviceName = input.next();
                    Command subscribeService = new SubscribeService(customer, serviceName);
                    commandMenu.setMenuOption(6, subscribeService);
                    commandMenu.runMenuOption(6);
                    break;
                case 7:
                    System.out.println("View current subscription details");
                    Command viewSubscription = new ViewSubscription(customer);
                    commandMenu.setMenuOption(7, viewSubscription);
                    commandMenu.runMenuOption(7);
                    break;
                case 8:
                    System.out.println("Update email and phone number for notifications");
                    System.out.print("Enter the email: ");
                    String email = input.next();
                    System.out.print("Enter phone: ");
                    String phoneNumber = input.next();
                    Command updateEmailAndPhoneNumber = new UpdateEmailAndPhoneNumber(customer, email, phoneNumber);
                    commandMenu.setMenuOption(8, updateEmailAndPhoneNumber);
                    commandMenu.runMenuOption(8);
                    break;
            }
            option = input.nextInt();

        } while (option != 9);
    }

    private static String getMenu() {
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
}
