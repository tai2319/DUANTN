package com.ps20652.DATN.entity;

import org.springframework.web.multipart.MultipartFile;

public class ProductDTO {
    private int productId;
    private String name;
    private String description;
    private double price;
    private int quantityInStock;
    private MultipartFile image;
    private Category category;

    // Getter methods
    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public MultipartFile getImage() {
        return image;
    }

    public Category getCategory() {
        return category;
    }

    // Setter methods
    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}

