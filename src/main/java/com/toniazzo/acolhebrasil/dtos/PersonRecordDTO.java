package com.toniazzo.acolhebrasil.dtos;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

public record PersonRecordDTO(String name,
                              String socialName,
                              Enum gender,
                              String cpf,
                              String rg,
                              LocalDate dateOfBirth,
                              String email,
                              String phoneNumber,
                              String observation,
                              Enum familyHelper,
                              Set<UUID> addressId,
                              UUID shelterId,
                              UUID familyId) {


}
