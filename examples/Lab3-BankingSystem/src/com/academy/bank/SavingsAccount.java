package com.academy.bank;

public class SavingsAccount extends Account implements Printable {

    private double interestRate;

    public SavingsAccount(String accountNumber, double balance, Customer customer, double interestRate) {
        super(accountNumber, balance, customer);
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return this.interestRate;
    }
    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    public double calculateInterest() {
        return this.getBalance() * this.interestRate / 100.0;
    }

    @Override
    public void displayAccount() {
        System.out.printf("Account Details %n Type: %s %n Account Number: %s %n Customer Name: %s %n Balance: %.2f %n Interest Rate: %.2f %n Interest: %.2f %n",
                this.getAccountType(),
                this.getAccountNumber(),
                this.getCustomer().getName(),
                this.getBalance(),
                this.getInterestRate(),
                this.calculateInterest());

    }

    public void printDetails() {
        this.displayAccount();
    }

    @Override
    public String getAccountType() {
        return "Savings";
    }

}