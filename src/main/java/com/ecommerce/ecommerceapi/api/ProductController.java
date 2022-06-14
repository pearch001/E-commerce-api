package com.ecommerce.ecommerceapi.api;

import com.ecommerce.ecommerceapi.dao.ProductDao;
import com.ecommerce.ecommerceapi.model.Response;
import com.ecommerce.ecommerceapi.model.entities.Product;
import com.ecommerce.ecommerceapi.model.entities.User;
import com.ecommerce.ecommerceapi.services.ProductService;
import com.ecommerce.ecommerceapi.services.ProductServiceImpl;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RequestMapping("/api/v1/product")
@RestController
public class ProductController {

    @Autowired
    private ProductServiceImpl productService;

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product){


        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v1/product").toUriString());

        return ResponseEntity.created(uri).body(productService.saveProduct(product));
    }

    @PutMapping
    public ResponseEntity<Product> updateProduct(@RequestBody Product product){

    }

    @GetMapping("/{productName}")
    public List<Product> getProducts(
            @PathVariable("jobTitle") String jobTitle
    ){
        return productService.getProduct(jobTitle);
    }

    @GetMapping("")
    public List<Product> listProducts(){
        return productService.getProduct("");
    }
}
