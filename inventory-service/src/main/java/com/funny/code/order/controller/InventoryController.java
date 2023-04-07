package com.funny.code.order.controller;

import com.funny.code.order.model.dto.InventoryDTORequest;
import com.funny.code.order.model.dto.InventoryDTOResponse;
import com.funny.code.order.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    @PostMapping
    public InventoryDTOResponse isAllInStock(@RequestBody InventoryDTORequest inventoryDTORequest){
        return inventoryService.isInStock(inventoryDTORequest);
    }


}
