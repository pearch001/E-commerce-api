package com.ecommerce.ecommerceapi.services;

import com.ecommerce.ecommerceapi.model.entities.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoryService {
    List<Category> categoryList();
    void addCategory(Category category);
    void editCategory(Integer id , Category category);
}
