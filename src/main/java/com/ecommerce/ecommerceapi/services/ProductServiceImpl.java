package com.ecommerce.ecommerceapi.services;

import com.ecommerce.ecommerceapi.dao.CategoryDao;
import com.ecommerce.ecommerceapi.dao.ProductDao;
import com.ecommerce.ecommerceapi.dto.ProductDto;
import com.ecommerce.ecommerceapi.exceptions.CustomException;
import com.ecommerce.ecommerceapi.model.entities.Category;
import com.ecommerce.ecommerceapi.model.entities.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
    public Product saveProduct(ProductDto productDto) throws IllegalStateException {
        Optional<Category> category = categoryDao.findById(productDto.getCategoryId());
        if (category.isEmpty()){
            throw new IllegalStateException("Category not found");
        }
        Product product = new Product();
        product.setMerchantId(productDto.getMerchantId());
        product.setKeyFeatures(productDto.getKeyFeatures());
        product.setProductionCountry(productDto.getProductionCountry());
        product.setPrice(productDto.getPrice());
        product.setWeight(productDto.getWeight());
        product.setRatings(productDto.getRatings());
        product.setImageUrl(productDto.getImageUrl());
        product.setItemName(productDto.getItemName());
        product.setCategory(category.get());
        return productDao.save(product);
    }

    public ProductDto getProductDto(Product product){
        ProductDto productDto = new ProductDto();
        productDto.setMerchantId(product.getMerchantId());
        productDto.setKeyFeatures(product.getKeyFeatures());
        productDto.setProductionCountry(product.getProductionCountry());
        productDto.setPrice(product.getPrice());
        productDto.setWeight(product.getWeight());
        productDto.setRatings(product.getRatings());
        productDto.setImageUrl(product.getImageUrl());
        productDto.setItemName(product.getItemName());
        productDto.setId(product.getId());
        productDto.setCategoryId(product.getCategory().getId());
        return  productDto;
    }

    @Override
    public void updateProduct(ProductDto productDto) {
        Optional<Category> category = categoryDao.findById(productDto.getCategoryId());
        if (category.isEmpty()){
            throw new CustomException("Category not found");
        }
        Optional<Product> optionalProduct = productDao.findById(productDto.getId());
        if (optionalProduct.isEmpty()){
            throw new CustomException("Product not found");
        }else {

            Product updateProduct = productDao.findByID(productDto.getId());
            updateProduct.setCategory(category.get());
            updateProduct.setImageUrl(productDto.getImageUrl());
            updateProduct.setPrice(productDto.getPrice());
            updateProduct.setProductionCountry(productDto.getProductionCountry());
            updateProduct.setRatings(productDto.getRatings());
            updateProduct.setWeight(productDto.getWeight());
            updateProduct.setKeyFeatures(productDto.getKeyFeatures());
            updateProduct.setMerchantId(productDto.getMerchantId());
        }

    }

    @Override
    public void deleteProduct(Product product) {
        Optional<Category> category = categoryDao.findById(product.getCategory().getId());
        if (category.isEmpty()){
            throw new IllegalStateException("Category not found");
        }
        Optional<Product> optionalProduct = productDao.findById(product.getId());
        if (optionalProduct.isEmpty()){
            throw new IllegalStateException("Category not found");
        }else {
            productDao.delete(product);
        }
    }

    @Override
    public List<ProductDto> getProduct(String productName) {
        List<Product> products = productDao.findProducts(productName);
        List<ProductDto> productDtos = new ArrayList<>();
        for(Product product : products){
            productDtos.add(getProductDto(product));
        }
        return productDtos;
    }
}
