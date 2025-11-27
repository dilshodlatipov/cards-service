package com.example.cardsservice.domain.value;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CardLimits implements Serializable {
    private Double dailyAtmLimit;
    private Double dailyPosLimit;
    private Double onlineLimit;
    private Integer maxTransactionsPerDay;
}
