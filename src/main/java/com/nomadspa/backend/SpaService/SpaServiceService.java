package com.nomadspa.backend.SpaService;
import com.nomadspa.backend.Customer.Customer;
import com.nomadspa.backend.Customer.CustomerRepository;
import com.nomadspa.backend.SpaServiceCatalog.SpaServiceCatalog;
import com.nomadspa.backend.SpaServiceCatalog.SpaServiceCatalogRepository;
import com.nomadspa.backend.Therapist.Therapist;
import com.nomadspa.backend.Therapist.TherapistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpaServiceService {
    // A function to add new service
    private final SpaServiceRepository SpaServiceRepository;
    private final CustomerRepository customerRepository; // Assuming you have these repositories
    private final TherapistRepository therapistRepository;
    private final SpaServiceCatalogRepository spaServiceCatalogRepository;

    @Autowired
    public SpaServiceService(SpaServiceRepository SpaServiceRepository, CustomerRepository customerRepository, TherapistRepository therapistRepository, SpaServiceCatalogRepository spaServiceCatalogRepository) {
        this.SpaServiceRepository = SpaServiceRepository;
        this.customerRepository = customerRepository;
        this.therapistRepository = therapistRepository;
        this.spaServiceCatalogRepository = spaServiceCatalogRepository;
    }
    public List<SpaServiceDTO> getSpaService(){
        return SpaServiceMapper.toDTOList(SpaServiceRepository.findAll());
    }
    public List<SpaServiceDTO> getSpaServiceByCustomer(Long customerId){
        return SpaServiceMapper.toDTOList(SpaServiceRepository.findSpaServiceByCustomer(customerId));
    }

    public void addNewSpaService(SpaServiceDTO spaServiceDTO){
        Customer customer = customerRepository.findById(spaServiceDTO.getCustomerId()).orElseThrow(()->
                new IllegalStateException("customer with id" + spaServiceDTO.getCustomerId() + " does not exists"));
        Therapist therapist = therapistRepository.findById(spaServiceDTO.getTherapistId()).orElseThrow(()->
                new IllegalStateException("therapist with id " + spaServiceDTO.getTherapistId() + " does not exists"));
        SpaServiceCatalog spaServiceCatalog = spaServiceCatalogRepository.findById(spaServiceDTO.getSpaServiceCatalogId()).orElseThrow(()->
                new IllegalStateException("spaServiceCatalog with id " + spaServiceDTO.getSpaServiceCatalogId() + " does not exists"));
        SpaService spaService = new SpaService(customer, therapist, spaServiceCatalog, spaServiceDTO.getStartTime(), spaServiceDTO.getEndTime(), spaServiceDTO.getPaymentMethod());
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
