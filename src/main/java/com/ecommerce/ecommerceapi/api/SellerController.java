package com.ecommerce.ecommerceapi.api;

import com.ecommerce.ecommerceapi.model.entities.Product;
import com.ecommerce.ecommerceapi.model.entities.Seller;
import com.ecommerce.ecommerceapi.services.ProductService;
import com.ecommerce.ecommerceapi.services.SellerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@Slf4j
@RequestMapping("/api/v1/sellers")
@RestController
public class SellerController {

    /*@Autowired
    SellerService sellerService;

    @Autowired
    ProductService productService;

    @PostMapping("/signup")
    public ResponseEntity<Seller> signUp(@RequestBody Seller seller){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v1/sellers/signup").toUriString());
        return ResponseEntity.created(uri).body(sellerService.saveSeller(seller));
    }
    @PostMapping("/createProduct")
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v1/sellers/signup").toUriString());
        return ResponseEntity.created(uri).body(productService.saveProduct(product));
    }*/

}
