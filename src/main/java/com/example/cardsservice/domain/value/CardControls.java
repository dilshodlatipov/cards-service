package com.example.cardsservice.domain.value;


import com.example.cardsservice.domain.enums.CountryCodes;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CardControls {
    private Boolean onlinePaymentEnabled;
    private Boolean contactlessEnabled;
    private Boolean atmEnabled;
}
