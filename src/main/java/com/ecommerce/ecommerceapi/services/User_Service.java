package com.ecommerce.ecommerceapi.services;

import com.ecommerce.ecommerceapi.model.JwtRequest;
import com.ecommerce.ecommerceapi.model.entities.User;
<<<<<<< HEAD
import com.ecommerce.ecommerceapi.model.entities.UserProfile;
import org.springframework.security.core.userdetails.UserDetails;

public interface User_Service {

=======
import org.springframework.security.core.userdetails.UserDetails;

public interface User_Service {
>>>>>>> 108aa4b8e0946b60fd1463fd85a720a7eecd7e46
    User saveUser(User user);
    UserDetails loadUserByUsername(String username);
    void login(JwtRequest request) throws Exception;

}
