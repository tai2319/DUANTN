package com.ps20652.DATN.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ps20652.DATN.entity.Category;
import com.ps20652.DATN.entity.CustomerFeedback;
import com.ps20652.DATN.entity.Product;
import com.ps20652.DATN.service.AccountService;
import com.ps20652.DATN.service.CategoryService;
import com.ps20652.DATN.service.FeedbackService;
import com.ps20652.DATN.service.OrderDetailService;
import com.ps20652.DATN.service.ProductService;
import com.ps20652.DATN.service.ShoppingCartService;

@Controller
public class HomeController {

    @GetMapping({ "", "home/index" })
    public String home() {
        return "component/index";
    }

    @GetMapping("/about")
    public String About() {
        return "component/About";
    }

    @GetMapping("/new")
    public String New() {
        return "component/New";
    }

    @GetMapping("/contact")
    public String Contact() {
        return "component/Contact";

    }

    @GetMapping("/listproduct")
    public String Listpro() {
        return "product/list";
    }

    @GetMapping("/cart")
    public String Cart() {
        return "cart/cart";
    }

    @GetMapping("/login")
    public String login() {
        return "Security/login";
    }

    @GetMapping("/register")
    public String Register() {
        return "Security/register";
    }

    @GetMapping("/details")
    public String Details() {
        return "product/productdetail";
    }
    // @GetMapping("/detail")
    // public String product() {
    // return " /product/productdetail";
    // }

    // @GetMapping({ "admin", "admin/home/index" })
    // public String admin() {
    // return "redirect:/assets/admin/index.html";
    // }
}
