package com.example.cardsservice.repository;

import com.example.cardsservice.domain.Card;
import com.example.cardsservice.domain.enums.CardStatusEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Created by dilshodlatipov748@gmail.com on 25/11/2025
 */
@Repository
public interface CardRepository extends JpaRepository<Card, UUID> {
    List<Card> findAllByProduct_UserIdAndCurrentTrueAndDeletedFalse(UUID userId);

    Optional<Card> findByProduct_UserIdAndIdAndDeletedFalse(UUID userid, UUID cardId);

    Optional<Card> findFirstByProduct_UserIdOrderByCreatedAtDesc(UUID userid);

    boolean existsByPanAndDeletedFalse(String pan);
}
