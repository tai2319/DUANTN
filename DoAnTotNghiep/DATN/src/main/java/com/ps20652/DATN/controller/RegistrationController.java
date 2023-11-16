// package com.ps20652.DATN.controller;

// import com.ps20652.DATN.entity.Account;
// import com.ps20652.DATN.service.AccountService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;

// @Controller
// public class RegistrationController {

// private final AccountService accountService;

// @Autowired
// public RegistrationController(AccountService accountService) {
// this.accountService = accountService;
// }

// @GetMapping("/register")
// public String showRegistrationForm(Model model) {
// model.addAttribute("account", new Account());
// return "register";
// }

// @PostMapping("/register")
// public String register(Account account) {
// // Xử lý đăng ký tài khoản ở đây
// account.setRole("ROLE_USER"); // Thiết lập vai trò mặc định, bạn có thể thay
// đổi tùy theo yêu cầu

// accountService.saveAccount(account);

// // Chuyển hướng sau khi đăng ký thành công (ví dụ: trang chủ)
// return "register";
// }
// }
