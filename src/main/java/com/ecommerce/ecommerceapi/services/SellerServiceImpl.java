package com.ecommerce.ecommerceapi.services;

import com.ecommerce.ecommerceapi.dao.SellerDao;
import com.ecommerce.ecommerceapi.model.entities.Seller;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class SellerServiceImpl {

    /*private SellerDao sellerDao;
    private PasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public Seller saveSeller(Seller seller) {
        seller.setPassword(bCryptPasswordEncoder.encode(seller.getPassword()));
        return sellerDao.save(seller);
    }*/
}
