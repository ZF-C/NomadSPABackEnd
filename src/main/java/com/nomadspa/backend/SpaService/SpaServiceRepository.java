package com.nomadspa.backend.SpaService;
import com.nomadspa.backend.Customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface SpaServiceRepository extends JpaRepository<SpaService,Long>{
    //返回某个顾客的所有预约
    @Query("SELECT s FROM SpaService s join s.customer c ON c.customerId = :customerId")
    List<SpaService> findSpaServiceByCustomer(@Param("customerId") Long customerId);

    //返回某个时间段内的所有预约
    List<SpaService> findByStartTimeBetween(LocalDateTime start, LocalDateTime end);

    //返回某个按摩师某天的所有预约
    @Query("SELECT s FROM SpaService s join s.therapist t ON t.id = :therapistId WHERE s.startTime BETWEEN :start AND :end")
    List<SpaService> findByTherapistAndStartTimeBetween(@Param("therapistId")Long therapistId, LocalDateTime start, LocalDateTime end);



}
