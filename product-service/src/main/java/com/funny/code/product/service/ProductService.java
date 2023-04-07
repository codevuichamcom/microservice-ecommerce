package com.funny.code.product.service;

import com.funny.code.product.model.dto.ProductDTOCreate;
import com.funny.code.product.model.dto.ProductDTOResponse;

import java.util.List;

public interface ProductService {

    List<ProductDTOResponse> getAll();

    ProductDTOResponse create(ProductDTOCreate productDTOCreate);
}
