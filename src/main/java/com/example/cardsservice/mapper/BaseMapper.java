package com.example.cardsservice.mapper;

import java.util.List;

/**
 * Created by dilshodlatipov748@gmail.com on 26/11/2025
 */
public interface BaseMapper<E, D> {
    E toEntity(D dto);
    D toDto(E entity);
    List<E> toEntity(List<D> dtos);
    List<D> toDto(List<E> entities);
}
