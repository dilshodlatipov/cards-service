package com.example.cardsservice.web;

import com.example.cardsservice.common.Constants;
import com.example.cardsservice.domain.enums.ProductType;
import com.example.cardsservice.domain.enums.Currency;
import com.example.cardsservice.dto.PaginationDto;
import com.example.cardsservice.dto.ProductDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping(ProductController.BASE_PATH)
public interface ProductController {
    String BASE_PATH = Constants.BASE_URL + "/product";
    String PRODUCT_LIST = "/list";
    String ACTIVATE = "/activate";
    String SUSPEND = "/suspend";
    String BLOCK = "/block";

    @GetMapping(PRODUCT_LIST)
    ResponseEntity<PaginationDto<List<ProductDto>>> get(@RequestParam(name = "productType", required = false) ProductType productType,
                                                        @RequestParam(name = "currency", required = false) Currency currency,
                                                        @RequestParam(name = "page", defaultValue = Constants.DEFAULT_PAGE) Integer page,
                                                        @RequestParam(name = "size", defaultValue = Constants.DEFAULT_SIZE) Integer size);

    @GetMapping("/{productId}")
    ResponseEntity<ProductDto> get(@PathVariable UUID productId);

    @PutMapping(ACTIVATE + "/{productId}")
    ResponseEntity<Boolean> activate(@PathVariable UUID productId);

    @PutMapping(SUSPEND + "/{productId}")
    ResponseEntity<Boolean> suspend(@PathVariable UUID productId);

    @PutMapping(BLOCK + "/{productId}")
    ResponseEntity<Boolean> block(@PathVariable UUID productId);

    @DeleteMapping("/{productId}")
    ResponseEntity<Boolean> delete(@PathVariable UUID productId);


}
