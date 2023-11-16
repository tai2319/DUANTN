package com.ps20652.DATN.controller;

import com.ps20652.DATN.DAO.ProductDAO;
import com.ps20652.DATN.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductDAO productRepository;

    @GetMapping
    public String listProducts(Model model) {
        List<Product> products = productRepository.findAll();
        model.addAttribute("products", products);
        return "product";
    }

    @GetMapping("/searchByName")
    public String searchProductsByName(
            @RequestParam(name = "name", required = false) String name,
            Model model
    ) {
        List<Product> products;

        if (name != null) {
            // Tìm sản phẩm theo tên
            products = productRepository.findByName(name);
        } else {
            // Nếu không có tên được cung cấp, hiển thị tất cả sản phẩm
            products = productRepository.findAll();
        }

        model.addAttribute("products", products);
        return "product";
    }

    @GetMapping("/searchByPrice")
    public String searchProductsByPriceRange(
            @RequestParam(name = "minPrice", required = false) Double minPrice,
            @RequestParam(name = "maxPrice", required = false) Double maxPrice,
            Model model
    ) {
        List<Product> products;

        if (minPrice != null && maxPrice != null) {
            // Lọc sản phẩm theo khoảng giá từ minPrice đến maxPrice
            products = productRepository.findByPriceBetween(minPrice, maxPrice);
        } else if (minPrice != null) {
            // Lọc sản phẩm theo giá tối thiểu (minPrice)
            products = productRepository.findByPriceGreaterThanEqual(minPrice);
        } else if (maxPrice != null) {
            // Lọc sản phẩm theo giá tối đa (maxPrice)
            products = productRepository.findByPriceLessThanEqual(maxPrice);
        } else {
            // Nếu không có giá nào được cung cấp, hiển thị tất cả sản phẩm
            products = productRepository.findAll();
        }

        model.addAttribute("products", products);
        return "product";
    }

}

