package com.ecommerce.ecommerceapi.api;

import com.ecommerce.ecommerceapi.common.ApiResponse;
import com.ecommerce.ecommerceapi.dao.ProductDao;
import com.ecommerce.ecommerceapi.dto.ProductDto;
import com.ecommerce.ecommerceapi.model.Response;
import com.ecommerce.ecommerceapi.model.entities.Product;
import com.ecommerce.ecommerceapi.model.entities.User;
import com.ecommerce.ecommerceapi.services.ProductService;
import com.ecommerce.ecommerceapi.services.ProductServiceImpl;
import lombok.Data;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<Product> createProduct(@RequestBody ProductDto productDto){


        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v1/product").toUriString());

        return ResponseEntity.created(uri).body(productService.saveProduct(productDto));
    }

    @PutMapping
    public ResponseEntity<ApiResponse> updateProduct(@RequestBody ProductDto productDto){
        productService.updateProduct(productDto);
        return new ResponseEntity<>(new ApiResponse(true,"Product Updated"), HttpStatus.OK);
    }

    @GetMapping("/{productName}")
    public List<ProductDto> getProducts(
            @PathVariable("jobTitle") String jobTitle
    ){
        return productService.getProduct(jobTitle);
    }

    @GetMapping("")
    public List<ProductDto> listProducts(){
        return productService.getProduct("");
    }

    @DeleteMapping("")
    public ResponseEntity<ApiResponse> deleteProduct(@RequestBody Product product){
        productService.deleteProduct(product);
        return new ResponseEntity<>(new ApiResponse(true,"Product deleted"), HttpStatus.OK);
    }
}
