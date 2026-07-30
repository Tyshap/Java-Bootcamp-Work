package com.northstar.crm;

import com.northstar.crm.entity.Customer;
import com.northstar.crm.entity.CustomerStatus;
import com.northstar.crm.service.CustomerService;
import com.northstar.crm.api.CustomerApiFacade;
import com.northstar.crm.dto.CustomerRequestDTO;
import com.northstar.crm.dto.CustomerResponseDTO;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        CustomerApiFacade customerApiFacade = new CustomerApiFacade(new CustomerService());

        CustomerRequestDTO customerRequestDTO = new CustomerRequestDTO("CUS-1001", "Amina Kahn", "amina.akhn@example.com", "ACTIVE");
        customerApiFacade.create(customerRequestDTO, "lab-request-001");
        customerRequestDTO = new CustomerRequestDTO("CUS-1002", "Ravi Singh", "ravi.singh@example.com", "PROSPECT");
        customerApiFacade.create(customerRequestDTO, "lab-request-001");

        CustomerResponseDTO amina = customerApiFacade.getById("CUS-1001", "lab-request-001");
        CustomerResponseDTO ravi = customerApiFacade.getById("CUS-1002", "lab-request-001");

        System.out.println("Successfully retrieved " + amina.getCustomerId() +  " and " + ravi.getCustomerId());



    }
}