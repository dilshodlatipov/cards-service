package com.example.cardsservice.mapper;

import com.example.cardsservice.domain.Card;
import com.example.cardsservice.dto.CardDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

/**
 * Created by dilshodlatipov748@gmail.com on 25/11/2025
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CardMapper extends BaseMapper<Card, CardDto> {
}
