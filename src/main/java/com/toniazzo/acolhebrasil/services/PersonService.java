package com.toniazzo.acolhebrasil.services;

import com.toniazzo.acolhebrasil.repositories.AddressRepository;
import com.toniazzo.acolhebrasil.repositories.FamilyRepository;
import com.toniazzo.acolhebrasil.repositories.PersonRepository;
import com.toniazzo.acolhebrasil.repositories.ShelterRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private final PersonRepository personRepository;
    private final AddressRepository addressRepository;
    private final ShelterRepository shelterRepository;
    private final FamilyRepository familyRepository;

    public PersonService(PersonRepository personRepository, AddressRepository addressRepository, ShelterRepository shelterRepository, FamilyRepository familyRepository) {
        this.personRepository = personRepository;
        this.addressRepository = addressRepository;
        this.shelterRepository = shelterRepository;
        this.familyRepository = familyRepository;
    }
}
