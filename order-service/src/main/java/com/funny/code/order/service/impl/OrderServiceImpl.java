package com.funny.code.order.service.impl;

import com.funny.code.order.entity.Order;
import com.funny.code.order.model.dto.*;
import com.funny.code.order.model.mapper.OrderMapper;
import com.funny.code.order.repository.OrderRepository;
import com.funny.code.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final RestTemplate restTemplate;
    private KafkaTemplate<Integer, String> kafkaTemplate;

    @Override
    public OrderDTOResponse create(OrderDTOCreate orderDTOCreate) {
        List<ProductDTORequest> productDTORequestList = orderDTOCreate.orderLineItemsDTOCreateList().stream()
                .map(orderLineItemsDTOCreate -> new ProductDTORequest(orderLineItemsDTOCreate.productId(), orderLineItemsDTOCreate.quantity()))
                .toList();
        InventoryDTORequest inventoryDTORequest = new InventoryDTORequest(productDTORequestList);
        HttpEntity<InventoryDTORequest> request = new HttpEntity<>(inventoryDTORequest);
        InventoryDTOResponse inventoryDTOResponse = restTemplate.postForObject("http://inventory-service/api/inventory", request, InventoryDTOResponse.class);

        if (inventoryDTOResponse != null && inventoryDTOResponse.isInStock()) {
            Order order = OrderMapper.toOrder(orderDTOCreate);
            OrderDTOResponse orderDTOResponse =  OrderMapper.toOrderDTOResponse(orderRepository.save(order));
            kafkaTemplate.send("notificationTopic", orderDTOResponse.getId()+"");
            return orderDTOResponse;

        }
        throw new IllegalArgumentException("Product out of stock");
    }
}
