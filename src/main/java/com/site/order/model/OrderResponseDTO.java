package com.site.order.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderResponseDTO {

    private Long orderId;
    private Double amount;
    private String product;
    private CustomerDTO customer;
}