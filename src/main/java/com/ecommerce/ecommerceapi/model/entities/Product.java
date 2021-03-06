package com.ecommerce.ecommerceapi.model.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
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
    private double price;
    private Long merchantId;
    private String productionCountry;
    private String imageUrl;
    private Double ratings;
    private Double weight;
    private String keyFeatures;
    private String itemName;

    //Many to one relationship
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;


}




