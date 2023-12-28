package com.nomadspa.backend.SpaService;
import java.time.LocalDateTime;
public class SpaServiceDTO {
    private Long customerId;
    private Long therapistId;
    private Long spaServiceCatalogId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String paymentMethod;
    private double cardPayment;
    private double cashPayment;
    private double memberShipPayment;



    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getTherapistId() {
        return therapistId;
    }

    public void setTherapistId(Long therapistId) {
        this.therapistId = therapistId;
    }

    public Long getSpaServiceCatalogId() {
        return spaServiceCatalogId;
    }

    public void setSpaServiceCatalogId(Long spaServiceCatalogId) {
        this.spaServiceCatalogId = spaServiceCatalogId;
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

    public double getCardPayment() {
        return cardPayment;
    }

    public void setCardPayment(double cardPayment) {
        this.cardPayment = cardPayment;
    }

    public double getCashPayment() {
        return cashPayment;
    }

    public void setCashPayment(double cashPayment) {
        this.cashPayment = cashPayment;
    }

    public double getMemberShipPayment() {
        return memberShipPayment;
    }

    public void setMemberShipPayment(double memberShipPayment) {
        this.memberShipPayment = memberShipPayment;
    }

}
