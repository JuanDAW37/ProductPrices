package com.products.ZaraProducts.exceptions;

import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message){
        super(message);
    }

    public String getMessage(){
        return super.getMessage();
    }
}
