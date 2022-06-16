package com.ecommerce.ecommerceapi.services;

import com.ecommerce.ecommerceapi.dao.CategoryDao;
import com.ecommerce.ecommerceapi.dao.ProductDao;
import com.ecommerce.ecommerceapi.dao.UserDao;
import com.ecommerce.ecommerceapi.dao.WishListDao;
import com.ecommerce.ecommerceapi.dto.ProductDto;
import com.ecommerce.ecommerceapi.exceptions.CustomException;
import com.ecommerce.ecommerceapi.model.entities.Category;
import com.ecommerce.ecommerceapi.model.entities.Product;
import com.ecommerce.ecommerceapi.model.entities.User;
import com.ecommerce.ecommerceapi.model.entities.WishList;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class WishListServiceImpl implements WishListServiceInt{
    @Autowired
    UserDao userDao;

    @Autowired
    WishListDao wishListDao;

    @Autowired
    private ProductDao productDao;

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public void saveWishList(ProductDto productDto, String username) {
        User user = userDao.findByUsername(username);
        Boolean isProductInWishlist = wishListDao.findByProductId(productDto.getId());
        if (isProductInWishlist){
            throw new CustomException("Product is in wishlist");
        }
        Product product = getProduct(productDto);
        WishList wishList = new WishList(user, product);
        wishListDao.save(wishList);
    }

    @Override
    public List<ProductDto> getWishlist(String username) {
        User user = userDao.findByUsername(username);
        List<WishList> wishLists = wishListDao.findAllByUserOrderByCreatedDateDesc(user);
        return wishListDao.findAllByUserOrderByCreatedDateDesc(user);
    }

    @Override
    public void deleteProductFromWishList(ProductDto productDto) {

    }

    public Product getProduct(ProductDto productDto){
        Optional<Category> category = categoryDao.findById(productDto.getCategoryId());
        if (category.isEmpty()){
            throw new IllegalStateException("Category not found");
        }
        Product product = productDao.findByID(productDto.getId());;
        product.setMerchantId(productDto.getMerchantId());
        product.setKeyFeatures(productDto.getKeyFeatures());
        product.setProductionCountry(productDto.getProductionCountry());
        product.setPrice(productDto.getPrice());
        product.setWeight(productDto.getWeight());
        product.setRatings(productDto.getRatings());
        product.setImageUrl(productDto.getImageUrl());
        product.setItemName(productDto.getItemName());
        product.setCategory(category.get());
        return  product;
    }
}
