package com.ecommerce.ecommerceapi.dto;

import lombok.*;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private Long id;
    private double price;
    private Long merchantId;
    private String productionCountry;
    private String imageUrl;
    private Double ratings;
    private Double weight;
    private String keyFeatures;
    private String itemName;
    private Long categoryId;

}
