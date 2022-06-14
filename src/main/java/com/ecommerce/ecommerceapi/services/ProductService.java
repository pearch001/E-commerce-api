package com.ecommerce.ecommerceapi.services;

import com.ecommerce.ecommerceapi.model.entities.Product;

import java.util.List;


public interface ProductService {
    Product saveProduct(Product product);
    List<Product> getProduct(String productName);
}
