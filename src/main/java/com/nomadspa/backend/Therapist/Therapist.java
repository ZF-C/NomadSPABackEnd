package com.nomadspa.backend.Therapist;


import com.nomadspa.backend.SpaService.SpaService;
import jakarta.persistence.*;
import java.util.Set;
import java.time.LocalDate;

@Entity
@Table
public class Therapist {
    @Id
    @SequenceGenerator(
            name = "therapist_sequence",
            sequenceName = "therapist_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator = "therapist_sequence"
    )
    private Long id;
    private String name;
    private String phoneNumber;
    private LocalDate dob;
    private Boolean activeOrNot;
    private Integer sequenceNumber;
    @OneToMany(mappedBy = "therapist")
    private Set<SpaService> services;


    public Therapist(Long id) {
        this.id = id;
    }

    public Therapist(Long id, String name, String phoneNumber, LocalDate dob) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.dob = dob;
    }

    public Therapist(String name, String phoneNumber, LocalDate dob) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.dob = dob;
    }




    public Therapist() {

    }

    public Long getTherapistId() {
        return id;
    }

    public void setTherapistId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Boolean getActiveOrNot() {
        return activeOrNot;
    }

    public void setActiveOrNot(Boolean activeOrNot) {
        this.activeOrNot = activeOrNot;
    }

    public Integer getSequenceNumber() {
        return sequenceNumber;
    }

    public void setSequenceNumber(Integer sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    @Override
    public String toString() {
        return "Therapist{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", dob=" + dob +
                '}';
    }


}

