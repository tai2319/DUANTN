package com.ps20652.DATN.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    // @GetMapping("/detail")
    // public String product() {
    // return " /product/productdetail";
    // }

    // @GetMapping({ "admin", "admin/home/index" })
    // public String admin() {
    // return "redirect:/assets/admin/index.html";
    // }
}
