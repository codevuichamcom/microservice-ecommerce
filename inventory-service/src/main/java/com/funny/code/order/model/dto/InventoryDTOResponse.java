package com.funny.code.order.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class InventoryDTOResponse {
    private boolean isInStock;
}
