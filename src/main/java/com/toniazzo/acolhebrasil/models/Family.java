package com.toniazzo.acolhebrasil.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "Family")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Family implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String familyName;

    @Column(precision = 2)
    private Integer members;

    @ManyToOne
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;


    @ManyToOne
    @JoinColumn(name = "family_address_id", nullable = false)
    private Address familyAddress;

}
