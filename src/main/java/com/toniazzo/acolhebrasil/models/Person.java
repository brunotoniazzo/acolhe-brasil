package com.toniazzo.acolhebrasil.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.toniazzo.acolhebrasil.models.enums.FamilyHelper;
import com.toniazzo.acolhebrasil.models.enums.Gender;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "Person")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Person implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false)
    private String name;

    private String socialName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;

    @Column(nullable = false, unique = true, length = 11)
    private String cpf;

    @Column(unique = true, length = 9)
    private String rg;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(nullable = false)
    private LocalDate dateOfBirth;

    private String email;

    private String phoneNumber;

    private String observation;

    @Enumerated(EnumType.STRING)
    private FamilyHelper familyHelper;
//
//    private final Integer age = calculateAge(dateOfBirth, LocalDate.now());
//
//    public static int calculateAge(LocalDate dateOfBirth, LocalDate currentDate) {
//        Period period = Period.between(dateOfBirth, currentDate);
//        return period.getYears();
//    }

    @ManyToMany
    @JoinTable(
            name = "table_person_address",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "address_id")
    )
    private Set<Address> address = new HashSet<>();

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToOne
    @JoinColumn(name = "shelter_id")
    private Shelter shelter;

    @ManyToOne
    @JoinColumn(name = "family_id")
    private Family family;
}
