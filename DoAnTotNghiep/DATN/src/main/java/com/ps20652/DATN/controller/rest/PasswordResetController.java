package com.ps20652.DATN.controller.rest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ps20652.DATN.service.AccountQService;


@RestController
@RequestMapping("/api/password-reset")
public class PasswordResetController {
    @Autowired
    private AccountQService accountQService;

    @PostMapping("/request")
    public ResponseEntity<String> requestPasswordReset(@RequestParam("email") String email) {
        accountQService.resetPassword(email);
        return ResponseEntity.ok("Email đã được gửi với mật khẩu mới.");
    }
}
