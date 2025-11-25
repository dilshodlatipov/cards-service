package com.example.cardsservice.domain;

import com.example.cardsservice.domain.enums.CardCategory;
import com.example.cardsservice.domain.enums.CardNetwork;
import com.example.cardsservice.domain.value.Account;
import com.example.cardsservice.domain.value.ProductFees;
import com.example.cardsservice.domain.value.ProductLimits;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.*;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product extends BaseIdentity {
    private String name;
    private Account account;
    private CardCategory category;
    private CardNetwork network;
    private String currency;
    private Long binRange;
    private ProductLimits limits;
    private ProductFees fees;
    private Boolean isActive;
}
