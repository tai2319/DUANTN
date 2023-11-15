package com.ps20652.DATN.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ps20652.DATN.entity.Order;

@Controller
public class ControllerTest {
	@GetMapping("/dashboard")
	 public String getAllOrders(Model model) {
	   
	     return "aaa/ui-buttons";
	 }
}
