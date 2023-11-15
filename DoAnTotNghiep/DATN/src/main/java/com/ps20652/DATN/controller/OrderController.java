package com.ps20652.DATN.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ps20652.DATN.dao.OrderDAO;
import com.ps20652.DATN.entity.Account;
import com.ps20652.DATN.entity.Order;
import com.ps20652.DATN.entity.OrderDetail;
import com.ps20652.DATN.entity.Product;
import com.ps20652.DATN.service.OrderDetailService;
import com.ps20652.DATN.service.OrderService;
import com.ps20652.DATN.service.ProductService;

@Controller
public class OrderController {

	@Autowired
    private OrderDAO orderDAO;
	
    @Autowired
    private OrderService orderService;
    
    @Autowired
    private OrderDetailService orderDetailService;
    
    @Autowired
    private ProductService productService;
    
    

    @GetMapping("/orders")
    public String viewOrdersForUser(Model model, Principal principal, @RequestParam(name = "confirmationMessage", required = false) String confirmationMessage) {

        if (principal != null) {
            String username = principal.getName();
            List<Order> orders = orderService.getOrders(username);

            // Sắp xếp danh sách đơn hàng theo thời gian (order_date)
            Collections.sort(orders, Comparator.comparing(Order::getOrderDate).reversed());

            model.addAttribute("orders", orders);
        }
        
		   if (confirmationMessage != null) {
		         model.addAttribute("confirmationMessage", confirmationMessage);
		     }
		
        return "user/Orders";
        // Trả về trang hiển thị đơn hàng của người dùng sắp xếp theo thời gian
    }


//    @GetMapping("/orderDetails")
//    public String viewOrderDetails(@RequestParam Integer orderId, Model model) {
//        List<OrderDetail> orderDetails = orderDetailService.getOrderDeTails(orderId);
//        model.addAttribute("order", orderDetails);
//        return "user/OrderDetails"; // Trả về trang hiển thị chi tiết đơn hàng
//    }
    
    @GetMapping("/orderDetails")
    public String viewOrderDetails(@RequestParam Integer orderId, Model model) {
        Order order = orderService.getOrderById(orderId);
        model.addAttribute("order", order);
        return "user/orderDetails"; // Trả về trang hiển thị chi tiết đơn hàng
    }
    
    @PostMapping("/confirm")
    public String confirmOrder(@RequestParam("orderId") Integer orderId, RedirectAttributes redirectAttributes) {
        
            Order order = orderService.getOrderById(orderId);
            if (order != null) {
                order.setStatus("Đã giao hàng thành công"); // Thay đổi trạng thái đơn hàng
                orderService.updateOrder(order);
                
                redirectAttributes.addFlashAttribute("confirmationMessage", "Xác nhận đã nhận hàng thành công");
    }
            return "redirect:/orders";
            
   }
    
    @PostMapping("/cancel")
    public String cancelOrder(@RequestParam("orderId") Integer orderId,  RedirectAttributes redirectAttributes) {
      
            // Thực hiện hủy đơn hàng
            orderService.cancelOrder(orderId);
            redirectAttributes.addFlashAttribute("confirmationMessage", "Hủy đơn hàng thành công");
        
        return "redirect:/orders"; // Chuyển hướng người dùng đến trang danh sách đơn hàng của họ
    }
    
    @PostMapping("/reorder")
    public String reorder(@RequestParam("orderId") int orderId) {
        try {
            // Lấy thông tin đơn hàng dựa trên orderId
            Order order = orderDAO.findByOrderId(orderId);

            // Cập nhật trạng thái đơn hàng
            order.setStatus("Chờ xác nhận");

            // Lưu thay đổi trạng thái đơn hàng
            orderService.updateOrder(order);

            // Lấy thông tin chi tiết đơn hàng
            List<OrderDetail> orderDetails = orderDetailService.getOrderDeTails(orderId);

            // Duyệt qua từng sản phẩm trong đơn hàng và cập nhật số lượng sản phẩm trong kho
            for (OrderDetail orderDetail : orderDetails) {
                Product product = orderDetail.getProduct();

                // Cộng số lượng sản phẩm cũ trong kho với số lượng sản phẩm của đơn hàng
                int newQuantityInStock = product.getQuantityInStock() - orderDetail.getQuantity();
                product.setQuantityInStock(newQuantityInStock);

                // Lưu thay đổi số lượng sản phẩm trong kho
                productService.update(product);
            }

            return "redirect:/orders";
        } catch (Exception e) {
            // Xử lý lỗi nếu có
            return "redirect:/error";
        }


    
    }
}
