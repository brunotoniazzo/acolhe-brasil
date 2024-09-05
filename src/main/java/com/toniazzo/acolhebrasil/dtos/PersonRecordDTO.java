package com.toniazzo.acolhebrasil.dtos;

import com.toniazzo.acolhebrasil.models.enums.FamilyHelper;
import com.toniazzo.acolhebrasil.models.enums.Gender;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

public record PersonRecordDTO(String name,
                              String socialName,
                              Gender gender,
                              String cpf,
                              String rg,
                              LocalDate dateOfBirth,
                              String email,
                              String phoneNumber,
                              String observation,
                              FamilyHelper familyHelper,
                              Set<UUID> addressId,
                              UUID shelterId,
                              UUID familyId) {


}
