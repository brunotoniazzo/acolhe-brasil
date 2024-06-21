package com.toniazzo.acolhebrasil.models;


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
import java.util.List;
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

    @Column(nullable = false)
    private Product product;

    @Column(nullable = false)
    private Integer quantity;

    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
    private final LocalDateTime donationDateTime = LocalDateTime.now(Clock.systemUTC().getZone());
}
