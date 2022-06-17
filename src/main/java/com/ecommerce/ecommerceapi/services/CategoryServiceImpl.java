package com.ecommerce.ecommerceapi.services;

import com.ecommerce.ecommerceapi.dao.CategoryDao;
import com.ecommerce.ecommerceapi.model.entities.Category;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    CategoryDao categoryDao;

    @Override
    public List<Category> categoryList() {
        return (List <Category>) categoryDao.findAll();
    }

    @Override
    public void addCategory(Category category) {
        categoryDao.save(category);
    }

    @Override
    public void editCategory(Integer id, Category updateCategory) {
        Category category = categoryDao.findById(id);
        if (category == null){
            throw new UsernameNotFoundException("User not found with id: " + id);
        }else {
            category.setCategoryName(updateCategory.getCategoryName());
            category.setDescription(updateCategory.getDescription());
            category.setImageUrl(updateCategory.getImageUrl());
        }
    }


}
