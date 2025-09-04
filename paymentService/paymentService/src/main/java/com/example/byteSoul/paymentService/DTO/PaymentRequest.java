package com.example.byteSoul.paymentService.DTO;

import lombok.Data;

@Data
public class PaymentRequest {
    private Long orderId;
    private Long userId;
    private String paymentMethod;

    public PaymentRequest() {}

    public PaymentRequest(Long orderId, Long userId, String paymentMethod) {
        this.orderId = orderId;
        this.userId = userId;
        this.paymentMethod = paymentMethod;
    }


}

