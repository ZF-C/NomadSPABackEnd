package com.nomadspa.backend.Therapist;

import jakarta.transaction.Transactional;
import org.hibernate.internal.build.AllowPrintStacktrace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
@Service
public class TherapistService {
    private final TherapistRepository TherapistRepository;
    @Autowired
    public TherapistService(TherapistRepository TherapistRepository) {
        this.TherapistRepository = TherapistRepository;
    }
    public List<Therapist> getTherapist(){
        return TherapistRepository.findAll();
    }

    public void addNewTherapist(Therapist therapist){
        Optional<Therapist> therapistByPhoneNumber = TherapistRepository
                .findTherapistByPhoneNumber(therapist.getPhoneNumber());
        if(therapistByPhoneNumber.isPresent()){
            throw new IllegalStateException("Therapist Phone number Taken");
        }
        TherapistRepository.save(therapist);
    }

    public void deleteTherapist(Long therapistID) {
        boolean exists = TherapistRepository.existsById(therapistID);
        if(!exists){
            throw new IllegalStateException(
                    "therapist with id" + therapistID + " does not exists");
        }
        TherapistRepository.deleteById(therapistID);
    }

    @Transactional
    public void updateTherapist(Long therapistId, String name, String phoneNumber) {
        Therapist therapist = TherapistRepository.findById(therapistId).
                orElseThrow(()->new IllegalStateException(
                        "Therapist with id" + therapistId + "does not exist"));


        if(name != null && !name.isEmpty() && !Objects.equals(therapist.getName(),name)){
            therapist.setName(name);
        }
        if(phoneNumber != null && !phoneNumber.isEmpty() && !Objects.equals(therapist.getPhoneNumber(),phoneNumber)){
            Optional<Therapist> studentOptional = TherapistRepository.findTherapistByPhoneNumber(phoneNumber);
            if(studentOptional.isPresent()){
                throw new IllegalStateException("Phone number been taken");
            }
            therapist.setPhoneNumber(phoneNumber);
        }
        TherapistRepository.save(therapist);
    }
    public void updateTherapistState(Long therapistId,Boolean active_or_not){
        Therapist therapist = TherapistRepository.findById(therapistId).
                orElseThrow(()->new IllegalStateException(
                        "Therapist with id" + therapistId + "does not exist"));
        therapist.setActiveOrNot(active_or_not);
        TherapistRepository.save(therapist);
    }

    public void updateTherapistSequence(Long therapistId,Integer sequenceNumber){
        Therapist therapist = TherapistRepository.findById(therapistId).
                orElseThrow(()->new IllegalStateException(
                        "Therapist with id" + therapistId + "does not exist"));
        therapist.setSequenceNumber(sequenceNumber);
        TherapistRepository.save(therapist);
    }

}
