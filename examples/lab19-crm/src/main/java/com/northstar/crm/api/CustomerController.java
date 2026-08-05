package com.northstar.crm.api;

import com.northstar.crm.model.Customer;
import com.northstar.crm.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    private final CustomerService customers;

    public CustomerController(CustomerService customers) {
        this.customers = customers;
    }

    @PostMapping
    public ResponseEntity<?> create(
            @RequestHeader(value = "X-Correlation-Id", required = false) String correlationId,
            @RequestBody Customer body) {
        try {
            var created = customers.create(body, correlationId != null ? correlationId : "lab-request-001");
            return ResponseEntity.status(HttpStatus.CREATED)
                    .header("X-Correlation-Id", created.correlationId())
                    .body(created);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> get(@PathVariable String id) {
        return customers.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}

