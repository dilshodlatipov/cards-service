package com.example.cardsservice.web.error;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.http.HttpStatus;

/**
 * Created by dilshodlatipov748@gmail.com on 28/11/2025
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class CustomException extends RuntimeException {
    private HttpStatus httpStatus;

    private CustomException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public static CustomException throwEx(String message) {
        return new CustomException(message, HttpStatus.BAD_REQUEST);
    }

    public static CustomException throwEx(String message, HttpStatus httpStatus) {
        return new CustomException(message, httpStatus);
    }
}

