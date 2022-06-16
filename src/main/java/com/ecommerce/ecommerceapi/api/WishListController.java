package com.ecommerce.ecommerceapi.api;

import com.ecommerce.ecommerceapi.common.ApiResponse;
import com.ecommerce.ecommerceapi.dto.ProductDto;
import com.ecommerce.ecommerceapi.model.entities.Product;
import com.ecommerce.ecommerceapi.model.entities.User;
import com.ecommerce.ecommerceapi.model.entities.WishList;
import com.ecommerce.ecommerceapi.services.WishListServiceImpl;
import com.ecommerce.ecommerceapi.utils.JwtTokenUtil;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@RequestMapping("/api/v1/wishlists")
@RestController
public class WishListController {
    @Autowired
    private WishListServiceImpl wishListService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @PostMapping()
    public ResponseEntity<ApiResponse> createWishlist(@RequestBody ProductDto productDto ,
                                                @RequestHeader(value = "Authorization") String authorizationHeader){
        String username = null;
        String jwtToken = null;
        jwtToken = authorizationHeader.substring(7);
        username = jwtTokenUtil.getUsernameFromToken(jwtToken);
        wishListService.saveWishList(productDto,username);
        return new ResponseEntity<>(new ApiResponse(true,"Product added to wishlist"), HttpStatus.CREATED);
    }

    @GetMapping
    public List<ProductDto> getWishlist(@RequestHeader(value = "Authorization") String authorizationHeader){
        String username = null;
        String jwtToken = null;
        jwtToken = authorizationHeader.substring(7);
        username = jwtTokenUtil.getUsernameFromToken(jwtToken);
        return wishListService.getWishlist(username);
    }

    @DeleteMapping()
    public ResponseEntity<ApiResponse> deleteFromWishlist(@RequestBody ProductDto productDto ,
                                                      @RequestHeader(value = "Authorization") String authorizationHeader){
        String username = null;
        String jwtToken = null;
        jwtToken = authorizationHeader.substring(7);
        username = jwtTokenUtil.getUsernameFromToken(jwtToken);
        wishListService.deleteProductFromWishList(productDto,username);
        return new ResponseEntity<>(new ApiResponse(true,"Product deleted from wishlist"), HttpStatus.OK);
    }

}
