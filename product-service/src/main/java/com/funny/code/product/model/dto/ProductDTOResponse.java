package com.funny.code.product.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ProductDTOResponse {
    private int id;
    private String name;
    private String description;
    private double price;
}
