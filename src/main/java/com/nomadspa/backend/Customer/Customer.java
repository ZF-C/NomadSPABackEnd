package com.nomadspa.backend.Customer;
import com.nomadspa.backend.SpaService.SpaService;
import jakarta.persistence.*;
import java.util.Set;
import java.security.Provider;
import java.time.LocalDate;

@Entity
@Table(name = "customer")
public class Customer {
    //根据therapist文件夹下的Therapist.java文件，创建Customer类
    @Id
    @SequenceGenerator(
            name = "customer_sequence",
            sequenceName = "customer_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator = "customer_sequence"
    )
    private Long customerId;
    private String name;
    private String phoneNumber;
    private String membershipId;

    @OneToMany(mappedBy = "customer")
    private Set<SpaService> services;

    public Customer(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public Customer(Long customerId, String name, String phoneNumber, String membershipId, LocalDate dob) {
        this.customerId = customerId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.membershipId = membershipId;
    }

    public Customer(String name, String phoneNumber, String membershipId) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.membershipId = membershipId;
    }

    public Customer() {

    }

    public Long getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getMembershipId() {
        return membershipId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setMembershipId(String membershipId) {
        this.membershipId = membershipId;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", membershipId=" + membershipId +
                '}';
    }
}
