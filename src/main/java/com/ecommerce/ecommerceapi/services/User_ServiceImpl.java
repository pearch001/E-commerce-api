package com.ecommerce.ecommerceapi.services;

import com.ecommerce.ecommerceapi.config.CustomAuthenticationFilter;
import com.ecommerce.ecommerceapi.dao.UserDao;
<<<<<<< HEAD
import com.ecommerce.ecommerceapi.dao.UserProfileDao;
import com.ecommerce.ecommerceapi.model.JwtRequest;
import com.ecommerce.ecommerceapi.model.entities.User;
import com.ecommerce.ecommerceapi.model.entities.UserProfile;
=======
import com.ecommerce.ecommerceapi.model.JwtRequest;
import com.ecommerce.ecommerceapi.model.entities.User;
>>>>>>> 108aa4b8e0946b60fd1463fd85a720a7eecd7e46
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class User_ServiceImpl implements User_Service, UserDetailsService {
    private final UserDao userDao;
<<<<<<< HEAD
    private final UserProfileDao userProfileDao;
=======
>>>>>>> 108aa4b8e0946b60fd1463fd85a720a7eecd7e46

    @Autowired
    private  PasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

<<<<<<< HEAD


=======
>>>>>>> 108aa4b8e0946b60fd1463fd85a720a7eecd7e46
    @Override
    public User saveUser(User user) {
        log.info("Saving new user");
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userDao.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        User user = userDao.findByUsername(username);
        if (user != null) {
            return new org.springframework.security.core.userdetails.User(user.getUsername(),
                    user.getPassword(),
                    new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }



    @Override
    public void login(JwtRequest request) throws  Exception{

        CustomAuthenticationFilter customAuthenticationFilter = new CustomAuthenticationFilter(authenticationManager);
        customAuthenticationFilter.authentication(request);
        log.info(request.getUsername());
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }


}
