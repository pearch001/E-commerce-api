package com.ecommerce.ecommerceapi.services;

import com.ecommerce.ecommerceapi.dao.CartDao;
import com.ecommerce.ecommerceapi.dao.UserDao;
import com.ecommerce.ecommerceapi.dto.AddToCartDto;
import com.ecommerce.ecommerceapi.dto.CartDto;
import com.ecommerce.ecommerceapi.dto.CartItemDto;
import com.ecommerce.ecommerceapi.dto.ProductDto;
import com.ecommerce.ecommerceapi.exceptions.CustomException;
import com.ecommerce.ecommerceapi.model.entities.Cart;
import com.ecommerce.ecommerceapi.model.entities.Product;
import com.ecommerce.ecommerceapi.model.entities.User;
import com.ecommerce.ecommerceapi.model.entities.WishList;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class CartServiceImpl implements CartServiceInt{
    @Autowired
    CartDao cartDao;

    @Autowired
    ProductServiceImpl productService;

    @Autowired
    UserDao userDao;

    @Override
    public void addToCart(AddToCartDto addToCartDto, String username) {
        User user = userDao.findByUsername(username);
        Boolean isProductInWishlist = cartDao.findByProductId(addToCartDto.getProductId());
        if (isProductInWishlist){
            throw new CustomException("Product is in wishlist");
        }
        Product product = productService.getProduct(addToCartDto.getProductId());
        Cart cart = new Cart(user,product,addToCartDto.getQuantity());
        cartDao.save(cart);
    }

    @Override
    public CartDto getUserCart(String username) {
        User user = userDao.findByUsername(username);
        List<Cart> carts = cartDao.findAllByUserOrderByCreatedDateDesc(user);
        List<CartItemDto> cartItemDtos = new ArrayList<>();
        Double totalCost = 0.0;
        for(Cart cart : carts){
            CartItemDto cartItemDto = new CartItemDto(cart.getId(),cart.getQuantity(),productService.getProductDto(cart.getProduct()));
            cartItemDtos.add(cartItemDto);
            totalCost =+ cart.getQuantity() * cart.getProduct().getPrice();
        }
        return new CartDto(cartItemDtos,totalCost);
    }

    @Override
    public void deleteItemFromCart(ProductDto productDto) {

    }
}
