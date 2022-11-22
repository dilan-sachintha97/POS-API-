package com.batch80.pointofsalebatch80.repo;
import com.batch80.pointofsalebatch80.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@EnableJpaRepositories
@Repository
@Transactional
public interface CustomerRepo extends JpaRepository<Customer,Integer> {
    List<Customer> findAllByCustomerNameEquals(String customerName);

    List<Customer> findAllByCustomerNameEqualsAndActiveState(String customerName,Boolean activeState);

    List<Customer> findAllByActiveState(boolean activeState);

    @Modifying
    @Query(value = "update customer set customer_name =?2, customer_address=?3, customer_salary=?4 where customer_id=?1" , nativeQuery = true)
    void updateCustomerByQuery(int customerId, String customerName, String customerAddress, double customerSalary);
}
