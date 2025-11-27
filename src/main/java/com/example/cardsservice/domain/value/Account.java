package com.example.cardsservice.domain.value;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Account implements Serializable {
    private Float currency;
    private Double volume;
}

