package com.example.shiva.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String streetName;
    private String houseNumber;
    private String zipCode;

    @OneToOne
    @JoinColumn(name = "employees_id")
    private Employees employees;
}
