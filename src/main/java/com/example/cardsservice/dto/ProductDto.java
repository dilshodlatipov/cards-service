package com.example.cardsservice.dto;

import com.example.cardsservice.domain.enums.ProductType;
import com.example.cardsservice.domain.enums.Currency;
import com.example.cardsservice.domain.enums.ProductStatusEnum;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private UUID id;
    private UUID userId;
    private ProductType productType;
    private Currency currency;
    private AccountDto account;
    private ProductStatusEnum status;
}
