package com.example.cardsservice.service.impl;

import com.example.cardsservice.domain.Product;
import com.example.cardsservice.domain.enums.CardCategory;
import com.example.cardsservice.domain.enums.CardNetwork;
import com.example.cardsservice.domain.enums.Currency;
import com.example.cardsservice.domain.enums.ProductStatusEnum;
import com.example.cardsservice.domain.value.Account;
import com.example.cardsservice.dto.CardAddDto;
import com.example.cardsservice.dto.PaginationDto;
import com.example.cardsservice.dto.ProductDto;
import com.example.cardsservice.repository.ProductRepository;
import com.example.cardsservice.security.CurrentUser;
import com.example.cardsservice.service.CardService;
import com.example.cardsservice.service.ProductService;
import com.example.cardsservice.web.error.CustomException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * Created by dilshodlatipov748@gmail.com on 26/11/2025
 */
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final CardService cardService;

    @Override
    public PaginationDto<List<ProductDto>> get(CardCategory category, CardNetwork network, Currency currency, Integer page, Integer size) {
        return null;
    }

    @Override
    public ProductDto get(UUID productId) {
        return null;
    }

    @Override
    public Boolean activate(UUID productId) {
        return null;
    }

    @Override
    public Boolean suspend(UUID productId) {
        return null;
    }

    @Override
    public Boolean block(UUID productId) {
        return null;
    }

    @Override
    public Boolean delete(UUID productId) {
        return null;
    }

    @Override
    @Transactional
    public Product lookUpProduct(CurrentUser currentUser, CardAddDto request) {
        Product product = productRepository.findByUserIdAndCategoryAndNetworkAndCurrency(currentUser.getId(), request.getCategory(), request.getNetwork(), request.getCurrency())
                .orElseGet(() -> {
                    return Product.builder()
                            .userId(currentUser.getId())
                            .account(Account.builder()
                                    .currency(request.getCurrency())
                                    .volume(0.00)
                                    .build())
                            .category(request.getCategory())
                            .network(request.getNetwork())
                            .currency(request.getCurrency())
                            .status(ProductStatusEnum.CREATED)
                            .build();
                });

        return productRepository.save(product);
    }

    @Override
    public void checkForCardIssuing(Product product) {
        if (Objects.equals(product.getStatus(), ProductStatusEnum.SUSPENDED))
            throw CustomException.throwEx("This product has been suspended");

        if (Objects.equals(product.getStatus(), ProductStatusEnum.BLOCKED))
            throw CustomException.throwEx("This product has been blocked");
    }
}
