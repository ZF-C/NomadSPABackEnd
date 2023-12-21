package com.nomadspa.backend.SpaService;
import com.nomadspa.backend.Customer.Customer;
import com.nomadspa.backend.SpaServiceCatalog.SpaServiceCatalog;
import com.nomadspa.backend.Therapist.Therapist;
import jakarta.persistence.*;
import java.util.Set;
import java.security.Provider;
import java.time.LocalDate;
import java.time.LocalDateTime;
@Entity
@Table
public class SpaService {
    @Id
    @SequenceGenerator(
            name = "spaService_sequence",
            sequenceName = "spaService_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "spaService_sequence"
    )
    private Long spaServiceId;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "therapist_id")
    private Therapist therapist;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "spa_service_catalog_id")
    private SpaServiceCatalog spaServiceCatalog;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    //增加paymentmethod
    private String paymentMethod;





    public SpaService(Customer customer, Therapist therapist, SpaServiceCatalog spaServiceCatalog, LocalDateTime startTime, LocalDateTime endTime, String paymentMethod) {
        this.customer = customer;
        this.therapist = therapist;
        this.spaServiceCatalog = spaServiceCatalog;
        this.startTime = startTime;
        this.endTime = endTime;
        this.paymentMethod = paymentMethod;
    }

    public SpaService() {

    }
    // Getters and setters
    public Long getSpaServiceId() {
        return spaServiceId;
    }

    public void setSpaServiceId(Long spaServiceId) {
        this.spaServiceId = spaServiceId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Therapist getTherapist() {
        return therapist;
    }

    public void setTherapist(Therapist therapist) {
        this.therapist = therapist;
    }

    public SpaServiceCatalog getSpaServiceCatalog() {
        return spaServiceCatalog;
    }

    public void setSpaServiceCatalog(SpaServiceCatalog spaServiceCatalog) {
        this.spaServiceCatalog = spaServiceCatalog;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public String toString() {
        return "SpaService{" +
                "spaServiceId=" + spaServiceId +
                ", customer=" + customer +
                ", therapist=" + therapist +
                ", spaServiceCatalog=" + spaServiceCatalog +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", paymentMethod='" + paymentMethod + '\'' +
                '}';
    }
}
