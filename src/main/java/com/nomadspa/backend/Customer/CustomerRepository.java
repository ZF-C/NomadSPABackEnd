package com.nomadspa.backend.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository
        extends JpaRepository<Customer,Long>{
    @Query("SELECT s FROM Customer s WHERE s.phoneNumber = ?1")
    Optional<Customer> findCustomerByPhoneNumber(String phoneNumber);
}

