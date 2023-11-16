package com.ps20652.DATN.service.impl;

import com.ps20652.DATN.DAO.OderDAO;
import com.ps20652.DATN.entity.Order;
import com.ps20652.DATN.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    private final OderDAO orderDAO;

    @Autowired
    public OrderServiceImpl(OderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    @Override
    public List<Order> getAllOrders() {
        return orderDAO.findAll();
    }

    @Override
    public Optional<Order> getOrderById(Long orderId) {
        return orderDAO.findById(orderId);
    }

    @Override
    public Order saveOrder(Order order) {
        return orderDAO.save(order);
    }

    @Override
    public void deleteOrder(Long orderId) {
        orderDAO.deleteById(orderId);
    }
}
