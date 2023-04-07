package com.funny.code.order.model.dto;

public record OrderLineItemsDTOCreate(int productId, double price, int quantity) {
}
