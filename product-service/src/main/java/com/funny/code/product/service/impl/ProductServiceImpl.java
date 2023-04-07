package com.funny.code.product.service.impl;

import com.funny.code.product.model.dto.ProductDTOCreate;
import com.funny.code.product.model.dto.ProductDTOResponse;
import com.funny.code.product.entity.Product;
import com.funny.code.product.model.mapper.ProductMapper;
import com.funny.code.product.repository.ProductRepository;
import com.funny.code.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;


    @Override
    public List<ProductDTOResponse> getAll() {
        return productRepository.findAll().stream().map(ProductMapper::toProductDTOResponse).toList();
    }

    @Override
    public ProductDTOResponse create(ProductDTOCreate productDTOCreate) {
        Product product = ProductMapper.toProduct(productDTOCreate);
        return ProductMapper.toProductDTOResponse(productRepository.save(product));
    }
}
