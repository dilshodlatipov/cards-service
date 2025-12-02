package com.example.cardsservice.repository;

import com.example.cardsservice.domain.Product;
import com.example.cardsservice.domain.enums.ProductType;
import com.example.cardsservice.domain.enums.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

/**
 * Created by dilshodlatipov748@gmail.com on 25/11/2025
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {
    Optional<Product> findByUserIdAndProductTypeAndCurrency(UUID userId, ProductType productType, Currency currency);
}
