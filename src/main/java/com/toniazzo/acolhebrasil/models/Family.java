package com.toniazzo.acolhebrasil.models;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.*;

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

    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
    @OneToMany(mappedBy = "family", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Person> persons = new HashSet<>();

    @OneToOne(mappedBy = "family")
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;

    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
    @OneToMany(mappedBy = "family", fetch = FetchType.LAZY)
    private Set<Donation> donation = new HashSet<>();

}
