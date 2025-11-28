package com.example.cardsservice.common;

import com.example.cardsservice.domain.value.CardControls;
import com.example.cardsservice.domain.value.CardLimits;
import org.springframework.http.HttpMethod;

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

    String[] OPEN_PAGES = {
            "/swagger-ui.html"
    };
    String DEFAULT_PAGE = "0";
    String DEFAULT_SIZE = "10";

    String VISA_CREDIT = "400000";
    String VISA_DEBIT = "411111";
    String MASTER_CREDIT = "510000";
    String MASTER_DEBIT = "520000";
    String UZCARD_DEBIT = "860000";
    String UZCARD_CREDIT = "860010";
    String HUMO_DEBIT = "986000";
    String HUMO_CREDIT = "986010";

}
