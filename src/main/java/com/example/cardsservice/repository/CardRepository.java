package com.example.cardsservice.repository;

import com.example.cardsservice.domain.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

/**
 * Created by dilshodlatipov748@gmail.com on 25/11/2025
 */
@Repository
public interface CardRepository extends JpaRepository<Card, UUID> {
    Optional<Card> findByProduct_IdAnd();
}
