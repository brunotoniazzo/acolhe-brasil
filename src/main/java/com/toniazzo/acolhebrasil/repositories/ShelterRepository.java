package com.toniazzo.acolhebrasil.repositories;

import com.toniazzo.acolhebrasil.models.Shelter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ShelterRepository extends JpaRepository<Shelter, UUID> {
}