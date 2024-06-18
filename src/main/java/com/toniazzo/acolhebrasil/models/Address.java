package com.toniazzo.acolhebrasil.models;

import com.toniazzo.acolhebrasil.models.enums.State;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "address")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Address implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String postalCode;

    @Column(nullable = false)
    private State state;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String neighbourhood;

    @Column(nullable = false)
    private String street;

    private Integer houseNumber;

    private String complement;

    private String extraDescription;

}