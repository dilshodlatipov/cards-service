package com.example.cardsservice.common;

import com.example.cardsservice.domain.value.CardControls;
import com.example.cardsservice.domain.value.CardLimits;

public interface Constants {
    String BASE_URL = "/api/v1";

    CardLimits defaultCardLimits = CardLimits.builder()
            .dailyAtmLimit(1_000_000.00)
            .dailyPosLimit(2_000_000.00)
            .onlineLimit(1_000_000.00)
            .maxTransactionsPerDay(1000)
            .build();

    CardControls defaultCardControls = CardControls.builder()
            .atmEnabled(true)
            .contactlessEnabled(true)
            .onlinePaymentEnabled(true)
            .build();
}
