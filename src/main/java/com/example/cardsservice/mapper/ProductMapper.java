package com.example.cardsservice.mapper;

import com.example.cardsservice.domain.Product;
import com.example.cardsservice.dto.ProductDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

/**
 * Created by dilshodlatipov748@gmail.com on 25/11/2025
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductMapper extends BaseMapper<Product, ProductDto> {
}
