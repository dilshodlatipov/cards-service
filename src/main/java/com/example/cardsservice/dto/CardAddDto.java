package com.example.cardsservice.dto;

import com.example.cardsservice.domain.enums.CardCategory;
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
    @NotNull(message = "Card network cannot be null")
    private CardNetwork network;
    @NotNull(message = "Card category cannot be null")
    private CardCategory category;
    @NotNull(message = "Card currency cannot be null")
    private Currency currency;
}
