package com.northstar.crm.controller;

import com.northstar.crm.dto.CustomerRequest;
import com.northstar.crm.dto.CustomerResponse;
import com.northstar.crm.service.CustomerService;

/**
 * Presentation/API boundary. Lab 8: stub only (no HTTP framework yet).
 * Later: Spring MVC / Spring-WS map HTTP/SOAP onto these methods.
 */
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    //TODO FIX public CustomerResponse createCustomer(CustomerRequest request) {
        //TODO FIX DTOs return customerService.createCustomer(request);
    //}

    //TODO FIX public CustomerResponse getCustomer(String customerId) {
        //return customerService.getCustomer(customerId);
    //}
}