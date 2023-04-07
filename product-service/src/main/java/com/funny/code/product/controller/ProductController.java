package com.funny.code.product.controller;

import com.funny.code.product.model.dto.ProductDTOCreate;
import com.funny.code.product.model.dto.ProductDTOResponse;
import com.funny.code.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public List<ProductDTOResponse> getAllProducts(){
        return productService.getAll();
    }

    @PostMapping
    public ProductDTOResponse createProduct(@RequestBody ProductDTOCreate productDTOCreate){
        return productService.create(productDTOCreate);
    }

}
