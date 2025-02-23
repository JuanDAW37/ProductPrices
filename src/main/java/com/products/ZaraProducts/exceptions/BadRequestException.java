package com.products.ZaraProducts.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseBody
@ResponseStatus(HttpStatus.NOT_FOUND)
public class BadRequestException extends RuntimeException {
        public BadRequestException(String message) {
            super(message);
        }

        public String getMessage(){return  super.getMessage();}
}
