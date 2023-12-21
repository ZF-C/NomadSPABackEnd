package com.nomadspa.backend.SpaService;
import com.nomadspa.backend.Customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpaServiceRepository extends JpaRepository<SpaService,Long>{
//    @Query("SELECT s FROM SpaService s WHERE s.customer = ?1")
//    Optional<SpaService> findSpaServiceByCustomer(Customer customer);


}
