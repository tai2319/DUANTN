package com.ps20652.DATN.service;

import com.ps20652.DATN.entity.OrderDetail;

import java.util.List;
import java.util.Optional;

public interface OrderDetailService {
    List<OrderDetail> getAllOrderDetails();
    Optional<OrderDetail> getOrderDetailById(Long orderDetailId);
    OrderDetail saveOrderDetail(OrderDetail orderDetail);
    void deleteOrderDetail(Long orderDetailId);
}
