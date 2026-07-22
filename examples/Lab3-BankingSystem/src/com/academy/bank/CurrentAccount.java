package com.academy.bank;

public class CurrentAccount extends Account implements Printable {

    private double transactionFee;

    public CurrentAccount(String accountNumber, double balance, Customer customer, double transactionFee) {
        super(accountNumber, balance, customer);
        this.transactionFee = transactionFee;
    }

    public double getTransactionFee() {
        return this.transactionFee;
    }
    public void setTransactionFee(double transactionFee) {
        this.transactionFee = transactionFee;
    }

    @Override
    public double calculateCharges() {
        return this.transactionFee;
    }

    @Override
    public void displayAccount() {
        System.out.printf("Account Details %n Type: %s %n Account Number: %s %n Customer Name: %s %n Balance: %.2f %n Transaction Fee: %.2f%n",
                this.getAccountType(),
                this.getAccountNumber(),
                this.getCustomer().getName(),
                this.getBalance(),
                this.getTransactionFee());

    }

    public void printDetails() {
        displayAccount();
    }

    @Override
    public String getAccountType() {
        return "Current";
    }
}