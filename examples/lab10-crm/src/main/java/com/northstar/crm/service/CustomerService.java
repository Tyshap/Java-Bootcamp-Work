package com.northstar.crm.service;

import com.northstar.crm.entity.Customer;
import com.northstar.crm.entity.CustomerStatus;
import com.northstar.crm.dto.CustomerResponse;
import com.northstar.crm.dto.CustomerRequest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Plain in-memory CustomerService (no frameworks).
 */
public class CustomerService {

    private final List<Customer> customers = new ArrayList<>();

    public Customer addCustomer(Customer customer) {
        if (customer == null) {
            throw new IllegalArgumentException("customer must not be null");
        }
        String id = customer.getCustomerId();
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("customerId must not be blank");
        }
        if (findByCustomerId(id).isPresent()) {
            throw new IllegalStateException("Duplicate customerId: " + id);
        }
        customers.add(customer);
        return customer;
    }

    public Optional<Customer> findByCustomerId(String customerId) {
        if (customerId == null) return Optional.empty();
        return customers.stream()
                .filter(c -> customerId.equals(c.getCustomerId()))
                .findFirst();
    }

    public List<Customer> findByStatus(CustomerStatus status) {
        if (status == null) return Collections.emptyList();
        List<Customer> result = new ArrayList<>();
        for (Customer c : customers) {
            if (status.equals(c.getStatus())) result.add(c);
        }
        return result;
    }

    public Customer updateStatus(String customerId, CustomerStatus newStatus) {
        Optional<Customer> opt = findByCustomerId(customerId);
        if (!opt.isPresent()) {
            throw new IllegalArgumentException("Customer not found: " + customerId);
        }
        Customer customer = opt.get();
        customer.setStatus(newStatus);
        return customer;
    }

    public List<Customer> listAll() {
        return Collections.unmodifiableList(new ArrayList<>(customers));
    }


    public CustomerResponse create(CustomerRequest request) {
        throw new UnsupportedOperationException("Lab 8 stub — implement later");
    }

    public CustomerResponse getById(String customerId) {
        throw new UnsupportedOperationException("Lab 8 stub — implement later");
    }
}





