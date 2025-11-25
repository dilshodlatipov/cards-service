package com.example.cardsservice.repository;

import com.example.cardsservice.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * Created by dilshodlatipov748@gmail.com on 25/11/2025
 */
public interface ProductRepository extends JpaRepository<Product, UUID> {
}
