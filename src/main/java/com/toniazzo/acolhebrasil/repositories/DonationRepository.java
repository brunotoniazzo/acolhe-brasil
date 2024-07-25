package com.toniazzo.acolhebrasil.repositories;

import com.toniazzo.acolhebrasil.models.Donation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DonationRepository extends JpaRepository<Donation, UUID> {
}