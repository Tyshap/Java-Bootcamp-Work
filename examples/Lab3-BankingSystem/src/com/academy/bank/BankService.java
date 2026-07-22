package com.academy.bank;

import java.util.Scanner;

public class BankService {
    private static final int MAX_CUSTOMERS = 50;
    private static final int MAX_ACCOUNTS = 100;
    private static final int MAX_TRANSACTIONS = 500;

    private final Customer[] customers = new Customer[MAX_CUSTOMERS];
    private final Account[] accounts = new Account[MAX_ACCOUNTS];
    private final Transaction[] transactions = new Transaction[MAX_TRANSACTIONS];

    private int customerCount = 0;
    private int accountCount = 0;
    private int transactionCount = 0;
    private int nextAccountNumber = 10001;
    private int nextTransactionNumber = 1;

    private final Scanner scanner;

    public BankService(Scanner scanner) {
        this.scanner = scanner;
    }

    public void createCustomer() {

        System.out.println("Please enter customerID: ");
        String customerID = scanner.nextLine();
        while(customerID.isEmpty()) {
            System.out.println("Please enter a valid customerID: ");
            customerID = customerID = scanner.nextLine();
        }
        if (searchCustomer(customerID) != null) {
            System.out.println("CustomerID Already Exists.");
            return;
        }

        System.out.println("Please enter name: ");
        String name = scanner.nextLine();
        while (name.isEmpty()) {
            System.out.println("Please enter a valid Name: ");
            name = scanner.nextLine();
        }

        System.out.println("Please enter email: ");
        String email = scanner.nextLine();
        while(email.isEmpty()) {
            System.out.println("Please enter a valid email: ");
            email = scanner.nextLine();
        }

        System.out.println("Please enter a phone number: ");
        double phoneNumber = Double.parseDouble(scanner.nextLine());
        while (phoneNumber < 1000000000.0 || phoneNumber > 9999999999.0) {
            System.out.println("Please enter a valid phone number");
            phoneNumber = Double.parseDouble(scanner.nextLine());
        }

        customers[customerCount++] = new Customer(customerID, name, email, phoneNumber);
        System.out.println("Customer Created Successfully");
        System.out.println("..........");

    }

    public void createCurrentAccount() {
        System.out.println("Please enter your customerID: ");
        String id = scanner.nextLine();
        Customer customer = searchCustomer(id);
        if (customer == null)  {
            System.out.println("Customer ID Invalid/Customer Does Not Exist.");
            return;
        }

        double amount = readPositiveAmount("initial amount");
        double transactionFee = readPositiveAmount("transactionFee");
        String accountID = String.valueOf(nextAccountNumber++);

        accounts[accountCount++] = new CurrentAccount(accountID, amount, customer, transactionFee);
        System.out.println("Savings Account Created.");
        accounts[accountCount - 1].displayAccount();
        System.out.println("..........");

    }

    public void createSavingsAccount() {
        System.out.println("Please enter your customerID: ");
        String id = scanner.nextLine();
        Customer customer = searchCustomer(id);
        if (customer == null)  {
            System.out.println("Customer ID Invalid/Customer Does Not Exist.");
            return;
        }

        double amount = readPositiveAmount("initial amount");
        double interest = readPositiveAmount("interest");
        String accountID = String.valueOf(nextAccountNumber++);

        accounts[accountCount++] = new SavingsAccount(accountID, amount, customer, interest);
        System.out.println("Current Account Created.");
        accounts[accountCount - 1].displayAccount();
        System.out.println("..........");
    }

    public void makeDeposit() {
        System.out.println("Please enter your accountID: ");
        String id = scanner.nextLine();
        Account account = searchAccount(id);
        if (account == null)  {
            System.out.println("Customer ID Invalid/Customer Does Not Exist.");
            return;
        }

        double amount = readPositiveAmount("amount");
        account.deposit(amount);
        transactions[transactionCount++] = new Transaction(String.valueOf(nextTransactionNumber), amount, "deposit", "today", id);
        System.out.printf("Balance updated: %.2f%n", account.getBalance());

    }

    public void makeWithdrawal() {
        System.out.println("Please enter your accountID: ");
        String id = scanner.nextLine();
        Account account = searchAccount(id);
        if (account == null)  {
            System.out.println("Customer ID Invalid/Customer Does Not Exist.");
            return;
        }

        double amount = readPositiveAmount("amount");
        if (account.withdrawal(amount) == true) {
            transactions[transactionCount++] = new Transaction(String.valueOf(nextTransactionNumber), amount, "withdrawal", "today", id);
            System.out.printf("Balance updated: %.2f%n", account.getBalance());
        }


    }

    public void displayAccounts() {
        for (int i = 0; i < accountCount; i++) {
            accounts[i].displayAccount();
        }
    }

    public void displayCustomers() {
        for (int i = 0; i < customerCount; i++) {
            customers[i].printDetails();
        }
    }

    public Customer searchCustomer(String id) {
        for (int i = 0; i < customerCount; i++) {
            if (customers[i].getCustomerID().equals(id)) {
                return customers[i];
            }
        }
        return null;
    }

    public Account searchAccount(String id) {
        for (int i = 0; i < accountCount; i++) {
            if(accounts[i].getAccountNumber().equals(id)) {
                return accounts[i];
            }
        }
        return null;
    }

    public double readPositiveAmount(String variable) {
        System.out.printf("Please enter %s: %n", variable);
        double amount = Double.parseDouble(scanner.nextLine());
        while (amount < 0) {
            System.out.printf("Please enter a positive %s: %n", variable);
            amount = Double.parseDouble(scanner.nextLine());
        }
        return amount;
    }

}