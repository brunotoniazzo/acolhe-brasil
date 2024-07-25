package com.toniazzo.acolhebrasil.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.toniazzo.acolhebrasil.models.enums.State;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "Address")
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

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToMany(mappedBy = "address", fetch = FetchType.LAZY)
    private Set<Person> person = new HashSet<>();

    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
    @OneToMany(mappedBy = "address", fetch = FetchType.LAZY)
    private Set<Family> family = new HashSet<>();

    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
    @OneToMany(mappedBy = "address", fetch = FetchType.LAZY)
    private Set<Shelter> shelter = new HashSet<>();

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNeighbourhood() {
        return neighbourhood;
    }

    public void setNeighbourhood(String neighbourhood) {
        this.neighbourhood = neighbourhood;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(Integer houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getExtraDescription() {
        return extraDescription;
    }

    public void setExtraDescription(String extraDescription) {
        this.extraDescription = extraDescription;
    }

    public Set<Person> getPerson() {
        return person;
    }

    public void setPerson(Set<Person> person) {
        this.person = person;
    }

    public Set<Family> getFamily() {
        return family;
    }

    public void setFamily(Set<Family> family) {
        this.family = family;
    }

    public Set<Shelter> getShelter() {
        return shelter;
    }

    public void setShelter(Set<Shelter> shelter) {
        this.shelter = shelter;
    }
}