package com.ps20652.DATN.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.*;

@SuppressWarnings("serial")

@Entity
@Table(name = "Account")
@Data
public class Account implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;

    @Column(name = "username", length = 50)
    private String username;

    @Column(name = "password", length = 255)
    private String password;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "full_name", length = 100)
    private String fullName;

    @Column(name = "address", length = 100)
    private String address;

    @Column(name = "role", length = 50)
    private String role;
    
    @Column(name = "photo")
    private String photo;
    
    @Column(name = "otp")
    private String otp;
    
    @Column(name = "otp_created_at")
    private LocalDateTime otpCreatedAt;
    
}
