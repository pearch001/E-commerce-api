package com.ecommerce.ecommerceapi.services;

import com.ecommerce.ecommerceapi.model.entities.Product;



public interface ProductService {
    Product saveProduct(Product product);
    Product getProduct(String productName);
}
