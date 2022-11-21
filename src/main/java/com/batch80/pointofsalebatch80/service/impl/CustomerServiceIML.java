package com.batch80.pointofsalebatch80.service.impl;

import com.batch80.pointofsalebatch80.dto.CustomerDTO;
import com.batch80.pointofsalebatch80.entity.Customer;
import com.batch80.pointofsalebatch80.repo.CustomerRepo;
import com.batch80.pointofsalebatch80.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceIML implements CustomerService {
    @Autowired
    private ModelMapper modelMapper;

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

        if (!customerRepo.existsById(customer.getCustomerId())) {
            customerRepo.save(customer);
            return "Saved Customer !";
        } else {
            return "Customer ID already exists !";
        }

    }

    @Override
    public String updateCustomer(CustomerDTO customerDTO) {
        if (customerRepo.existsById(customerDTO.getCustomerId())) {
            Customer customer = customerRepo.getById(customerDTO.getCustomerId());

            customer.setCustomerName(customerDTO.getCustomerName());
            customer.setCustomerAddress(customerDTO.getCustomerAddress());
            customer.setCustomerSalary(customerDTO.getCustomerSalary());
            customer.setContactNumber(customerDTO.getContactNumber());
            customer.setNic(customerDTO.getNic());
            customer.setActiveState(customerDTO.isActiveState());

            customerRepo.save(customer);
            return "Updated";
        } else {
            return "No customer found from that id";
        }

    }

    @Override
    public CustomerDTO getCustomerById(int customerId) {
        /*if (customerRepo.existsById(customerId)) {
            Customer customer = customerRepo.getById(customerId);
            CustomerDTO customerDTO = new CustomerDTO(
                    customer.getCustomerId(),
                    customer.getCustomerName(),
                    customer.getCustomerAddress(),
                    customer.getCustomerSalary(),
                    customer.getContactNumber(),
                    customer.getNic(),
                    customer.isActiveState()
            );
            return customerDTO;*/

        Optional <Customer> customer = customerRepo.findById(customerId);
        if(customer.isPresent()){
            /*CustomerDTO customerDTO = new CustomerDTO(
                    customer.get().getCustomerId(),
                    customer.get().getCustomerName(),
                    customer.get().getCustomerAddress(),
                    customer.get().getCustomerSalary(),
                    customer.get().getContactNumber(),
                    customer.get().getNic(),
                    customer.get().isActiveState());*/
            CustomerDTO customerDTO = modelMapper.map(customer.get(),CustomerDTO.class);  // use of model mapper -> convert things in one object to another object
            return customerDTO;
        } else {
            return null;
        }
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> customerList = customerRepo.findAll();
       /* List<CustomerDTO> customerDTOList = new ArrayList<>();

        for(Customer customer: customerList){
            CustomerDTO customerDTO = new CustomerDTO(
                    customer.getCustomerId(),
                    customer.getCustomerName(),
                    customer.getCustomerAddress(),
                    customer.getCustomerSalary(),
                    customer.getContactNumber(),
                    customer.getNic(),
                    customer.isActiveState()
            );
            customerDTOList.add(customerDTO);
            */

        List<CustomerDTO> customerDTOList = modelMapper.map(customerList, new TypeToken<List<CustomerDTO>>(){}.getType());



        return customerDTOList;
    }

    @Override
    public String  deleteCustomer(int customerId) {
        if(customerRepo.existsById(customerId)){
            customerRepo.deleteById(customerId);
            return "Deleted Customer !";
        }
        return "No found customer from that id";
    }

    @Override
    public List<CustomerDTO> getAllCustomersByName(String customerName) {
        List<Customer> customerList = customerRepo.findAllByCustomerNameEquals(customerName);

       /* List<CustomerDTO> customerDTOList = new ArrayList<>();
        for(Customer customer1: customerList){
            CustomerDTO customerDTO = new CustomerDTO(
                    customer1.getCustomerId(),
                    customer1.getCustomerName(),
                    customer1.getCustomerAddress(),
                    customer1.getCustomerSalary(),
                    customer1.getContactNumber(),
                    customer1.getNic(),
                    customer1.isActiveState()
            );

            customerDTOList.add(customerDTO);
        }
*/
        if(customerList.size() > 0){
            List<CustomerDTO> customerDTOList = modelMapper.map(
                    customerList, new TypeToken<List<CustomerDTO>>(){}.getType()
            );
            return customerDTOList;
        }else {
            return null;
        }

    }

    @Override
    public List<CustomerDTO> getActiveCustomersByName(String customerName) {

        List<Customer> customerList = customerRepo.findAllByCustomerNameEqualsAndActiveState(customerName, true);
        System.out.println(customerName);

        if(customerList.size()>0){
            List<CustomerDTO> customerDTOList = modelMapper.map(customerList,new TypeToken<List<CustomerDTO>>(){}.getType());
            return  customerDTOList;
        }else {
            return null;
        }

    }

}

