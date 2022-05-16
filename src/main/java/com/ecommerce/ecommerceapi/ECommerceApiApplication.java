package com.ecommerce.ecommerceapi;

import com.ecommerce.ecommerceapi.model.entities.User;
import com.ecommerce.ecommerceapi.services.User_Service;
import com.ecommerce.ecommerceapi.services.User_ServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
//@PropertySource("classpath:application-${spring.profiles.active:default}.properties")
public class ECommerceApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ECommerceApiApplication.class, args);
	}
/*
	@Bean
	CommandLineRunner run(User_ServiceImpl user_service){
		return args -> {
			user_service.saveUser(new User(null, "ts@gmail.com", "ts", "1234"));
			*//*user_service.saveUser(new User(null, "ms@gmail.com", "ms", "kasim"));
			user_service.saveUser(new User(null, "ns@gmail.com", "ns", "kasim"));*//*
		};
	}*/

}
