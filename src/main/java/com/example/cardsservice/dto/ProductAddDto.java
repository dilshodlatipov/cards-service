package com.example.cardsservice.dto;

import com.example.cardsservice.domain.enums.CardCategory;
import com.example.cardsservice.domain.enums.CardNetwork;
import com.example.cardsservice.domain.enums.Currency;

public class ProductAddDto {
    private CardCategory category;
    private CardNetwork cardNetwork;
    private Currency currency;
}
