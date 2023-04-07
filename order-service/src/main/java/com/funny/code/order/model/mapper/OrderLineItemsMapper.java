package com.funny.code.order.model.mapper;

import com.funny.code.order.entity.Order;
import com.funny.code.order.entity.OrderLineItems;
import com.funny.code.order.model.dto.OrderLineItemsDTOCreate;
import com.funny.code.order.model.dto.OrderLineItemsDTOResponse;

public class OrderLineItemsMapper {
    public static OrderLineItems toOrderLineItems(OrderLineItemsDTOCreate orderLineItemsDTOCreate, Order order) {
        return OrderLineItems.builder()
                .productId(orderLineItemsDTOCreate.productId())
                .price(orderLineItemsDTOCreate.price())
                .quantity(orderLineItemsDTOCreate.quantity())
                .order(order)
                .build();
    }

    public static OrderLineItemsDTOResponse toOrderLineItemsDTOResponse(OrderLineItems orderLineItems) {
        return OrderLineItemsDTOResponse.builder()
                .id(orderLineItems.getId())
                .productId(orderLineItems.getProductId())
                .price(orderLineItems.getPrice())
                .quantity(orderLineItems.getQuantity())
                .build();
    }
}
