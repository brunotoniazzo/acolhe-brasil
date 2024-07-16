package com.toniazzo.acolhebrasil.models;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "Shelter")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Shelter implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, unique = false)
    private String name;

    @OneToOne
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;

    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
    @OneToMany(mappedBy = "shelter", fetch = FetchType.LAZY)
    private Set<Person> person = new HashSet<>();
}
