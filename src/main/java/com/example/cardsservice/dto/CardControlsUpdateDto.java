package com.example.cardsservice.dto;

import lombok.*;

/**
 * Created by dilshodlatipov748@gmail.com on 27/11/2025
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CardControlsUpdateDto {
    private Boolean onlinePaymentEnabled;
    private Boolean contactlessEnabled;
    private Boolean atmEnabled;
}
