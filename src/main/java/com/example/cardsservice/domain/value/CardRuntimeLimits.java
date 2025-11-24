package com.example.cardsservice.domain.value;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CardRuntimeLimits {
    private Double dailyAtmLimit;
    private Double dailyPosLimit;
    private Double onlineLimit;
    private Integer maxTransactionsPerDay;
}
