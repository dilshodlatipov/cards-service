package com.example.cardsservice.dto;

import com.example.cardsservice.domain.enums.CardStatusEnum;
import lombok.*;

import java.util.UUID;

/**
 * Created by dilshodlatipov748@gmail.com on 26/11/2025
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CardDto {
    private String id;
    private String productId;
    private AccountDto account;
    private String pan;
    private String maskedPan;
    private UUID userId;
    private CardStatusEnum status;
    private CardControlsDto cardControls;
    private CardLimitsDto cardLimits;
}
