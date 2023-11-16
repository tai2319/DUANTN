package com.ps20652.DATN.service.impl;

import com.ps20652.DATN.DAO.OrderDetailDAO;
import com.ps20652.DATN.entity.OrderDetail;
import com.ps20652.DATN.service.OrderDetailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {
    private final OrderDetailDAO orderDetailDAO;

    @Autowired
    public OrderDetailServiceImpl(OrderDetailDAO orderDetailDAO) {
        this.orderDetailDAO = orderDetailDAO;
    }

    @Override
    public List<OrderDetail> getAllOrderDetails() {
        return orderDetailDAO.findAll();
    }

    @Override
    public Optional<OrderDetail> getOrderDetailById(Long orderDetailId) {
        return orderDetailDAO.findById(orderDetailId);
    }

    @Override
    public OrderDetail saveOrderDetail(OrderDetail orderDetail) {
        return orderDetailDAO.save(orderDetail);
    }

    @Override
    public void deleteOrderDetail(Long orderDetailId) {
        orderDetailDAO.deleteById(orderDetailId);
    }
}
