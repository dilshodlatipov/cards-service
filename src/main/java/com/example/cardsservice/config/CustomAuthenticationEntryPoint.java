package com.example.cardsservice.config;

import com.example.cardsservice.common.CommonUtils;
import com.example.cardsservice.web.advice.ErrorDto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException {
        log.error("Responding with unauthorized error. URL -  {}, Message - {}", httpServletRequest.getRequestURI(), e.getMessage());

        ErrorDto errorDto = ErrorDto.builder()
                .message(e.getMessage())
                .code(HttpStatus.UNAUTHORIZED.value())
                .build();

        httpServletResponse.getWriter().write(CommonUtils.objectMapper.writeValueAsString(errorDto));
        httpServletResponse.setStatus(HttpStatus.UNAUTHORIZED.value());
        httpServletResponse.setContentType("application/json");
    }

}
