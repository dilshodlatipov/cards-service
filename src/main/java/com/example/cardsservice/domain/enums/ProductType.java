package com.example.cardsservice.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ProductType {
    VISA_DEBIT("411111"),
    VISA_CREDIT("400000"),
    MASTERCARD_DEBIT("520000"),
    MASTERCARD_CREDIT("510000"),
    HUMO_DEBIT("986000"),
    HUMO_CREDIT("986010"),
    UZCARD_DEBIT("860000"),
    UZCARD_CREDIT("860010");

    private final String binRange;
}
