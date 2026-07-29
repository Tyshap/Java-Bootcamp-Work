package com.northstar.crm.service;

import com.northstar.crm.entity.Customer;
import com.northstar.crm.entity.CustomerStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CustomerServiceTest {

    private CustomerService service;

    @BeforeEach
    void setUp() {
        service = new CustomerService();
    }

    @Test
    void addCustomer_stores_new_customer() {
        Customer c = new Customer("CUS-1001", "Alice A", "alice@example.com", "111-1111", CustomerStatus.PROSPECT, LocalDateTime.now());
        service.addCustomer(c);
        Optional<Customer> found = service.findByCustomerId("CUS-1001");
        assertTrue(found.isPresent());
        assertEquals(c, found.get());
    }

    @Test
    void addCustomer_duplicate_throws() {
        service.addCustomer(new Customer("CUS-1001", "Alice A", "alice@example.com", "111-1111", CustomerStatus.PROSPECT, LocalDateTime.now()));
        assertThrows(IllegalStateException.class, () -> service.addCustomer(new Customer("CUS-1001", "Bob B", "bob@example.com", "222-2222", CustomerStatus.ACTIVE, LocalDateTime.now())));
    }

    @Test
    void updateStatus_changes_existing_status() {
        service.addCustomer(new Customer("CUS-1002", "Carol C", "carol@example.com", "333-3333", CustomerStatus.PROSPECT, LocalDateTime.now()));
        service.updateStatus("CUS-1002", CustomerStatus.ACTIVE);
        Optional<Customer> found = service.findByCustomerId("CUS-1002");
        assertTrue(found.isPresent());
        assertEquals(CustomerStatus.ACTIVE, found.get().getStatus());
    }

    @Test
    void updateStatus_unknown_throws() {
        assertThrows(IllegalArgumentException.class, () -> service.updateStatus("CUS-9999", CustomerStatus.ACTIVE));
    }

    @Test
    void findByStatus_returns_matching_customers() {
        service.addCustomer(new Customer("CUS-1001", "Alice A", "alice@example.com", "111-1111", CustomerStatus.ACTIVE, LocalDateTime.now()));
        service.addCustomer(new Customer("CUS-1002", "Bob B", "bob@example.com", "222-2222", CustomerStatus.PROSPECT, LocalDateTime.now()));
        service.addCustomer(new Customer("CUS-1003", "Eve E", "eve@example.com", "333-3333", CustomerStatus.ACTIVE, LocalDateTime.now()));
        java.util.List<Customer> active = service.findByStatus(CustomerStatus.ACTIVE);
        assertEquals(2, active.size());
        assertTrue(active.stream().anyMatch(c -> "CUS-1001".equals(c.getCustomerId())));
        assertTrue(active.stream().anyMatch(c -> "CUS-1003".equals(c.getCustomerId())));
    }
}



