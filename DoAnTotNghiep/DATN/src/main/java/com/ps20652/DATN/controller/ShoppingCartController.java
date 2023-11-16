package com.ps20652.DATN.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ps20652.DATN.entity.Account;
import com.ps20652.DATN.entity.UserCart;
import com.ps20652.DATN.service.AccountService;
import com.ps20652.DATN.service.ShoppingCartService;

@Controller
@RequestMapping("/cart")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;
    
    @Autowired
    private AccountService userRepository;
    
    @GetMapping
    public String viewCart(Model model, Principal principal, @RequestParam(name = "errorMessage", required = false) String errorMessage) {
        if (principal != null) {
            // Lấy userID của người dùng đăng nhập
            String username = principal.getName();
            int userId = getUserIDByUsername(username);
            
            // Sử dụng userId để lấy giỏ hàng
            List<UserCart> cartItems = shoppingCartService.findByAccountUserId(userId);

            // Tính tổng tiền của giỏ hàng
            int cartAmount = calculateCartAmount(cartItems);
            
            model.addAttribute("cartItems", cartItems);
            model.addAttribute("cartAmount", cartAmount);
            
 		   if (errorMessage != null) {
 		         model.addAttribute("errorMessage", errorMessage);
 		     }
        }

        return "user/cart";
    }

    @PostMapping("/addItem")
    public String addToCart(@RequestParam Integer productId, Principal principal) {
        if (principal != null) {
            // Lấy userID của người dùng đăng nhập
            String username = principal.getName();
            int userId = getUserIDByUsername(username);

            // Thêm sản phẩm vào giỏ hàng của người dùng
            shoppingCartService.add(userId, productId);
            
            return "redirect:/";
        } else {
            // Người dùng chưa đăng nhập, chuyển họ đến trang đăng nhập
            return "redirect:/login";
        }
    }

    @PostMapping("/removeItem")
    public String removeFromCart(@RequestParam Integer productId, Principal principal) {
        if (principal != null) {
            // Lấy userID của người dùng đăng nhập
            String username = principal.getName();
            int userId = getUserIDByUsername(username);
            
            // Xóa sản phẩm khỏi giỏ hàng của người dùng
            shoppingCartService.remove(userId, productId);
        }
        return "redirect:/cart";
    }

    @PostMapping("/updateItem")
    public String updateCartItem(@RequestParam Integer productId, @RequestParam("qty") int quantity, Principal principal) {
        if (principal != null) {
            // Lấy userID của người dùng đăng nhập
            String username = principal.getName();
            int userId = getUserIDByUsername(username);
            
            // Cập nhật số lượng sản phẩm trong giỏ hàng của người dùng
            shoppingCartService.update(userId, productId, quantity);
        }
        return "redirect:/cart";
    }
    private int getUserIDByUsername(String username) {
        // Sử dụng Spring Data JPA để truy vấn cơ sở dữ liệu
        Account user = userRepository.findByUsername(username);

        if (user != null) {
            return user.getUserId(); // Trả về userID từ đối tượng User
        }

        return -1; // Trường hợp không tìm thấy user
    }
    private int calculateCartAmount(List<UserCart> cartItems) {
        int totalAmount = 0;
        for (UserCart item : cartItems) {
            totalAmount += item.getProduct().getPrice() * item.getQuantity();
        }
        return totalAmount;
    }
}