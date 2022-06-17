package com.ecommerce.ecommerceapi.exceptions;

public class AuthenticationFailException extends IllegalArgumentException{
    public AuthenticationFailException(String s) {
        super(s);
    }
}
