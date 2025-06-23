package com.vw.customException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class OwnerDetailsNotFoundException extends RuntimeException {
    public OwnerDetailsNotFoundException(String message){
        super(message);
    }
}
