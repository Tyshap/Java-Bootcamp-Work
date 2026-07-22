package com.academy.bank;

import java.io.PrintStream;

public class Customer implements Printable{

    private String customerID;
    private String name;
    private String email;
    private double phone;

    public Customer(String customerID, String name, String email, double phone) {
        this.customerID = customerID;
        this.name = name;
        this.email = email;
        this.phone = phone;

    }

    public String getCustomerID() {
        return this.customerID;
    }
    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public double getPhone() {
        return this.phone;
    }
    public void setPhone(double phone) {
        this.phone = phone;
    }

    public void printDetails() {
        System.out.printf("Customer Information%n ID: %s %n Name: %s %n Email: %s %n Phone Number: %s%n ", this.customerID, this.name, this.email, this.phone);
    }

}