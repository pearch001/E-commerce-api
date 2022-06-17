package com.ecommerce.ecommerceapi.dto;

import lombok.*;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AddToCartDto {
    private Long id;
    private Long productId;
    private int quantity;
}
