package com.ecommerce.ecommerceapi.dto;

import lombok.*;

import java.util.List;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CartDto {
    private List<CartItemDto> cartItemDtos;
    private double totalCost;

}
