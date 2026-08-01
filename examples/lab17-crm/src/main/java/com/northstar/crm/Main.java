package com.northstar.crm;

import com.northstar.crm.api.ApiResult;
import com.northstar.crm.entity.Customer;
import com.northstar.crm.entity.CustomerStatus;
import com.northstar.crm.service.DefaultCustomerService;
import com.northstar.crm.service.CustomerService;
import com.northstar.crm.service.CustomerValidator;
import com.northstar.crm.api.CustomerApiFacade;
import com.northstar.crm.api.ApiResult;
import com.northstar.crm.dto.CustomerRequestDTO;
import com.northstar.crm.dto.CustomerResponseDTO;
import com.northstar.crm.repository.CustomerRepository;
import com.northstar.crm.repository.InMemoryCustomerRepository;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        CustomerRepository repo = new InMemoryCustomerRepository();
        CustomerValidator validator = new CustomerValidator(repo);
        CustomerService service = new DefaultCustomerService(repo, validator);
        CustomerApiFacade customerApiFacade = new CustomerApiFacade(service);

        CustomerResponseDTO amina;
        CustomerResponseDTO ravi;

        CustomerRequestDTO customerRequestDTO = new CustomerRequestDTO("CUS-1001", "Amina Kahn", "amina.kahn@example.com", "ACTIVE");
        ApiResult apiResult = customerApiFacade.create(customerRequestDTO, "lab-request-001");
        if (apiResult instanceof ApiResult.Ok ok) {
            amina = ok.body();
        }
        if (apiResult instanceof ApiResult.Fail fail) {
            System.out.println(fail.error().toJson());
        }

        customerRequestDTO = new CustomerRequestDTO("CUS-1002", "Ravi Singh", "ravi.singh@example.com", "PROSPECT");
        apiResult = customerApiFacade.create(customerRequestDTO, "lab-request-001");
        if (apiResult instanceof ApiResult.Ok ok) {
            ravi = ok.body();
        }
        if (apiResult instanceof ApiResult.Fail fail) {
            System.out.println(fail.error().toJson());
        }



        apiResult = customerApiFacade.changeStatus("CUS-1001", CustomerStatus.PROSPECT, "lab-request-001");
        if (apiResult instanceof ApiResult.Ok ok) {
            amina = ok.body();
        }
        if (apiResult instanceof ApiResult.Fail fail) {
            System.out.println(fail.error().toJson());
        }

        apiResult = customerApiFacade.changeStatus("CUS-1002", CustomerStatus.ACTIVE, "lab-request-001");
        if (apiResult instanceof ApiResult.Ok ok) {
            ravi = ok.body();
        }
        if (apiResult instanceof ApiResult.Fail fail) {
            System.out.println(fail.error().toJson());
        }

        apiResult = customerApiFacade.changeStatus("CUS-1001", CustomerStatus.SUSPENDED, "lab-request-001");
        if (apiResult instanceof ApiResult.Ok ok) {
            amina = ok.body();
        }
        if (apiResult instanceof ApiResult.Fail fail) {
            System.out.println(fail.error().toJson());
        }
        apiResult = customerApiFacade.getById("CUS-9999", "lab-request-001");
        if (apiResult instanceof ApiResult.Ok ok) {
            amina = ok.body();
        }
        if (apiResult instanceof ApiResult.Fail fail) {
            System.out.println(fail.error().toJson());
        }


        // Lab 16: Test validation error handling
        CustomerApiFacade facade = new CustomerApiFacade(service);
        CustomerRequestDTO invalidRequest = new CustomerRequestDTO(
                "CUS-1003",
                "Test User",
                "email-not-an-email",
                "PROSPECT"
        );
        ApiResult result = facade.create(invalidRequest, "lab-request-001");
        
        if (result instanceof ApiResult.Fail fail) {
            System.out.println(fail.error().toJson());
        }
    }
}