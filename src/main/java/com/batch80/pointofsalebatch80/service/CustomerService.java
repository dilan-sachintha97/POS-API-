package com.batch80.pointofsalebatch80.service;

import com.batch80.pointofsalebatch80.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {
    String addCustomer(CustomerDTO customerDTO);

    String updateCustomer(CustomerDTO customerDTO);

    CustomerDTO getCustomerById(int CustomerId);

    List<CustomerDTO> getAllCustomers();

    String deleteCustomer(int customerId);

    List<CustomerDTO> getAllCustomersByName(String customerName);


    List<CustomerDTO> getActiveCustomersByName(String customerName);
}
