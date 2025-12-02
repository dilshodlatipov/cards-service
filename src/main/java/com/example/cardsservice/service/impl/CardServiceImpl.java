package com.example.cardsservice.service.impl;

import com.example.cardsservice.common.CommonUtils;
import com.example.cardsservice.common.Constants;
import com.example.cardsservice.common.PanGenerator;
import com.example.cardsservice.common.RsaCryptoUtil;
import com.example.cardsservice.domain.Card;
import com.example.cardsservice.domain.Product;
import com.example.cardsservice.domain.enums.CardStatusEnum;
import com.example.cardsservice.domain.value.CardControls;
import com.example.cardsservice.domain.value.CardLimits;
import com.example.cardsservice.dto.*;
import com.example.cardsservice.mapper.CardMapper;
import com.example.cardsservice.repository.CardRepository;
import com.example.cardsservice.security.CurrentUser;
import com.example.cardsservice.service.CardService;
import com.example.cardsservice.service.ProductService;
import com.example.cardsservice.web.advice.CustomException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
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
    private final RsaCryptoUtil cryptoUtil;

    @Override
    public List<CardDto> get(CurrentUser currentUser) {
        log.info("CardServiceImpl.get(List<CardDto>): {}", currentUser);

        List<Card> cards = cardRepository.findAllByProduct_UserIdAndCurrentTrueAndDeletedFalse(currentUser.getId());
        return cardMapper.toDto(cards);
    }

    @Override
    public CardDto get(CurrentUser currentUser, UUID cardId) {
        log.info("CardServiceImpl.get(CardDto, UUID): {}", currentUser);

        Card card = cardRepository.findByProduct_UserIdAndIdAndDeletedFalse(currentUser.getId(), cardId)
                .orElseThrow(() -> CustomException.throwEx("Card with id " + cardId + " not found", HttpStatus.NOT_FOUND));
        return cardMapper.toDto(card);
    }

    @Override
    public CardDto issue(CurrentUser currentUser, CardAddDto request) {
        log.info("CardServiceImpl.issue(CurrentUser, CardAddDto): currentUser = {}, request = {} ", currentUser, request);

        Product product = productService.lookUpProduct(currentUser, request);

        productService.checkForCardIssuing(product);

        Optional<Card> optionalCard = cardRepository.findFirstByProduct_UserIdOrderByCreatedAtDesc(currentUser.getId());

        optionalCard.ifPresent(card -> {
            card.setStatus(CardStatusEnum.REPLACED);
            card.setCurrent(false);
            cardRepository.save(card);
        });


        LocalDateTime issuedAt = LocalDateTime.now();
        String formattedExpireDate = issuedAt.withDayOfMonth(1)
                .withHour(0)
                .withMinute(0)
                .withSecond(0)
                .withNano(0)
                .plus(Duration.ofDays(365 * 5)).format(CommonUtils.formatter);
        String cvv = "" + (CommonUtils.random.nextInt(900) + 100);

        boolean panGenerated = false;
        String pan = "";
        while (!panGenerated) {
            pan = PanGenerator.generatePan(product.getProductType().getBinRange());

            panGenerated = cardRepository.existsByPanAndDeletedFalse(cryptoUtil.encrypt(pan));
        }
        String maskedPan = maskPan(pan);

        Card card = Card.builder()
                .product(product)
                .issuedAt(issuedAt)
                .expireDate(formattedExpireDate)
                .cardControls(Constants.defaultCardControls)
                .cardLimits(Constants.defaultCardLimits)
                .cvv(cvv)
                .pan(pan)
                .maskedPan(maskedPan)
                .current(true)
                .build();

        card = cardRepository.save(card);
        return cardMapper.toDto(card);
    }

    @Override
    public CardDto updateCardLimits(CurrentUser currentUser, CardLimitsUpdateDto request) {
        Card card = cardRepository.findFirstByProduct_UserIdOrderByCreatedAtDesc(currentUser.getId())
                .orElseThrow(() -> CustomException.throwEx("User does not have any cards"));

        CardLimits cardLimits = card.getCardLimits();
        cardLimits.setOnlineLimit(Objects.requireNonNullElse(request.getOnlineLimit(), cardLimits.getOnlineLimit()));
        cardLimits.setDailyAtmLimit(Objects.requireNonNullElse(request.getDailyAtmLimit(), cardLimits.getDailyAtmLimit()));
        cardLimits.setDailyPosLimit(Objects.requireNonNullElse(request.getDailyPosLimit(), cardLimits.getDailyPosLimit()));
        cardLimits.setMaxTransactionsPerDay(Objects.requireNonNullElse(request.getMaxTransactionsPerDay(), cardLimits.getMaxTransactionsPerDay()));

        card.setCardLimits(cardLimits);
        cardRepository.save(card);

        return cardMapper.toDto(card);
    }

    @Override
    public CardDto updateCardControls(CurrentUser currentUser, CardControlsUpdateDto request) {
        Card card = cardRepository.findFirstByProduct_UserIdOrderByCreatedAtDesc(currentUser.getId())
                .orElseThrow(() -> CustomException.throwEx("User does not have any cards"));

        CardControls cardControls = card.getCardControls();
        cardControls.setAtmEnabled(Objects.requireNonNullElse(request.getAtmEnabled(), cardControls.getAtmEnabled()));
        cardControls.setContactlessEnabled(Objects.requireNonNullElse(request.getContactlessEnabled(), cardControls.getContactlessEnabled()));
        cardControls.setOnlinePaymentEnabled(Objects.requireNonNullElse(request.getOnlinePaymentEnabled(), cardControls.getOnlinePaymentEnabled()));

        card.setCardControls(cardControls);
        cardRepository.save(card);

        return cardMapper.toDto(card);
    }

    @Override
    public CardDto block(CurrentUser currentUser, UUID cardId) {
        log.info("CardServiceImpl.block(CurrentUser, UUID): currentUser = {}, cardId = {}", currentUser, cardId);

        Card card = cardRepository.findByProduct_UserIdAndIdAndDeletedFalse(currentUser.getId(), cardId)
                .orElseThrow(() -> CustomException.throwEx("Card with id " + cardId + " not found", HttpStatus.NOT_FOUND));

        card.setStatus(CardStatusEnum.BLOCKED_TEMPORARY);
        card = cardRepository.save(card);
        return cardMapper.toDto(card);
    }

    @Override
    public CardDto unblock(CurrentUser currentUser, UUID cardId) {
        log.info("CardServiceImpl.unblock(CurrentUser, UUID): currentUser = {}, cardId = {}", currentUser, cardId);

        Card card = cardRepository.findByProduct_UserIdAndIdAndDeletedFalse(currentUser.getId(), cardId)
                .orElseThrow(() -> CustomException.throwEx("Card with id " + cardId + " not found", HttpStatus.NOT_FOUND));

        card.setStatus(CardStatusEnum.ACTIVE);
        card = cardRepository.save(card);
        return cardMapper.toDto(card);
    }

    @Override
    public CardDto resetPin(CurrentUser currentUser, UUID cardId, ResetPinDto request) {
        Card card = cardRepository.findByProduct_UserIdAndIdAndDeletedFalse(currentUser.getId(), cardId)
                .orElseThrow(() -> CustomException.throwEx("Card with id " + cardId + " not found", HttpStatus.NOT_FOUND));

        if (!Objects.equals(request.getPin(), request.getConfirmPin()))
            throw CustomException.throwEx("Pins do not match");

        card.setPin(request.getPin() + "");
        cardRepository.save(card);

        return cardMapper.toDto(card);
    }


    private String maskPan(String pan) {
        return pan.substring(0, 4) +
                "********" +
                pan.substring(pan.length() - 4);
    }

}
