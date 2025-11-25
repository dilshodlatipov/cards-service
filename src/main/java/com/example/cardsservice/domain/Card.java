package com.example.cardsservice.domain;

import com.example.cardsservice.domain.enums.CardStatusEnum;
import com.example.cardsservice.domain.enums.PinStatus;
import com.example.cardsservice.domain.value.CardControls;
import com.example.cardsservice.domain.value.CardRuntimeLimits;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Card extends BaseIdentity {
    private Product product;
    private String PAN;
    private String maskedPan;
    private LocalDate expireDate;
    @Enumerated(EnumType.STRING)
    private CardStatusEnum status;
    private LocalDateTime issuedAt;
    private CardControls cardControls;
    private CardRuntimeLimits cardLimits;
    @Enumerated(EnumType.STRING)
    private PinStatus pinStatus;
}
