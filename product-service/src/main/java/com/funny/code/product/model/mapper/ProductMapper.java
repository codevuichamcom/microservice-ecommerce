package com.funny.code.product.model.mapper;

import com.funny.code.product.entity.Product;
import com.funny.code.product.model.dto.ProductDTOCreate;
import com.funny.code.product.model.dto.ProductDTOResponse;

public class ProductMapper {
    public static ProductDTOResponse toProductDTOResponse(Product product) {
        return ProductDTOResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }

    public static Product toProduct(ProductDTOCreate productDTOCreate) {
        return Product.builder()
                .name(productDTOCreate.name())
                .description(productDTOCreate.description())
                .price(productDTOCreate.price())
                .build();
    }
}
