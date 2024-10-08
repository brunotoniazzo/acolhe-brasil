package com.toniazzo.acolhebrasil.repositories;

import com.toniazzo.acolhebrasil.dtos.PersonRecordDTO;
import com.toniazzo.acolhebrasil.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PersonRepository extends JpaRepository<Person, UUID> {
    Person findById(PersonRecordDTO id);

    Person deleteById(PersonRecordDTO id);
}