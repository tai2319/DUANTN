package com.ps20652.DATN.service;

import com.ps20652.DATN.entity.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    List<Order> getAllOrders();
    Optional<Order> getOrderById(Long orderId);
    Order saveOrder(Order order);
    void deleteOrder(Long orderId);
}
