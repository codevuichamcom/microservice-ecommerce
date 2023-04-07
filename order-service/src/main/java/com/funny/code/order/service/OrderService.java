package com.funny.code.order.service;

import com.funny.code.order.model.dto.OrderDTOCreate;
import com.funny.code.order.model.dto.OrderDTOResponse;

public interface OrderService {
    OrderDTOResponse create(OrderDTOCreate orderDTOCreate);
}
