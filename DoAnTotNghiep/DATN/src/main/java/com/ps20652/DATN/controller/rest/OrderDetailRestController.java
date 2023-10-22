package com.ps20652.DATN.controller.rest;

import com.ps20652.DATN.entity.OrderDetail;
import com.ps20652.DATN.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/order-details")
public class OrderDetailRestController {

    private final OrderDetailService orderDetailService;

    @Autowired
    public OrderDetailRestController(OrderDetailService orderDetailService) {
        this.orderDetailService = orderDetailService;
    }

    @GetMapping
    public ResponseEntity<List<OrderDetail>> getAllOrderDetails() {
        List<OrderDetail> orderDetails = orderDetailService.getAllOrderDetails();
        return new ResponseEntity<>(orderDetails, HttpStatus.OK);
    }

    @GetMapping("/{orderDetailId}")
    public ResponseEntity<OrderDetail> getOrderDetailById(@PathVariable Long orderDetailId) {
        Optional<OrderDetail> orderDetail = orderDetailService.getOrderDetailById(orderDetailId);
        if (orderDetail.isPresent()) {
            return new ResponseEntity<>(orderDetail.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<OrderDetail> createOrderDetail(@RequestBody OrderDetail orderDetail) {
        OrderDetail newOrderDetail = orderDetailService.saveOrderDetail(orderDetail);
        return new ResponseEntity<>(newOrderDetail, HttpStatus.CREATED);
    }

    @PutMapping("/{orderDetailId}")
    public ResponseEntity<OrderDetail> updateOrderDetail(@PathVariable Long orderDetailId, @RequestBody OrderDetail orderDetail) {
        Optional<OrderDetail> existingOrderDetail = orderDetailService.getOrderDetailById(orderDetailId);
        if (existingOrderDetail.isPresent()) {
            orderDetail.setOrderDetailId(orderDetailId);
            OrderDetail updatedOrderDetail = orderDetailService.saveOrderDetail(orderDetail);
            return new ResponseEntity<>(updatedOrderDetail, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{orderDetailId}")
    public ResponseEntity<Void> deleteOrderDetail(@PathVariable Long orderDetailId) {
        Optional<OrderDetail> orderDetail = orderDetailService.getOrderDetailById(orderDetailId);
        if (orderDetail.isPresent()) {
            orderDetailService.deleteOrderDetail(orderDetailId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
