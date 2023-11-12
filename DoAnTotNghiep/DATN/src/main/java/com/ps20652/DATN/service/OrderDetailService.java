package com.ps20652.DATN.service;

import com.ps20652.DATN.entity.OrderDetail;
import com.ps20652.DATN.entity.Product;

import java.util.List;
import java.util.Optional;

public interface OrderDetailService {
    public List<OrderDetail> create(List<OrderDetail> orderDetails);

    List<OrderDetail> getOrderDeTails(int orderId);

    public int getProductSell(Product product);

    public List<OrderDetail> getOrderDetailsByProduct(Product product);

}
