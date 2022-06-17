package com.ecommerce.ecommerceapi.exceptions;

public class ProductNotExistException extends IllegalArgumentException {
    public ProductNotExistException(String category_not_found) {
    }
}
