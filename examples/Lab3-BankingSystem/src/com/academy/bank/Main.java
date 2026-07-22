package com.academy.bank;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankService bankService = new BankService(scanner);

        //Account a = new Account("X", 0, new Customer(1, "1", "1", 1234567890)); // must NOT compile

        int option = 0;
        System.out.printf("=====================================%n" +
                "Bank Management System%n" +
                "=====================================%n" +
                "1: Create a Customer%n" +
                "2: Create a Savings account%n" +
                "3: Create a Current account%n" +
                "4: Make a Deposit%n" +
                "5: Make a Withdrawal%n" +
                "6: Display All Accounts%n" +
                "7: Display All Customers%n" +
                "8: Exit%n");
        while(option != 8) {

            System.out.println("Choice: ");
            option = Integer.parseInt(scanner.nextLine());

            switch(option) {

                case 1:
                    bankService.createCustomer();
                    break;
                case 2:
                    bankService.createSavingsAccount();
                    break;
                case 3:
                    bankService.createCurrentAccount();
                    break;
                case 4:
                    bankService.makeDeposit();
                    break;
                case 5:
                    bankService.makeWithdrawal();
                    break;
                case 6:
                    bankService.displayAccounts();
                    break;
                case 7:
                    bankService.displayCustomers();
                    break;
                case 8:
                    System.out.println("Thank you, Exiting");
                    break;
                default:
                    System.out.println("Please enter a valid option");
                    break;
            }


        }

    }
}