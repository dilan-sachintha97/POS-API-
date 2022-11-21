package com.batch80.pointofsalebatch80.service.impl;

import com.batch80.pointofsalebatch80.dto.CustomerDTO;
import com.batch80.pointofsalebatch80.entity.Customer;
import com.batch80.pointofsalebatch80.repo.CustomerRepo;
import com.batch80.pointofsalebatch80.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceIML implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public String addCustomer(CustomerDTO customerDTO) {

        Customer customer = new Customer(
                customerDTO.getCustomerId(),
                customerDTO.getCustomerName(),
                customerDTO.getCustomerAddress(),
                customerDTO.getCustomerSalary(),
                customerDTO.getContactNumber(),
                customerDTO.getNic(),
                customerDTO.isActiveState()
        );

        if(!customerRepo.existsById(customer.getCustomerId())){
            customerRepo.save(customer);
            return "Saved Customer !";
        }else {
            return "Customer ID already exists !";
        }

    }

    @Override
    public String updateCustomer(CustomerDTO customerDTO) {
        if(customerRepo.existsById(customerDTO.getCustomerId())){
            Customer customer = customerRepo.getById(customerDTO.getCustomerId());

            customer.setCustomerName(customerDTO.getCustomerName());
            customer.setCustomerAddress(customerDTO.getCustomerAddress());
            customer.setCustomerSalary(customerDTO.getCustomerSalary());
            customer.setContactNumber(customerDTO.getContactNumber());
            customer.setNic(customerDTO.getNic());
            customer.setActiveState(customerDTO.isActiveState());

            customerRepo.save(customer);
            return "Updated";
        }else{
            return "No customer found from that id";
        }

    }
}
