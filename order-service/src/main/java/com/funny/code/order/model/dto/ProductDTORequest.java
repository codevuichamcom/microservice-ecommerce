package com.funny.code.order.model.dto;

import java.io.Serializable;

public record ProductDTORequest(int productId, int quantity) implements Serializable {
}
