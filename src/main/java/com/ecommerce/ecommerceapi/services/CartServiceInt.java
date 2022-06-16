package com.ecommerce.ecommerceapi.services;

import com.ecommerce.ecommerceapi.dto.AddToCartDto;
import com.ecommerce.ecommerceapi.dto.ProductDto;

import java.util.List;

public interface CartServiceInt {
    void addToCart(AddToCartDto addToCartDto);
    List<ProductDto> getUserCart(String username);
    void deleteItemFromCart(ProductDto productDto);
}
