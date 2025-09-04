package com.example.byteSoul.orderService.Service;

import com.example.byteSoul.orderService.DTO.OrderDTO;
import com.example.byteSoul.orderService.DTO.OrderRequestDTO;
import com.example.byteSoul.orderService.Entity.Order;
import com.example.byteSoul.orderService.Entity.OrderItem;
import com.example.byteSoul.orderService.Repository.OrderItemRepository;
import com.example.byteSoul.orderService.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    public Order placeOrder(OrderRequestDTO requestDTO) {
        OrderDTO orderDTO = requestDTO.getOrder();
        Order order = new Order();
        order.setUserId(orderDTO.getUserId());
        order.setStatus(orderDTO.getStatus());
        order.setTotalAmount(orderDTO.getTotalAmount());
        order.setCreatedAt(LocalDateTime.now());
        Order savedOrder = orderRepository.save(order);

        List<OrderItem> items = requestDTO.getOrderItems()
                .stream()
                .map(dto -> {
                    OrderItem item = new OrderItem();
                    item.setOrderId(savedOrder.getId());
                    item.setMenuItemId(dto.getMenuItemId());
                    item.setQuantity(dto.getQuantity());
                    item.setPrice(dto.getPrice());
                    return item;
                })
                .collect(Collectors.toList());

        orderItemRepository.saveAll(items);

        return savedOrder;
    }

    public List<Order> getOrdersByUser(Long userId) {
        return orderRepository.findByUserId(userId);
    }

    public List<OrderItem> getItemsByOrder(Long orderId) {
        return orderItemRepository.findByOrderId(orderId);
    }
}

