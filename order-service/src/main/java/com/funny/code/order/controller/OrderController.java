package com.funny.code.order.controller;

import com.funny.code.order.model.dto.OrderDTOCreate;
import com.funny.code.order.model.dto.OrderDTOResponse;
import com.funny.code.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/order")
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public OrderDTOResponse placeOrder(@RequestBody OrderDTOCreate orderDTOCreate){
        return orderService.create(orderDTOCreate);
    }


}
