package com.ps20652.DATN.entity;

import lombok.Data;

import java.io.Serializable;

import javax.persistence.*;
@SuppressWarnings("serial")
@Entity
@Table(name = "Categories")
@Data
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private int categoryId;

    @Column(name = "name", length = 100)
    private String name;
}
