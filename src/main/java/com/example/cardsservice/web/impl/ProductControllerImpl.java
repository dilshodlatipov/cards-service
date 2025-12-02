package com.example.cardsservice.web.impl;

import com.example.cardsservice.domain.enums.ProductType;
import com.example.cardsservice.domain.enums.Currency;
import com.example.cardsservice.dto.PaginationDto;
import com.example.cardsservice.dto.ProductDto;
import com.example.cardsservice.service.ProductService;
import com.example.cardsservice.web.ProductController;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class ProductControllerImpl implements ProductController {
    private final ProductService productService;

    @Override
    public ResponseEntity<PaginationDto<List<ProductDto>>> get(ProductType productType, Currency currency, Integer page, Integer size) {
        return ResponseEntity.ok(
                productService.get(productType, currency, page, size)
        );
    }

    @Override
    public ResponseEntity<ProductDto> get(UUID productId) {
        return ResponseEntity.ok(productService.get(productId));
    }

    @Override
    public ResponseEntity<Boolean> activate(UUID productId) {
        return ResponseEntity.ok(productService.activate(productId));
    }

    @Override
    public ResponseEntity<Boolean> suspend(UUID productId) {
        return ResponseEntity.ok(productService.suspend(productId));
    }

    @Override
    public ResponseEntity<Boolean> block(UUID productId) {
        return ResponseEntity.ok(productService.block(productId));
    }

    @Override
    public ResponseEntity<Boolean> delete(UUID productId) {
        return ResponseEntity.ok(productService.delete(productId));
    }
}
