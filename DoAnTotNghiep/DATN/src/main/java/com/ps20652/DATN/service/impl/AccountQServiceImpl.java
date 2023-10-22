package com.ps20652.DATN.service.impl;

import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.ps20652.DATN.DAO.AccountDAO;
import com.ps20652.DATN.entity.Account;
import com.ps20652.DATN.service.AccountQService;

@Service
public class AccountQServiceImpl implements AccountQService {
	@Autowired
    private AccountDAO userRepository;

    @Autowired
    private JavaMailSender emailSender;

    @Override
    public void resetPassword(String userEmail) {
        // Kiểm tra xem email tồn tại trong cơ sở dữ liệu
    	Account user = userRepository.findByEmail(userEmail);
    	try {
    		
            if (user == null) {
            
            }
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
        

        // Tạo mật khẩu mới
        String newPassword = generateRandomPassword();

        // Lưu mật khẩu mới vào cơ sở dữ liệu
        user.setPassword(newPassword);
        userRepository.save(user);

        // Gửi email với mật khẩu mới
        sendPasswordResetEmail(userEmail, newPassword);
    }

    private void sendPasswordResetEmail(String userEmail, String newPassword) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(userEmail);
        message.setSubject("Mật khẩu mới");
        message.setText("Mật khẩu mới của bạn là: " + newPassword);
        emailSender.send(message);
    }

    private String generateRandomPassword() {
        // Tạo mật khẩu ngẫu nhiên, ví dụ sử dụng UUID
        return UUID.randomUUID().toString();
    }

		
	

}
