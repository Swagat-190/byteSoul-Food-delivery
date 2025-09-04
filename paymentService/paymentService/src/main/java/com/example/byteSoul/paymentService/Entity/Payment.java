package com.example.byteSoul.paymentService.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "payments")
@Data
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long orderId;
    private Long userId;
    private String paymentMethod;
    private Double amount;
    private String status;
    private LocalDateTime paidAt;

    public Payment() {}

    public Payment(Long orderId, Long userId, String paymentMethod, Double amount, String status) {
        this.orderId = orderId;
        this.userId = userId;
        this.paymentMethod = paymentMethod;
        this.amount = amount;
        this.status = status;
    }

    @PrePersist
    public void prePersist() {
        if ("SUCCESS".equalsIgnoreCase(status)) {
            this.paidAt = LocalDateTime.now();
        }
    }


}
