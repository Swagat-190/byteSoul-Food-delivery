package com.example.byteSoul.paymentService.Controller;

import com.example.byteSoul.paymentService.DTO.PaymentRequest;
import com.example.byteSoul.paymentService.Entity.Payment;
import com.example.byteSoul.paymentService.Service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping
    public Payment makePayment(@RequestBody PaymentRequest request) {
        return paymentService.processPayment(request);
    }
}

