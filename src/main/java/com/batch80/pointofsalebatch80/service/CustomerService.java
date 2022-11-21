package com.batch80.pointofsalebatch80.service;

import com.batch80.pointofsalebatch80.dto.CustomerDTO;
import com.batch80.pointofsalebatch80.dto.request.RequestUpdateCustomer;
import com.batch80.pointofsalebatch80.dto.response.ResponseActiveCustomerDTO;

import java.util.List;

public interface CustomerService {
    String addCustomer(CustomerDTO customerDTO);

    String updateCustomer(CustomerDTO customerDTO);

    CustomerDTO getCustomerById(int CustomerId);

    List<CustomerDTO> getAllCustomers();

    String deleteCustomer(int customerId);

    List<CustomerDTO> getAllCustomersByName(String customerName);


    List<CustomerDTO> getActiveCustomersByName(String customerName);

    List<ResponseActiveCustomerDTO> getAllActiveCustomers();

    String updateCustomerByQuery(int customerId, RequestUpdateCustomer customer);
}
