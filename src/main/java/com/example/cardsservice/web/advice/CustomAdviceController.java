package com.example.cardsservice.web.advice;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RequiredArgsConstructor
@RestControllerAdvice
@Order(value = Integer.MIN_VALUE)
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CustomAdviceController {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ErrorDto> handleException(CustomException ex) {
        log.error("CustomAdviceController.handleException(CustomException)", ex);

        return new ResponseEntity<>(ErrorDto.builder()
                .code(ex.getHttpStatus().value())
                .message(ex.getMessage())
                .build(), ex.getHttpStatus());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDto> handleException(Exception ex) {
        log.error("CustomAdviceController.handleException(Exception)", ex);

        return new ResponseEntity<>(ErrorDto.builder()
                .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .message(ex.getMessage())
                .build(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
