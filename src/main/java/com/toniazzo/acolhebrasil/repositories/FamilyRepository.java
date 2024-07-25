package com.toniazzo.acolhebrasil.repositories;

import com.toniazzo.acolhebrasil.models.Family;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FamilyRepository extends JpaRepository<Family, UUID> {
}