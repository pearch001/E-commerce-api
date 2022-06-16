package com.ecommerce.ecommerceapi.services;

import com.ecommerce.ecommerceapi.dto.ProductDto;
import com.ecommerce.ecommerceapi.model.entities.WishList;

import java.util.List;

public interface WishListServiceInt {

    void saveWishList(ProductDto productDto, String username);
    List<ProductDto> getWishlist(String username);
    void deleteProductFromWishList(ProductDto productDto, String username);
}
