package com.nomadspa.backend.SpaServiceCatalog;
import jakarta.transaction.Transactional;
import org.hibernate.internal.build.AllowPrintStacktrace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.time.LocalTime;
@Service
public class SpaServiceCatalogService {
    private final SpaServiceCatalogRepository SpaServiceCatalogRepository;
    @Autowired
    public SpaServiceCatalogService(SpaServiceCatalogRepository SpaServiceCatalogRepository) {
        this.SpaServiceCatalogRepository = SpaServiceCatalogRepository;
    }
    public List<SpaServiceCatalog> getSpaServiceCatalog(){
        return SpaServiceCatalogRepository.findAll();
    }
    public void addNewSpaServiceCatalog(SpaServiceCatalog spaServiceCatalog){
        Optional<SpaServiceCatalog> spaServiceCatalogByServiceName = SpaServiceCatalogRepository
                .findSpaServiceCatalogByServiceName(spaServiceCatalog.getServiceName());
        if(spaServiceCatalogByServiceName.isPresent()){
            throw new IllegalStateException("Service Name Taken");
        }
        SpaServiceCatalogRepository.save(spaServiceCatalog);
    }
    public void deleteSpaServiceCatalog(Long spaServiceCatalogId) {
        boolean exists = SpaServiceCatalogRepository.existsById(spaServiceCatalogId);
        if(!exists){
            throw new IllegalStateException(
                    "Spa Service with id" + spaServiceCatalogId + " does not exists");
        }
        SpaServiceCatalogRepository.deleteById(spaServiceCatalogId);
    }
    @Transactional
    public void updateSpaServiceCatalog(Long spaServiceCatalogId, String serviceName, Double price, Double commission,LocalTime duration) {
        SpaServiceCatalog spaServiceCatalog = SpaServiceCatalogRepository.findById(spaServiceCatalogId).
                orElseThrow(() -> new IllegalStateException(
                        "Spa Service with id" + spaServiceCatalogId + "does not exist"));
        if (serviceName != null && !serviceName.isEmpty() && !Objects.equals(spaServiceCatalog.getServiceName(), serviceName)) {
            spaServiceCatalog.setServiceName(serviceName);
        }
        if (price != null && !Objects.equals(spaServiceCatalog.getPrice(), price)) {
            spaServiceCatalog.setPrice(price);
        }
        if (commission != null && !Objects.equals(spaServiceCatalog.getCommission(), commission)) {
            spaServiceCatalog.setCommission(commission);
        }
        if (duration != null && !Objects.equals(spaServiceCatalog.getDuration(), duration)) {
            spaServiceCatalog.setDuration(duration);
        }
    }
}
