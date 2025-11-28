package com.example.cardsservice.domain.value;

import com.example.cardsservice.domain.enums.Currency;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Account implements Serializable {
    private Currency currency;
    private Double volume;
}

