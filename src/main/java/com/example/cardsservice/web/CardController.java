package com.example.cardsservice.web;

import com.example.cardsservice.common.Constants;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(CardController.BASE_PATH)
public interface CardController {
    String BASE_PATH = Constants.BASE_URL + "/card";
}
