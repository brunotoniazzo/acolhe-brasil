package com.toniazzo.acolhebrasil.services;

import com.toniazzo.acolhebrasil.dtos.PersonRecordDTO;
import com.toniazzo.acolhebrasil.models.Person;
import com.toniazzo.acolhebrasil.models.enums.FamilyHelper;
import com.toniazzo.acolhebrasil.models.enums.Gender;
import com.toniazzo.acolhebrasil.repositories.AddressRepository;
import com.toniazzo.acolhebrasil.repositories.FamilyRepository;
import com.toniazzo.acolhebrasil.repositories.PersonRepository;
import com.toniazzo.acolhebrasil.repositories.ShelterRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Transactional
    public Person savePerson(PersonRecordDTO personRecordDTO) {
        Person person = new Person();
        person.setName(personRecordDTO.name());
        person.setSocialName(personRecordDTO.socialName());
        person.setGender((Gender) personRecordDTO.gender());
        person.setCpf(personRecordDTO.cpf());
        person.setRg(personRecordDTO.rg());
        person.setDateOfBirth(personRecordDTO.dateOfBirth());
        person.setEmail(personRecordDTO.email());
        person.setPhoneNumber(personRecordDTO.phoneNumber());
        person.setObservation(personRecordDTO.observation());

        person.setFamilyHelper((FamilyHelper) personRecordDTO.familyHelper());
        person.setAddress(addressRepository.findAllById(personRecordDTO.addressId()).stream().collect(Collectors.toSet()));
        person.setShelter(shelterRepository.findById(personRecordDTO.shelterId()).get());
        person.setFamily(familyRepository.findById(personRecordDTO.familyId()).get());

        return personRepository.save(person);
    }

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public Person findPersonById(PersonRecordDTO id) {
        return personRepository.findById(id);
    }

    public Person deletePerson(PersonRecordDTO id) {
        return personRepository.deleteById(id);
    }
}
