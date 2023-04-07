package com.funny.code.order.model.dto;

import java.util.List;

public record OrderDTOCreate(List<OrderLineItemsDTOCreate> orderLineItemsDTOCreateList) {
}
