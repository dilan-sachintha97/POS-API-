package com.batch80.pointofsalebatch80.controller;


import com.batch80.pointofsalebatch80.dto.CustomerDTO;
import com.batch80.pointofsalebatch80.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping(path = "/save")
    public String saveCustomer(@RequestBody CustomerDTO customerDTO){
       String id = customerService.addCustomer(customerDTO);
        System.out.println(customerDTO.getCustomerId());
        System.out.println(customerDTO.getCustomerName());
        System.out.println(customerDTO.getCustomerAddress());
        System.out.println(customerDTO.getCustomerSalary());
        System.out.println(customerDTO.getContactNumber());
        System.out.println(customerDTO.getNic());
        customerDTO.isActiveState();
       return id;
    }


}
