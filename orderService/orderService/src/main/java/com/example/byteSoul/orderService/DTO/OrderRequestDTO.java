package com.example.byteSoul.orderService.DTO;


import java.util.List;

public class OrderRequestDTO {
    private OrderDTO order;
    private List<OrderItemDTO> orderItems;

    // Getters and Setters
    public OrderDTO getOrder() { return order; }
    public void setOrder(OrderDTO order) { this.order = order; }

    public List<OrderItemDTO> getOrderItems() { return orderItems; }
    public void setOrderItems(List<OrderItemDTO> orderItems) { this.orderItems = orderItems; }
}

