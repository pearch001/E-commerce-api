package com.ecommerce.ecommerceapi.services;

import com.ecommerce.ecommerceapi.dao.CategoryDao;
import com.ecommerce.ecommerceapi.dao.ProductDao;
import com.ecommerce.ecommerceapi.model.entities.Category;
import com.ecommerce.ecommerceapi.model.entities.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductDao productDao;
    @Autowired
    private CategoryDao categoryDao;

    @Override
    public Product saveProduct(Product product) throws IllegalStateException {
        Optional<Category> category = categoryDao.findById(product.getCategory().getId());
        if (category.isEmpty()){
            throw new IllegalStateException("Category not found");
        }
        return productDao.save(product);
    }

    @Override
    public List<Product> getProduct(String productName) {
        return (List<Product>) productDao.findProducts(productName);
    }
}
