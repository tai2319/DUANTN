package com.ps20652.DATN.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ps20652.DATN.DAO.AccountDAO;
import com.ps20652.DATN.entity.Account;
import com.ps20652.DATN.service.AccountService;
@Controller
public class LoginController {
	@Autowired
    private AccountService accountService;
	@Autowired
    private AccountDAO AccDAO;


    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String processLogin(@RequestParam String username, @RequestParam String password) {
        Account user = AccDAO.findByUsernameAndPassword(username, password);
        if (user != null) {
            return "login";
        } else {
            return "redirect:/register";
        }
    }

}    
    

