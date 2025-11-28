package com.example.cardsservice.web.impl;

import com.example.cardsservice.dto.*;
import com.example.cardsservice.security.CurrentUser;
import com.example.cardsservice.service.CardService;
import com.example.cardsservice.web.CardController;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

/**
 * Created by dilshodlatipov748@gmail.com on 25/11/2025
 */
@RestController
@RequiredArgsConstructor
public class CardControllerImpl implements CardController {
    private final CardService cardService;
    @Override
    public ResponseEntity<List<CardDto>> get(CurrentUser currentUser) {
        return ResponseEntity.ok(cardService.get(currentUser));
    }

    @Override
    public ResponseEntity<CardDto> get(CurrentUser currentUser, UUID cardId) {
        return ResponseEntity.ok(cardService.get(currentUser, cardId));
    }

    @Override
    public ResponseEntity<CardDto> issue(CurrentUser currentUser, CardAddDto request) {
        return ResponseEntity.ok(cardService.issue(currentUser, request));
    }

    @Override
    public ResponseEntity<CardDto> updateCardLimits(CurrentUser currentUser, CardLimitsUpdateDto request) {
        return ResponseEntity.ok(cardService.updateCardLimits(currentUser, request));
    }

    @Override
    public ResponseEntity<CardDto> updateCardControls(CurrentUser currentUser, CardControlsUpdateDto request) {
        return ResponseEntity.ok(cardService.updateCardControls(currentUser, request));
    }

    @Override
    public ResponseEntity<CardDto> block(CurrentUser currentUser, UUID cardId) {
        return ResponseEntity.ok(cardService.block(currentUser, cardId));
    }

    @Override
    public ResponseEntity<CardDto> unblock(CurrentUser currentUser, UUID cardId) {
        return ResponseEntity.ok(cardService.unblock(currentUser, cardId));
    }

    @Override
    public ResponseEntity<CardDto> resetPin(CurrentUser currentUser, UUID cardId, ResetPinDto request) {
        return ResponseEntity.ok(cardService.resetPin(currentUser, cardId, request));
    }
}
