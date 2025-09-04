package com.example.byteSoul.paymentService.Service;

import com.example.byteSoul.paymentService.DTO.OrderResponse;
import com.example.byteSoul.paymentService.DTO.PaymentRequest;
import com.example.byteSoul.paymentService.Entity.Payment;
import com.example.byteSoul.paymentService.Repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private RestTemplate restTemplate;

    private static final String ORDER_SERVICE_URL = "http://localhost:8083/orders/";

    public Payment processPayment(PaymentRequest request) {
        OrderResponse order = restTemplate.getForObject(
                ORDER_SERVICE_URL + request.getOrderId(),
                OrderResponse.class
        );

        if (order == null || !order.getUserId().equals(request.getUserId())) {
            throw new RuntimeException("Invalid order or user mismatch");
        }

        Payment payment = new Payment(
                request.getOrderId(),
                request.getUserId(),
                request.getPaymentMethod(),
                order.getTotalAmount(),
                "PENDING"
        );
        paymentRepository.save(payment);
        payment.setStatus("SUCCESS");
        payment.setPaidAt(java.time.LocalDateTime.now());
        paymentRepository.save(payment);
        restTemplate.put(ORDER_SERVICE_URL + "update-status/" + request.getOrderId() + "?status=PAID", null);

        return payment;
    }
}
