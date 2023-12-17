package com.nomadspa.backend.Therapist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TherapistRepository
        extends JpaRepository<Therapist,Long>{
    @Query("SELECT s FROM Therapist s WHERE s.phoneNumber = ?1")
    Optional<Therapist> findTherapistByPhoneNumber(String phoneNumber);
}

