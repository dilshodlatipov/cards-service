package com.example.cardsservice.dto;

import lombok.*;
import org.springframework.data.domain.Page;

/**
 * Created by dilshodlatipov748@gmail.com on 28/11/2025
 */
@Getter
@Setter
@Builder(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PaginationDto<T> {
    private Integer totalElements;
    private Integer totalPages;
    private Integer page;
    private Integer size;
    private T data;

    public static <T> PaginationDto<T> build(Integer totalElements, Integer totalPages, Integer page, Integer size, T data) {
        return new PaginationDto<>(totalElements, totalPages, page, size, data);
    }
}
