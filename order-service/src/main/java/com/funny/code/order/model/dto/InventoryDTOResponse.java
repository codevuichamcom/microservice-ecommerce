package com.funny.code.order.model.dto;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class InventoryDTOResponse implements Serializable {
    private boolean isInStock;
}
