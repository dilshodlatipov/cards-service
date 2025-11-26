package com.example.cardsservice.web.impl;

import com.example.cardsservice.dto.ProductAddDto;
import com.example.cardsservice.dto.ProductDto;
import com.example.cardsservice.dto.ProductUpdateDto;
import com.example.cardsservice.web.ProductController;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class ProductControllerImpl implements ProductController {
    @Override
    public ResponseEntity<List<ProductDto>> get(UserDetails userDetails) {
        return null;
    }

    @Override
    public ResponseEntity<ProductDto> add(UserDetails userDetails, ProductAddDto request) {
        return null;
    }

    @Override
    public ResponseEntity<ProductDto> update(UUID productId, ProductUpdateDto request) {
        return null;
    }

    @Override
    public ResponseEntity<Boolean> delete(UUID productId) {
        return null;
    }
}
