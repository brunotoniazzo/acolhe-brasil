package com.toniazzo.acolhebrasil.repositories;

import com.toniazzo.acolhebrasil.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AddressRepository extends JpaRepository<Address, UUID> {
}