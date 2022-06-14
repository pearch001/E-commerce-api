package com.ecommerce.ecommerceapi.dao;

import com.ecommerce.ecommerceapi.model.entities.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CategoryDao extends CrudRepository<Category, Long> {
    Category findById(Integer Id);

    @Override
    Optional<Category> findById(Long aLong);
}
