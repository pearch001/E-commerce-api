package com.ecommerce.ecommerceapi.services;

import com.ecommerce.ecommerceapi.dto.AddToCartDto;
import com.ecommerce.ecommerceapi.dto.CartDto;
import com.ecommerce.ecommerceapi.dto.CartItemDto;
import com.ecommerce.ecommerceapi.dto.ProductDto;
import com.ecommerce.ecommerceapi.exceptions.CartItemNotExistException;

import java.util.List;

public interface CartServiceInt {
    void addToCart(AddToCartDto addToCartDto, String username);
    CartDto getUserCart(String username);
    void deleteItemFromCart(CartItemDto cartItemDto) throws CartItemNotExistException;
}
