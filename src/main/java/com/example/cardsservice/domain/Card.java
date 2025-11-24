package com.example.cardsservice.domain;

import jakarta.persistence.Entity;
import lombok.*;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Card extends BaseIdentity {
}
