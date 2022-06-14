package com.ecommerce.ecommerceapi.dao;

import com.ecommerce.ecommerceapi.model.entities.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductDao extends CrudRepository<Product, Long> {
    @Query("SELECT p FROM "
            + "products p WHERE p.itemName LIKE '%' + ?1 + '%'")
    List<Product> findProducts (String productName);

    @Override
    Optional<Product> findById(Long aLong);
}
