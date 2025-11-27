package com.example.cardsservice.web;

import com.example.cardsservice.common.Constants;
import org.springframework.web.bind.annotation.*;

@RequestMapping(ProductController.BASE_PATH)
public interface ProductController {
    String BASE_PATH = Constants.BASE_URL + "/product";


}
