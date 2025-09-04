package com.example.byteSoul.paymentService.Repository;


import com.example.byteSoul.paymentService.Entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
