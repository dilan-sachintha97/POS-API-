package com.batch80.pointofsalebatch80.repo;

import com.batch80.pointofsalebatch80.dto.CustomerDTO;
import com.batch80.pointofsalebatch80.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableJpaRepositories
@Repository
public interface CustomerRepo extends JpaRepository<Customer,Integer> {
    List<Customer> findAllByCustomerNameEquals(String customerName);
}
