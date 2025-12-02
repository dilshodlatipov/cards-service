package com.example.cardsservice.domain;


import com.example.cardsservice.domain.enums.ProductType;
import com.example.cardsservice.domain.enums.Currency;
import com.example.cardsservice.domain.enums.ProductStatusEnum;
import com.example.cardsservice.domain.value.Account;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;

import java.util.UUID;

import static org.hibernate.type.SqlTypes.JSON;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product extends BaseIdentity {
    private UUID userId;

    @JdbcTypeCode(JSON)
    private Account account;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ProductType productType;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Currency currency;

    private ProductStatusEnum status;
}
