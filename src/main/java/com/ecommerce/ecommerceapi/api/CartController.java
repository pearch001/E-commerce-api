package com.ecommerce.ecommerceapi.api;

import com.ecommerce.ecommerceapi.common.ApiResponse;
import com.ecommerce.ecommerceapi.dto.AddToCartDto;
import com.ecommerce.ecommerceapi.dto.CartDto;
import com.ecommerce.ecommerceapi.dto.CartItemDto;
import com.ecommerce.ecommerceapi.dto.ProductDto;
import com.ecommerce.ecommerceapi.exceptions.CartItemNotExistException;
import com.ecommerce.ecommerceapi.services.CartServiceImpl;
import com.ecommerce.ecommerceapi.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/cart")
@RestController
public class CartController {
    @Autowired
    CartServiceImpl cartService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @PostMapping
    public ResponseEntity<ApiResponse> createWishlist(@RequestBody AddToCartDto addToCartDto ,
                                                      @RequestHeader(value = "Authorization") String authorizationHeader){
        String username = null;
        String jwtToken = null;
        jwtToken = authorizationHeader.substring(7);
        username = jwtTokenUtil.getUsernameFromToken(jwtToken);
        cartService.addToCart(addToCartDto,username);
        return new ResponseEntity<>(new ApiResponse(true,"Product added to Cart"), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<CartDto> getCartItems(@RequestHeader(value = "Authorization") String authorizationHeader){
        String username = null;
        String jwtToken = null;
        jwtToken = authorizationHeader.substring(7);
        username = jwtTokenUtil.getUsernameFromToken(jwtToken);
        return new ResponseEntity<>(cartService.getUserCart(username), HttpStatus.OK);
    }
    @DeleteMapping
    public ResponseEntity<ApiResponse> deleteItem(@RequestBody CartItemDto cartItemDto,
                                                  @RequestHeader(value = "Authorization") String authorizationHeader) throws CartItemNotExistException {
        String username = null;
        String jwtToken = null;
        jwtToken = authorizationHeader.substring(7);
        username = jwtTokenUtil.getUsernameFromToken(jwtToken);
        cartService.deleteItemFromCart(cartItemDto);
        return new ResponseEntity<>(new ApiResponse(true,"Item deleted from cart"), HttpStatus.OK);
    }
}
