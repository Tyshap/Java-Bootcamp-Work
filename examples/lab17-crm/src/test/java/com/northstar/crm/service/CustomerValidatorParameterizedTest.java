package com.northstar.crm.service;

import com.northstar.crm.entity.CustomerStatus;
import com.northstar.crm.repository.InMemoryCustomerRepository;
import com.northstar.crm.exception.BusinessException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

class CustomerValidatorParameterizedTest {
    CustomerValidator validator = new CustomerValidator(new InMemoryCustomerRepository());

    @ParameterizedTest
    @CsvSource({
            // TODO: legal rows e.g. PROSPECT,ACTIVE
            "PROSPECT, ACTIVE",
            "PROSPECT, CLOSED",
            "ACTIVE, SUSPENDED",
            "ACTIVE, CLOSED",
            "SUSPENDED, ACTIVE",
            "SUSPENDED, CLOSED"

    })
    void legalTransitions(CustomerStatus from, CustomerStatus to) {

        // TODO: assertDoesNotThrow validateTransition(from, to, "lab-request-001")
        assertDoesNotThrow(() -> {
            validator.validateTransition(from, to, "lab-request-001");
        });
    }

    @ParameterizedTest
    @CsvSource({
            // TODO: illegal rows e.g. ACTIVE,PROSPECT and CLOSED,ACTIVE
            "ACTIVE, PROSPECT",
            "PROSPECT, SUSPENDED",
            "CLOSED, ACTIVE",
            "CLOSED, SUSPENDED",
            "CLOSED, PROSPECT"
    })
    void illegalTransitions(CustomerStatus from, CustomerStatus to) {
        // TODO: assertThrows BusinessException
        BusinessException exception = assertThrows(BusinessException.class, () -> validator.validateTransition(from, to, "lab-request-001"));
    }
}