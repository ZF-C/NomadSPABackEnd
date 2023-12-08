package com.nomadspa.backend.Therapist;


import jakarta.persistence.*;

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
            strategy = GenerationType.SEQUENCE,
            generator = "therapist_sequence"
    )
    private Long id;
    private String name;
    private String phoneNumber;
    private LocalDate dob;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

