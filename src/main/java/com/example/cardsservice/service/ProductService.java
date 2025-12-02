package com.example.cardsservice.service;

import com.example.cardsservice.domain.Product;
import com.example.cardsservice.domain.enums.ProductType;
import com.example.cardsservice.domain.enums.Currency;
import com.example.cardsservice.dto.CardAddDto;
import com.example.cardsservice.dto.PaginationDto;
import com.example.cardsservice.dto.ProductDto;
import com.example.cardsservice.security.CurrentUser;

import java.util.List;
import java.util.UUID;

/**
 * Created by dilshodlatipov748@gmail.com on 25/11/2025
 */
public interface ProductService {

    PaginationDto<List<ProductDto>> get(ProductType productType, Currency currency, Integer page, Integer size);

    ProductDto get(UUID productId);

    Boolean activate(UUID productId);

    Boolean suspend(UUID productId);

    Boolean block(UUID productId);

    Boolean delete(UUID productId);

    Product lookUpProduct(CurrentUser currentUser, CardAddDto request);

    void checkForCardIssuing(Product product);
}
