package com.ecommerce.ecommerceapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(value = CustomException.class)
    public final ResponseEntity<String> handleCustomException(CustomException exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value =  AuthenticationFailException.class)
    public final ResponseEntity<String> handleCustomException(AuthenticationFailException authenticationFailException){
        return new ResponseEntity<>(authenticationFailException.getMessage(),HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = ProductNotExistException.class)
    public final ResponseEntity<String> handleProductNotExistException(ProductNotExistException productNotExistException){
        return new ResponseEntity<>(productNotExistException.getMessage(),HttpStatus.BAD_REQUEST);
    }
}
