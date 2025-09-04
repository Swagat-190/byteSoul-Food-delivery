package com.example.byteSoul.paymentService.DTO;

import lombok.Data;

@Data
public class OrderResponse {
    private Long id;
    private Long userId;
    private Long restaurantId;
    private String status;
    private Double totalAmount;

    public OrderResponse() {}

    public OrderResponse(Long id, Long userId, Long restaurantId, String status, Double totalAmount) {
        this.id = id;
        this.userId = userId;
        this.restaurantId = restaurantId;
        this.status = status;
        this.totalAmount = totalAmount;
    }


}

