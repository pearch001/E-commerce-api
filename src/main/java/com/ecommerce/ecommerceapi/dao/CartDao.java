package com.ecommerce.ecommerceapi.dao;

import com.ecommerce.ecommerceapi.model.entities.Cart;
import com.ecommerce.ecommerceapi.model.entities.Product;
import com.ecommerce.ecommerceapi.model.entities.User;
import com.ecommerce.ecommerceapi.model.entities.WishList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CartDao extends CrudRepository<Cart,Long> {
    @Query("SELECT CASE WHEN COUNT(j) > 0 THEN TRUE ELSE FALSE END FROM "
            + "cart c WHERE c.product_id = ?1")
    Boolean findByProductId(Long id);

    List<Cart> findAllByUserOrderByCreatedDateDesc(User user);
}
