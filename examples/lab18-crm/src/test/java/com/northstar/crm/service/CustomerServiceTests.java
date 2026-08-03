package com.northstar.crm.service;

import com.northstar.crm.entity.Customer;
import com.northstar.crm.entity.CustomerStatus;
import com.northstar.crm.exception.BusinessException;
import com.northstar.crm.repository.InMemoryCustomerRepository;
import com.northstar.crm.repository.CustomerRepository;
import java.time.LocalDateTime;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CustomerServiceTests {
    DefaultCustomerService service;

    @BeforeEach
    void setUp() {
        // TODO: fresh InMemoryCustomerRepository + CustomerValidator + DefaultCustomerService each test
        CustomerRepository repo = new InMemoryCustomerRepository();
        CustomerValidator validator = new CustomerValidator(repo);
        service = new DefaultCustomerService(repo, validator);
    }

    @Test
    void addAndActivateRaviHappyPath() {
        // TODO: add Amina ACTIVE + Ravi PROSPECT; changeStatus CUS-1002 → ACTIVE; assert ACTIVE
        Customer amina = new Customer("CUS-1001", "Amina Kahn", "amina.kahn@example.com", "1234567890", CustomerStatus.ACTIVE, LocalDateTime.now());
        assertEquals(service.addCustomer(amina), amina);
        Customer ravi = new Customer("CUS-1002", "Ravi Singh", "ravi.singh@example.com", "1234567890", CustomerStatus.PROSPECT, LocalDateTime.now());
        assertEquals(service.addCustomer(ravi), ravi);
        service.changeStatus("CUS-1002", CustomerStatus.ACTIVE, "lab-request-001");
        ravi = service.findById("CUS-1002").orElseThrow(() -> new IllegalStateException("Could Not Be Processed"));
        assertEquals(ravi.getStatus(), CustomerStatus.ACTIVE);

    }

    @Test
    void duplicateIdThrowsConflict() {
        // TODO: add Amina twice → assertThrows BusinessException
        Customer amina = new Customer("CUS-1001", "Amina Kahn", "amina.kahn@example.com", "1234567890", CustomerStatus.ACTIVE, LocalDateTime.now());
        assertEquals(service.addCustomer(amina), amina);
        BusinessException conflict = assertThrows(BusinessException.class, () -> service.addCustomer(amina));
    }

    @Test
    void illegalTransitionThrowsConflict() {
        // TODO: ACTIVE → PROSPECT on CUS-1001 → BusinessException; status still ACTIVE
        Customer amina = new Customer("CUS-1001", "Amina Kahn", "amina.kahn@example.com", "1234567890", CustomerStatus.ACTIVE, LocalDateTime.now());
        assertEquals(service.addCustomer(amina), amina);
        BusinessException conflict = assertThrows(BusinessException.class, () -> service.changeStatus("CUS-1001", CustomerStatus.PROSPECT, "lab-requst-001"));

    }

    @Test
    void missingCustomerThrowsNotFound() {
        // TODO: changeStatus CUS-9999 → BusinessException with CUSTOMER_NOT_FOUND
        BusinessException notFound = assertThrows(BusinessException.class, () -> service.changeStatus("CUS-9999", CustomerStatus.ACTIVE, "lab-request-001"));
    }
}