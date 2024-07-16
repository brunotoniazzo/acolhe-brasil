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
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "Product")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Product implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String name;

    private String description;

    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
    @OneToMany(mappedBy = "products", fetch = FetchType.LAZY)
    private Set<Donation> donations = new HashSet<>();
}
