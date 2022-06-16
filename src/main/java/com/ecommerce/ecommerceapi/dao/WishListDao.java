package com.ecommerce.ecommerceapi.dao;

import com.ecommerce.ecommerceapi.model.entities.User;
import com.ecommerce.ecommerceapi.model.entities.WishList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WishListDao extends CrudRepository<WishList,Long> {

    @Query("SELECT CASE WHEN COUNT(j) > 0 THEN TRUE ELSE FALSE END FROM "
            + "wishlist w WHERE w.product_id = ?1")
    Boolean findByProductId(Long id);

    @Query("SELECT w FROM "
            + "wishlist w WHERE w.product_id = ?1")
    WishList selectByProductID(Long id);

    List<WishList> findAllByUserOrderByCreatedDateDesc(User user);
}
