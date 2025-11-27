package com.example.cardsservice.service.impl;

import com.example.cardsservice.dto.*;
import com.example.cardsservice.mapper.CardMapper;
import com.example.cardsservice.repository.CardRepository;
import com.example.cardsservice.security.CurrentUser;
import com.example.cardsservice.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Created by dilshodlatipov748@gmail.com on 26/11/2025
 */
@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {
    private final CardRepository cardRepository;
    private final CardMapper cardMapper;

    @Override
    public CardDto issue(CurrentUser currentUser, CardAddDto request) {
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
