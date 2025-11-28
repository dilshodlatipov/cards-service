package com.example.cardsservice.web;

import com.example.cardsservice.common.Constants;
import com.example.cardsservice.dto.*;
import com.example.cardsservice.security.CurrentUser;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping(CardController.BASE_PATH)
public interface CardController {
    String BASE_PATH = Constants.BASE_URL + "/card";
    String CARD_ISSUE = "/issue";
    String CARD_LIMITS = "/limits";
    String CARD_CONTROLS = "/controls";
    String CARD_BLOCK = "/block";
    String CARD_UNBLOCK = "/unblock";
    String CARD_RESET_PIN = "/reset-pin";

    @GetMapping
    ResponseEntity<List<CardDto>> get(@AuthenticationPrincipal CurrentUser currentUser);

    @GetMapping("/{cardId}")
    ResponseEntity<CardDto> get(@AuthenticationPrincipal CurrentUser currentUser,
                                @PathVariable UUID cardId);

    @PostMapping(CARD_ISSUE)
    ResponseEntity<CardDto> issue(@AuthenticationPrincipal CurrentUser currentUser,
                                  @RequestBody @Valid CardAddDto request);

    @PutMapping(CARD_LIMITS)
    ResponseEntity<CardDto> updateCardLimits(@AuthenticationPrincipal CurrentUser currentUser,
                                             @RequestBody @Valid CardLimitsUpdateDto request);

    @PutMapping(CARD_CONTROLS)
    ResponseEntity<CardDto> updateCardControls(@AuthenticationPrincipal CurrentUser currentUser,
                                               @RequestBody @Valid CardControlsUpdateDto request);

    @PutMapping(CARD_BLOCK + "/{cardId}")
    ResponseEntity<CardDto> block(@AuthenticationPrincipal CurrentUser currentUser,
                                  @PathVariable UUID cardId);

    @PutMapping(CARD_UNBLOCK + "/{cardId}")
    ResponseEntity<CardDto> unblock(@AuthenticationPrincipal CurrentUser currentUser,
                                    @PathVariable UUID cardId);

    @PutMapping(CARD_RESET_PIN + "{/cardId}")
    ResponseEntity<CardDto> resetPin(@AuthenticationPrincipal CurrentUser currentUser,
                                     @PathVariable UUID cardId,
                                     @RequestBody @Valid ResetPinDto request);
}
