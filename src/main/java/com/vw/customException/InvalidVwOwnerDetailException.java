package com.vw.customException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidVwOwnerDetailException extends RuntimeException{
    public InvalidVwOwnerDetailException (String message){
        super(message);
    }
}
