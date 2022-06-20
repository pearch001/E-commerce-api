package com.ecommerce.ecommerceapi.api;


import com.ecommerce.ecommerceapi.dto.CartDto;
import com.ecommerce.ecommerceapi.services.OrderServiceImpl;
import com.ecommerce.ecommerceapi.utils.JwtTokenUtil;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/order")
@RestController
public class OrderController {
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    OrderServiceImpl orderService;

    @Value("${remita.secret}")
    private String secretKey;

    @GetMapping
    public ResponseEntity<HttpResponse<String>> getCartItems(@RequestHeader(value = "Authorization") String authorizationHeader,
    @RequestParam String transactionId) throws UnirestException {
        String username = null;
        String jwtToken = null;
        jwtToken = authorizationHeader.substring(7);
        username = jwtTokenUtil.getUsernameFromToken(jwtToken);
        Unirest.setTimeouts(0, 0);
        String secret = transactionId + secretKey;
        HttpResponse<String> response = Unirest.get("https://remitademo.net/payment/v1/payment/query/" + transactionId )
                .header("publicKey", "QzAwMDAyNzEyNTl8MTEwNjE4NjF8OWZjOWYwNmMyZDk3MDRhYWM3YThiOThlNTNjZTE3ZjYxOTY5NDdmZWE1YzU3NDc0ZjE2ZDZjNTg1YWYxNWY3NWM4ZjMzNzZhNjNhZWZlOWQwNmJhNTFkMjIxYTRiMjYzZDkzNGQ3NTUxNDIxYWNlOGY4ZWEyODY3ZjlhNGUwYTY=")
                .header("Content-Type", "application/json")
                .header("TXN_HASH", "" + secret +"")
                .asString();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
