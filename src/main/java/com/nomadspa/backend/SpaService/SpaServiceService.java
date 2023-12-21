package com.nomadspa.backend.SpaService;
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
public class SpaServiceService {
    // A function to add new service
    private final SpaServiceRepository SpaServiceRepository;
    @Autowired
    public SpaServiceService(SpaServiceRepository SpaServiceRepository) {
        this.SpaServiceRepository = SpaServiceRepository;
    }
    public List<SpaService> getSpaService(){
        return SpaServiceRepository.findAll();
    }
    public void addNewSpaService(SpaService spaService){
        SpaServiceRepository.save(spaService);
    }
    public void deleteSpaService(Long spaServiceId) {
        boolean exists = SpaServiceRepository.existsById(spaServiceId);
        if(!exists){
            throw new IllegalStateException(
                    "spaService with id" + spaServiceId + " does not exists");
        }
        SpaServiceRepository.deleteById(spaServiceId);
    }
}
