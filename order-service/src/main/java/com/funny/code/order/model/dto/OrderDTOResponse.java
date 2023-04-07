package com.funny.code.order.model.dto;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class OrderDTOResponse {
    private  int id;
    private List<OrderLineItemsDTOResponse> orderLineItemsDTOResponseList;
}
