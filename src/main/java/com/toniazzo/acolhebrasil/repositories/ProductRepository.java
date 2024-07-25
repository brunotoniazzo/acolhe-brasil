package com.toniazzo.acolhebrasil.repositories;

import com.toniazzo.acolhebrasil.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
}