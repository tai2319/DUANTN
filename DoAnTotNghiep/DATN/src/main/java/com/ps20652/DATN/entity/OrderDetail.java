package com.ps20652.DATN.entity;

import lombok.Data;

import javax.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
@SuppressWarnings("serial")
@Entity
@Table(name = "Orderdetails")
@Data
public class OrderDetail implements Serializable{
	  @Id
	    @Column(name = "order_detail_id")
	    private Long orderdetailId;

	    @ManyToOne
	    @JoinColumn(name = "order_id")
	    private Order order;

	    @ManyToOne
	    @JoinColumn(name = "product_id")
	    private Product product;

	    @Column(name = "quantity")
	    private Integer quantity;

	    @Column(name = "price", precision = 10, scale = 2)
	    private BigDecimal price;

	    // Getters and setters

	    public Long getOrderDetailId() {
	        return orderdetailId;
	    }

	    public void setOrderDetailId(Long orderDetailId) {
	        this.orderdetailId = orderDetailId;
	    }

	    public Order getOrder() {
	        return order;
	    }

	    public void setOrder(Order order) {
	        this.order = order;
	    }

	    public Product getProduct() {
	        return product;
	    }

	    public void setProduct(Product product) {
	        this.product = product;
	    }

	    public Integer getQuantity() {
	        return quantity;
	    }

	    public void setQuantity(Integer quantity) {
	        this.quantity = quantity;
	    }

	    public BigDecimal getPrice() {
	        return price;
	    }

	    public void setPrice(BigDecimal price) {
	        this.price = price;
	    }
}
