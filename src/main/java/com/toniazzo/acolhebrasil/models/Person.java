package com.toniazzo.acolhebrasil.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "Person")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Person implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String cpf;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(nullable = false)
    private LocalDate dateOfBirth;

    private final Integer age = calculateAge(dateOfBirth, LocalDate.now());

    public static int calculateAge(LocalDate dateOfBirth, LocalDate currentDate) {
        Period period = Period.between(dateOfBirth, currentDate);
        return period.getYears();
    }

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;
}
