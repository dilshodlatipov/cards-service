package com.example.cardsservice.service.impl;

import com.example.cardsservice.common.Constants;
import com.example.cardsservice.domain.Card;
import com.example.cardsservice.domain.Product;
import com.example.cardsservice.domain.enums.ProductStatusEnum;
import com.example.cardsservice.dto.*;
import com.example.cardsservice.mapper.CardMapper;
import com.example.cardsservice.repository.CardRepository;
import com.example.cardsservice.security.CurrentUser;
import com.example.cardsservice.service.CardService;
import com.example.cardsservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * Created by dilshodlatipov748@gmail.com on 26/11/2025
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {
    private final CardRepository cardRepository;
    private final CardMapper cardMapper;
    private final ProductService productService;

    @Override
    public List<CardDto> get(CurrentUser currentUser) {
        log.info("CardServiceImpl.get(List<CardDto>): {}", currentUser);
        return List.of();
    }

    @Override
    public CardDto get(CurrentUser currentUser, UUID cardId) {
        return null;
    }

    @Override
    public CardDto issue(CurrentUser currentUser, CardAddDto request) {
        Product product = productService.lookUpProduct(currentUser, request);

        productService.checkForCardIssuing(product);


        return null;
    }

    @Override
    public CardDto updateCardLimits(CurrentUser currentUser, CardLimitsUpdateDto request) {
        return null;
    }

    @Override
    public CardDto updateCardControls(CurrentUser currentUser, CardControlsUpdateDto request) {
        return null;
    }

    @Override
    public CardDto block(CurrentUser currentUser, UUID cardId) {
        return null;
    }

    @Override
    public CardDto unblock(CurrentUser currentUser, UUID cardId) {
        return null;
    }

    @Override
    public CardDto resetPin(CurrentUser currentUser, UUID cardId, ResetPinDto request) {
        return null;
    }
}
