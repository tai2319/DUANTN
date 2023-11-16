// package com.ps20652.DATN.controller;

// import com.ps20652.DATN.service.AccountQService;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestParam;

// @Controller
// public class PasswordController {

// @Autowired
// private AccountQService passwordResetService;

// @GetMapping("/forgot-password")
// public String showForgotPasswordForm() {
// return "forgot-password";
// }

// @PostMapping("/forgot-password")
// public String processForgotPassword(@RequestParam("email") String email,
// Model model) {
// try {
// passwordResetService.resetPassword(email);
// model.addAttribute("message", "Mật khẩu mới đã được gửi đến email của bạn.");
// } catch (Exception e) {
// model.addAttribute("error", "Không tìm thấy người dùng với địa chỉ email
// này.");
// e.printStackTrace();
// }
// return "forgot-password";
// }
// }
