package com.funny.code.order.service;

import com.funny.code.order.model.dto.InventoryDTORequest;
import com.funny.code.order.model.dto.InventoryDTOResponse;

public interface InventoryService {
    InventoryDTOResponse isInStock(InventoryDTORequest inventoryDTORequest);
}
