package com.ecommerce.ecommerceapi.dao;


import com.ecommerce.ecommerceapi.model.entities.Seller;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SellerDao extends CrudRepository<Seller, Long> {
    @Override
    Optional<Seller> findById(Long ID);
    Seller findByUsername (String username);
}
