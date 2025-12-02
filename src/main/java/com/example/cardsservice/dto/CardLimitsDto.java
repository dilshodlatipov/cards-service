package com.example.cardsservice.dto;

import lombok.*;

/**
 * Created by dilshodlatipov748@gmail.com on 01/12/2025
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CardLimitsDto {
    private Double dailyAtmLimit;
    private Double dailyPosLimit;
    private Double onlineLimit;
    private Integer maxTransactionsPerDay;
}
