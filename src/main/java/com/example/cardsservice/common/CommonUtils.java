package com.example.cardsservice.common;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.security.SecureRandom;
import java.time.format.DateTimeFormatter;
import java.util.Random;

/**
 * Created by dilshodlatipov748@gmail.com on 01/12/2025
 */
public interface CommonUtils {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/yy");

    Random random = new SecureRandom();

    ObjectMapper objectMapper = new ObjectMapper();
}
