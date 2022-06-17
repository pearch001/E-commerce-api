package com.ecommerce.ecommerceapi.services;

import com.ecommerce.ecommerceapi.dto.ProductDto;
import com.ecommerce.ecommerceapi.model.entities.Product;

import java.util.List;


public interface ProductService {
    Product saveProduct(ProductDto productDto);
    void  updateProduct(ProductDto productDto);
    void deleteProduct(Product product);
    List<ProductDto> getProducts(String productName);
}
