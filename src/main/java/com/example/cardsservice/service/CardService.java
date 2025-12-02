package com.example.cardsservice.service;

import com.example.cardsservice.dto.*;
import com.example.cardsservice.security.CurrentUser;

import java.util.List;
import java.util.UUID;

/**
 * Created by dilshodlatipov748@gmail.com on 25/11/2025
 */
public interface CardService {
    List<CardDto> get(CurrentUser currentUser);

    CardDto get(CurrentUser currentUser, UUID cardId);

    CardDto issue(CurrentUser currentUser, CardAddDto request);

    CardDto updateCardLimits(CurrentUser currentUser, CardLimitsUpdateDto request);

    CardDto updateCardControls(CurrentUser currentUser, CardControlsUpdateDto request);

    CardDto block(CurrentUser currentUser, UUID cardId);

    CardDto unblock(CurrentUser currentUser, UUID cardId);

    CardDto resetPin(CurrentUser currentUser, UUID cardId, ResetPinDto request);
}
