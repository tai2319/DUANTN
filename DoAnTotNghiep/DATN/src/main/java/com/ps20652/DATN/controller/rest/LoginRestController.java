package com.ps20652.DATN.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ps20652.DATN.entity.Account;
import com.ps20652.DATN.service.AccountService;

@RestController
@RequestMapping("/api")
public class LoginRestController {
	@Autowired
	AccountService a_service;
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        // Thực hiện xác thực tài khoản ở đây
        if (authenticateUser(loginRequest.getUsername(), loginRequest.getPassword())) {
            return ResponseEntity.ok("Đăng nhập thành công");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Tên đăng nhập hoặc mật khẩu không đúng.");
        }
    }
    @GetMapping("/login")
	public List<Account> getAccounts() {
		return a_service.getAllAccounts();
	}

    // Hàm xác thực tài khoản (điều này cần được thay thế bằng xác thực thực tế)
    private boolean authenticateUser(String username, String password) {
        // Thực hiện xác thực tài khoản thực tế ở đây, ví dụ kiểm tra trong cơ sở dữ liệu.
        // Bạn có thể sử dụng một service hoặc repository để thực hiện xác thực tài khoản.

        // Ví dụ: Kiểm tra tài khoản trong cơ sở dữ liệu
        Account account = a_service.getAccountByUsername(username);

        if (account != null && account.getPassword().equals(password)) {
            // Tài khoản tồn tại và mật khẩu khớp
            return true;
        } else {
            // Tài khoản không tồn tại hoặc mật khẩu không khớp
            return false;
        }
    }


    // Lớp DTO (Data Transfer Object) để lấy thông tin đăng nhập từ client
    static class LoginRequest {
        private String username;
        private String password;

        // Constructors, getters và setters ở đây

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
    @PostMapping("/change-password/{userId}")
    public boolean changePassword(@PathVariable int userId, @RequestParam String newPassword) {
        return a_service.changePassword(userId, newPassword);
    }

    @PutMapping("/update-info/{userId}")
    public Account updateAccountInfo(@PathVariable int userId, @RequestBody Account updatedAccount) {
        return a_service.updateAccountInfo(userId, updatedAccount);
    }
    
}
