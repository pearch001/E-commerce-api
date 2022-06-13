package com.ecommerce.ecommerceapi.dao;

import com.ecommerce.ecommerceapi.model.entities.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDao extends CrudRepository<Product, Long> {
    @Query("SELECT p FROM "
            + "products p WHERE p.itemName = ?1")
    Product findProducts (String productName);
}
