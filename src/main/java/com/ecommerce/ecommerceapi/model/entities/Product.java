package com.ecommerce.ecommerceapi.model.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "products")
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
<<<<<<< HEAD
    private Long price;
    private Long merchantId;
    private String productionCountry;
    private String imageUrl;
=======
    private Long merchantId;
    private String productionCountry;
>>>>>>> 108aa4b8e0946b60fd1463fd85a720a7eecd7e46
    private Double ratings;
    private Double weight;
    private String keyFeatures;
    private String itemName;


}




