package com.northstar.crm.endpoint;

import com.northstar.crm.service.CustomerService;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

// TODO: ensure @Endpoint is present (stereotype for Spring-WS)
@Endpoint
public class CustomerEndpoint {
    private static final String NAMESPACE = "http://northstar.com/crm/customers";

    private final CustomerService customerService;
    private final CustomerSoapMapper mapper;

    public CustomerEndpoint(CustomerService customerService, CustomerSoapMapper mapper) {
        this.customerService = customerService;
        this.mapper = mapper;
    }

    // TODO: @PayloadRoot(namespace = NAMESPACE, localPart = "GetCustomerRequest")
    // TODO: @ResponsePayload
    @PayloadRoot(namespace = NAMESPACE, localPart = "GetCustomerRequest")
    @ResponsePayload
    public Object getCustomer(@RequestPayload Object request) {
        // TODO: extract customerId via mapper; call customerService.get; map to response
        String customerId = mapper.customerIdFromGetRequest(request);
        var customer = customerService.get(customerId);
        return mapper.toGetCustomerResponse(customer);
    }
}