package com.ecommerce.ecommerceapi.services;

import com.ecommerce.ecommerceapi.dao.ProductDao;
import com.ecommerce.ecommerceapi.model.entities.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ProductServiceImpl implements ProductService{
    private ProductDao productDao;

    @Override
    public Product saveProduct(Product product) {
        return productDao.save(product);
    }
}
