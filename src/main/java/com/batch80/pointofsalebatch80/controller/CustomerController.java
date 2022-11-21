package com.batch80.pointofsalebatch80.controller;


import com.batch80.pointofsalebatch80.dto.CustomerDTO;
import com.batch80.pointofsalebatch80.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping(path = "/save")
    public String saveCustomer(@RequestBody CustomerDTO customerDTO){
       String save = customerService.addCustomer(customerDTO);
       return save;
    }

    @PutMapping(path = "/update")
    public String updateCustomer(@RequestBody CustomerDTO customerDTO){
      String update =   customerService.updateCustomer(customerDTO);
      return update;
    }

    @GetMapping(path = "/get-by-id",params = "id")
    public CustomerDTO getCustomerById(@RequestParam(value = "id") int customerId){
        System.out.println("customer id" + customerId);
        CustomerDTO  foundCustomer = customerService.getCustomerById(customerId);
        return foundCustomer;
    }

    @GetMapping(path = "/get-all-customer")
    public List<CustomerDTO> getAllCustomers(){
        List<CustomerDTO> allCustomers = customerService.getAllCustomers();
        return allCustomers;
    }


}
