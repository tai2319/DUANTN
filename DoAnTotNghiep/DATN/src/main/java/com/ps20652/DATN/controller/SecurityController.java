//package com.ps20652.DATN.controller;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller
//@RequestMapping("login")
//public class SecurityController {
//	
//	@GetMapping("login/form")
//	public String loginForm(Model model) {
//		model.addAttribute("message", "Vui lòng đăng nhập!");
//		return "login";
//	}
//	
//	@GetMapping("login/success")
//	public String loginSuccess(Model model) {
//		model.addAttribute("message", "Đăng nhập thành công!");
//		return "login";
//	}
//	
//	@GetMapping("login/error")
//	public String loginError(Model model) {
//		model.addAttribute("message", "Sai thông tin đăng nhập!");
//		return "login";
//	}
//	
//	@GetMapping("unauthorized")
//	public String unauthorized(Model model) {
//		model.addAttribute("message", "Không có quyền truy xuất!");
//		return "login";
//	}
//	
//	@GetMapping("logoff/success")
//	public String logoffSuccess(Model model) {
//		model.addAttribute("message", "Bạn đã đăng xuất!");
//		return "login";
//	}
//}
