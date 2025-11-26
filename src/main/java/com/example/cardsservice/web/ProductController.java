package com.example.cardsservice.web;

import com.example.cardsservice.common.Constants;
import com.example.cardsservice.dto.ProductAddDto;
import com.example.cardsservice.dto.ProductDto;
import com.example.cardsservice.dto.ProductUpdateDto;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping(ProductController.BASE_PATH)
public interface ProductController {
    String BASE_PATH = Constants.BASE_URL + "/product";

    @GetMapping
    @PreAuthorize("PRODUCT_GET")
    ResponseEntity<List<ProductDto>> get(@AuthenticationPrincipal UserDetails userDetails);

    @PostMapping
    @PreAuthorize("PRODUCT_ADD")
    ResponseEntity<ProductDto> add(@AuthenticationPrincipal UserDetails userDetails, ProductAddDto request);

    @PutMapping("/{productId}")
    @PreAuthorize("PRODUCT_UPDATE")
    ResponseEntity<ProductDto> update(@PathVariable UUID productId, ProductUpdateDto request);

    @DeleteMapping
    @PreAuthorize("PRODUCT_DELETE")
    ResponseEntity<Boolean> delete(@PathVariable UUID productId);
}
