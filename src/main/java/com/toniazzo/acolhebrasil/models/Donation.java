package com.toniazzo.acolhebrasil.models;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serial;
import java.io.Serializable;
import java.time.Clock;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "Donation")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Donation implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToMany(mappedBy = "donations", fetch = FetchType.LAZY)
    private Set<Product> products = new HashSet<>();

    @Column(nullable = false)
    private Integer quantity;

    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
    private final LocalDateTime donationDateTime = LocalDateTime.now(Clock.systemUTC().getZone());

    @ManyToOne
    @JoinColumn(name = "family_id")
    private Family family;
}
