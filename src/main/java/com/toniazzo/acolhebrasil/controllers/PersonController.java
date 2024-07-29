package com.toniazzo.acolhebrasil.controllers;

import com.toniazzo.acolhebrasil.dtos.PersonRecordDTO;
import com.toniazzo.acolhebrasil.models.Person;
import com.toniazzo.acolhebrasil.services.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public ResponseEntity<Person> savePerson(@RequestBody PersonRecordDTO personRecordDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(personService.savePerson(personRecordDTO));
    }
}
