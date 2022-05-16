package com.ecommerce.ecommerceapi.dao;

import com.ecommerce.ecommerceapi.model.entities.SellerProfile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerProfileDao extends CrudRepository<SellerProfile, Long> {
    SellerProfile findBySellerId(String sellerId);
}
