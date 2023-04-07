package com.funny.code.order.model.dto;

import java.io.Serializable;
import java.util.List;

public record InventoryDTORequest(List<ProductDTORequest> productDTORequestList) implements Serializable {
}
