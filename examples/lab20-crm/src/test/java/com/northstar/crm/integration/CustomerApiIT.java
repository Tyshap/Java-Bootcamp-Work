package com.northstar.crm.integration;

import com.northstar.crm.model.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CustomerApiIT {
    @LocalServerPort int port;
    @Autowired TestRestTemplate rest;

    @Test
    void createAndGetCus1001() {
        var headers = new HttpHeaders();
        headers.set("X-Correlation-Id", "lab-request-001");
        headers.setContentType(MediaType.APPLICATION_JSON);
        var body = """
      {"customerId":"CUS-1001","fullName":"Amina Khan","status":"ACTIVE"}
      """;
        var created = rest.exchange(
                "http://localhost:" + port + "/api/customers",
                HttpMethod.POST, new HttpEntity<>(body, headers), Customer.class);
        assertThat(created.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(created.getHeaders().getFirst("X-Correlation-Id")).isEqualTo("lab-request-001");
        var got = rest.getForEntity("/api/customers/CUS-1001", Customer.class);
        assertThat(got.getBody().getCustomerId()).isEqualTo("CUS-1001");
    }

    @Test
    void getMissingCustomerReturns404() {
        var response = rest.getForEntity("/api/customers/CUS-MISSING", String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }





}