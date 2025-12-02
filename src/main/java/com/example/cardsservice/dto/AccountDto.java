package com.example.cardsservice.dto;

import com.example.cardsservice.domain.enums.Currency;
import lombok.*;

/**
 * Created by dilshodlatipov748@gmail.com on 01/12/2025
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {
    private Currency currency;
    private Double volume;
}
