package com.funny.code.order.model.mapper;

import com.funny.code.order.entity.Order;
import com.funny.code.order.entity.OrderLineItems;
import com.funny.code.order.model.dto.OrderDTOCreate;
import com.funny.code.order.model.dto.OrderDTOResponse;

import java.util.List;

public class OrderMapper {
    public static Order toOrder(OrderDTOCreate orderDTOCreate) {


        Order order = Order.builder().build();
        List<OrderLineItems> orderLineItemsList = orderDTOCreate.orderLineItemsDTOCreateList()
                .stream()
                .map((o) -> OrderLineItemsMapper.toOrderLineItems(o, order))
                .toList();
        order.setOrderLineItemsList(orderLineItemsList);
        return order;
    }

    public static OrderDTOResponse toOrderDTOResponse(Order order) {
        return OrderDTOResponse.builder()
                .id(order.getId())
                .orderLineItemsDTOResponseList(
                        order.getOrderLineItemsList()
                                .stream().map(OrderLineItemsMapper::toOrderLineItemsDTOResponse)
                                .toList())
                .build();
    }
}
