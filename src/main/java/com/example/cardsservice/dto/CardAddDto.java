package com.example.cardsservice.dto;

import com.example.cardsservice.domain.enums.ProductType;
import com.example.cardsservice.domain.enums.CardNetwork;
import com.example.cardsservice.domain.enums.Currency;
import jakarta.validation.constraints.NotNull;
import lombok.*;

/**
 * Created by dilshodlatipov748@gmail.com on 27/11/2025
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CardAddDto {
    @NotNull(message = "Product type cannot be null")
    private ProductType productType;
    @NotNull(message = "Card currency cannot be null")
    private Currency currency;
}
