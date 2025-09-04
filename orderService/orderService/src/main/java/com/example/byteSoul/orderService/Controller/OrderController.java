package com.example.byteSoul.orderService.Controller;

import com.example.byteSoul.orderService.Entity.Order;
import com.example.byteSoul.orderService.DTO.OrderRequestDTO;
import com.example.byteSoul.orderService.Entity.OrderItem;
import com.example.byteSoul.orderService.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<Order> placeOrder(@RequestBody OrderRequestDTO requestDTO) {
        Order savedOrder = orderService.placeOrder(requestDTO);
        return ResponseEntity.ok(savedOrder);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Order>> getUserOrders(@PathVariable Long userId) {
        List<Order> orders = orderService.getOrdersByUser(userId);
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/{orderId}/items")
    public ResponseEntity<List<OrderItem>> getOrderItems(@PathVariable Long orderId) {
        List<OrderItem> items = orderService.getItemsByOrder(orderId);
        return ResponseEntity.ok(items);
    }
}

