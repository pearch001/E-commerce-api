package com.ecommerce.ecommerceapi.services;

import com.ecommerce.ecommerceapi.dto.AddToCartDto;
import com.ecommerce.ecommerceapi.dto.ProductDto;

import java.util.List;

public class CartServiceImpl implements CartServiceInt{
    @Override
    public void addToCart(AddToCartDto addToCartDto) {

    }

    @Override
    public List<ProductDto> getUserCart(String username) {
        return null;
    }

    @Override
    public void deleteItemFromCart(ProductDto productDto) {

    }
}
