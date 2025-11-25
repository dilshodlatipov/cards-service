package com.example.cardsservice.domain.value;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    private Float currency;
    private Double volume;
}

