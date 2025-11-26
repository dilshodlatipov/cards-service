package com.example.cardsservice.domain;


import com.example.cardsservice.domain.enums.CardCategory;
import com.example.cardsservice.domain.enums.CardNetwork;
import com.example.cardsservice.domain.value.Account;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;

import static org.hibernate.type.SqlTypes.JSON;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product extends BaseIdentity {
    private String name;

    @JdbcTypeCode(JSON)
    private Account account;

    @Enumerated(EnumType.STRING)
    private CardCategory category;

    @Enumerated(EnumType.STRING)
    private CardNetwork network;

    @Column(nullable = false)
    private String currency;

    private Long binRange;

    private Boolean isActive;
}
