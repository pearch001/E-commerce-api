package com.ecommerce.ecommerceapi.dto;

import lombok.*;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CartItemDto {
    private Long id;
    private Integer quantity;
    private ProductDto productDto;
}
