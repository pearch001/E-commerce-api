package com.ecommerce.ecommerceapi.services;

import com.ecommerce.ecommerceapi.model.JwtRequest;
import com.ecommerce.ecommerceapi.model.entities.User;
import com.ecommerce.ecommerceapi.model.entities.UserProfile;
import org.springframework.security.core.userdetails.UserDetails;

public interface User_Service {

    User saveUser(User user);
    UserDetails loadUserByUsername(String username);
    void login(JwtRequest request) throws Exception;

}
