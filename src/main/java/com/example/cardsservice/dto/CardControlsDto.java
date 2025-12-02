package com.example.cardsservice.dto;

import lombok.*;

/**
 * Created by dilshodlatipov748@gmail.com on 01/12/2025
 */
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class CardControlsDto {
    private Boolean onlinePaymentEnabled;
    private Boolean contactlessEnabled;
    private Boolean atmEnabled;
}
