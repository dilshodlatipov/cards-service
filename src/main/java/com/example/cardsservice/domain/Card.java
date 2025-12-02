package com.example.cardsservice.domain;

import com.example.cardsservice.common.FieldEncryptionConverter;
import com.example.cardsservice.domain.enums.CardStatusEnum;
import com.example.cardsservice.domain.enums.PinStatus;
import com.example.cardsservice.domain.value.CardControls;
import com.example.cardsservice.domain.value.CardLimits;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.hibernate.type.SqlTypes.JSON;

@Setter
@Getter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Card extends BaseIdentity {
    @ManyToOne(optional = false)
    private Product product;

    @Convert(converter = FieldEncryptionConverter.class)
    private String pan;

    private String maskedPan;

    @Convert(converter = FieldEncryptionConverter.class)
    private String pin;

    @Convert(converter = FieldEncryptionConverter.class)
    private String cvv;

    @Convert(converter = FieldEncryptionConverter.class)
    private String expireDate;

    @Enumerated(EnumType.STRING)
    private CardStatusEnum status;

    private LocalDateTime issuedAt;

    @JdbcTypeCode(JSON)
    private CardControls cardControls;

    @JdbcTypeCode(JSON)
    private CardLimits cardLimits;

    @Enumerated(EnumType.STRING)
    private PinStatus pinStatus;

    private Boolean current;
}
