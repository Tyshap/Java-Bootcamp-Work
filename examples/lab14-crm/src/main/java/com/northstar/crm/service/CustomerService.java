package com.northstar.crm.service;

import com.northstar.crm.entity.Customer;
import com.northstar.crm.entity.CustomerStatus;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Objects;

public class CustomerService {
    private final Map<String, Customer> customersById = new HashMap();

    private final CustomerNotifier notifier;

    public CustomerService() {
        this(new CustomerNotifier() {
            @Override
            public void notifyStatusChange(String customerId, CustomerStatus oldStatus, CustomerStatus newStatus) {
                // no-op
            }
        });
    }

    public CustomerService(CustomerNotifier notifier) {
        this.notifier = notifier != null ? notifier : new CustomerNotifier() {
            @Override
            public void notifyStatusChange(String customerId, CustomerStatus oldStatus, CustomerStatus newStatus) {
                // no-op
            }
        };
    }

    public Customer createCustomer(String customerId, String fullName, String email, String phone, CustomerStatus status) {
       requireUniqueID(customerId);
       requireNonBlank(fullName, "fullName");
       requireNonBlank(email, "email");
       requireNonBlank(phone, "phone");
       requireNonBlank(status.toString(), "status");
       Customer customer = new Customer(customerId, fullName, email, phone, status, LocalDateTime.now());
       customersById.put(customerId, customer);
       return customer;
    }

    public Customer findByCustomerId(String customerId) {
        return requireExisting(customerId);
    }

    public Customer updateStatus(String customerId, CustomerStatus newStatus) {
        requireNonBlank(newStatus.toString(), "status");
        Customer customer = requireExisting(customerId);
        CustomerStatus oldStatus = customer.getStatus();
        customer.setStatus(newStatus);
        notifier.notifyStatusChange(customerId, oldStatus, newStatus);
        return customer;

    }

    private void requireNonBlank(String value, String fieldName) {
        if (value.equals(null) || value.isBlank()) {
            throw new IllegalArgumentException(fieldName + " must not be blank");
        }
    }

    private void requireUniqueID(String customerID) {
        if (customersById.containsKey(customerID)) {
            throw new IllegalStateException("Customer ID " + customerID + " already exists");
        }
    }

    private Customer requireExisting(String customerId) {
        Customer customer = customersById.get(customerId);
        if (Objects.isNull(customer)) {
            throw new IllegalArgumentException("Customer ID " + customerId + " does not exist");
        }
        return customer;
    }

    public List<Customer> listAll() {
        return new ArrayList<>(customersById.values());
    }


    public List<Customer> findByStatus(CustomerStatus status) {
        requireNonBlank(status.toString(), "status");
        List<Customer> customers = new ArrayList<>();
        for (Customer customer : customersById.values()) {
            if (status.equals(customer.getStatus())) {
                customers.add(customer);
            }
        }
        return customers;

    }

    public Customer addCustomer(Customer customer) {
        requireUniqueID(customer.getCustomerId());
        customersById.put(customer.getCustomerId(), customer);
        return customer;
    }
}



