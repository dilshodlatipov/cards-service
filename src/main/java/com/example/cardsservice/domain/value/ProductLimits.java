package com.example.cardsservice.domain.value;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductLimits {
    private Double dailyAtmLimits;
    private Double dailyPosLimits;
    private Double monthlyCreditLimit;
    private Double onlineLimit;
    private Double singleTransactionLimit;
}
