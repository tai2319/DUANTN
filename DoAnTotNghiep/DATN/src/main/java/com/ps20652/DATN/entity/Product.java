package com.ps20652.DATN.entity;

import lombok.Data;

import javax.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
@SuppressWarnings("serial")
@Entity
@Table(name = "Products")
@Data
public class Product implements Serializable{
	   @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "product_id")
	    private int productId;

	    @Column(name = "name", length = 255)
	    private String name;

	    @Column(name = "description", length = 200)
	    private String description;

	    @Column(name = "price")
	    private Double price;
	    
	    @Column(name = "price_staff")
	    private Double priceStaff;

	    @Column(name = "quantity_in_stock")
	    private int quantityInStock;

	    @ManyToOne
	    @JoinColumn(name = "category_id")
	    private Category category;

	   
	    @Column(name = "image")
	    private String image;
}

