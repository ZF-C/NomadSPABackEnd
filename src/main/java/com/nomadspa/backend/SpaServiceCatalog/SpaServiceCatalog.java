package com.nomadspa.backend.SpaServiceCatalog;
import com.nomadspa.backend.SpaService.SpaService;
import jakarta.persistence.*;

import java.time.LocalTime;
import java.util.Set;
import java.security.Provider;
@Entity
@Table(name = "spa_service_catalog")
public class SpaServiceCatalog {
    @Id
    @SequenceGenerator(
            name = "spaServiceCatalog_sequence",
            sequenceName = "spaServiceCatalog_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "spaServiceCatalog_sequence"
    )
    private Long spaServiceCatalogId;
    private String serviceName;
    private Integer duration;
    private double price;
    private double commission;
    @OneToMany(mappedBy = "spaServiceCatalog")
    private Set<SpaService> services;

    public SpaServiceCatalog(Long spaServiceCatalogId, String serviceName, Integer duration, double price, double commission) {
        this.spaServiceCatalogId = spaServiceCatalogId;
        this.serviceName = serviceName;
        this.duration = duration;
        this.price = price;
        this.commission = commission;
    }

    public SpaServiceCatalog(String serviceName, Integer duration, double price, double commission) {
        this.serviceName = serviceName;
        this.duration = duration;
        this.price = price;
        this.commission = commission;
    }

    public SpaServiceCatalog() {

    }

    public Long getSpaServiceCatalogId() {
        return spaServiceCatalogId;
    }

    public void setSpaServiceCatalogId(Long spaServiceCatalogId) {
        this.spaServiceCatalogId = spaServiceCatalogId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getCommission() {
        return commission;
    }

    public void setCommission(double commission) {
        this.commission = commission;
    }

    @Override
    public String toString() {
        return "SpaServiceCatalog{" +
                "spaServiceCatalogId=" + spaServiceCatalogId +
                ", serviceName='" + serviceName + '\'' +
                ", duration=" + duration +
                ", price=" + price +
                ", commission=" + commission +
                '}';
    }

}
