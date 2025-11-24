package com.example.cardsservice.domain.value;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductFees {
    private Float annualFee;
    private Float issuanceFee;
    private Float reissueFee;
    private Float replacementFee;
    private Float withdrawalFeeDomestic;
    private Float withdrawalFeeInternational;
    private Float fxFeePercent;
}
