package com.funny.code.order.service.impl;

import com.funny.code.order.entity.Inventory;
import com.funny.code.order.model.dto.InventoryDTORequest;
import com.funny.code.order.model.dto.InventoryDTOResponse;
import com.funny.code.order.repository.InventoryRepository;
import com.funny.code.order.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepository inventoryRepository;


    @Override
    public InventoryDTOResponse isInStock(InventoryDTORequest inventoryDTORequest) {
        boolean isInStock = inventoryDTORequest.productDTORequestList().stream()
                .allMatch((productDTORequest) -> {
                    Optional<Inventory> inventoryOptional = inventoryRepository.findByProductId(productDTORequest.productId());
                    if (inventoryOptional.isPresent()) {
                        Inventory inventory = inventoryOptional.get();
                        return inventory.getQuantity() >= productDTORequest.quantity();
                    }
                    return false;
                });

        return InventoryDTOResponse.builder()
                .isInStock(isInStock)
                .build();
    }
}
