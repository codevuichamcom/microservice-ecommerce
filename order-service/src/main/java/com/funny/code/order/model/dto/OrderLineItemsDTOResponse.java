package com.funny.code.order.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class OrderLineItemsDTOResponse {
    private int id;
    private int productId;
    private double price;
    private int quantity;
}
