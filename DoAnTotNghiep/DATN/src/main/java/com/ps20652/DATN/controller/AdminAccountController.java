// package com.ps20652.DATN.controller;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.ModelAttribute;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.RestController;

// import org.springframework.web.servlet.mvc.support.RedirectAttributes;

// import com.ps20652.DATN.DAO.AccountDAO;
// import com.ps20652.DATN.entity.Account;

// import com.ps20652.DATN.entity.ProductDTO;

// @Controller
// @RequestMapping("/admin/accounts")
// public class AdminAccountController {

// @Autowired

// private AccountDAO accountRepository;

// @GetMapping
// public String listAccounts(Model model) {
// List<Account> account = accountRepository.findAll();
// model.addAttribute("accounts", account);
// return "admin-account";
// }

// @PostMapping("/add")
// public String addAccount(@ModelAttribute("account") Account account) {
// // Thực hiện lưu tài khoản vào cơ sở dữ liệu thông qua accountService
// accountRepository.save(account);
// return "redirect:/admin/accounts"; // Sau khi thêm tài khoản, chuyển hướng
// đến danh sách tài khoản
// }

// @GetMapping("edit/{userId}")
// public String showEditAccountForm(@PathVariable("userId") Integer userId,
// Model model) {
// // Lấy sản phẩm từ cơ sở dữ liệu theo productId
// Account account = accountRepository.getById(userId);

// // Kiểm tra xem sản phẩm có tồn tại hay không
// if (account == null) {
// return "redirect:/admin/accounts";
// }

// // Đưa sản phẩm vào model để hiển thị trong biểu mẫu chỉnh sửa
// // ProductDTO productDTO = new ProductDTO();
// // productDTO.setProductId(product.getProductId());
// // productDTO.setName(product.getName());
// // productDTO.setDescription(product.getDescription());
// // productDTO.setPrice(product.getPrice());
// // productDTO.setQuantityInStock(product.getQuantityInStock());
// // productDTO.setCategory(product.getCategory());
// // productDTO.setImage(null); // Đặt giá trị trống cho trường image, bạn có
// thể đặt lại đường dẫn hình ảnh cũ ở đây

// model.addAttribute("account", account);

// return "edit-account";
// }

// // @PostMapping("/edit")
// // public String editAccount(@ModelAttribute("account") Account account) {
// // accountRepository.save(account);
// // return "redirect:/account/view/{userId}";
// // }

// @PostMapping("/edit/{userId}")
// public String handleEditProductForm(@ModelAttribute("userId") Account
// account,
// @ModelAttribute("productDTO") ProductDTO editedProduct, RedirectAttributes
// redirectAttributes) {

// accountRepository.save(account);

// return "redirect:/admin/accounts";
// }

// @GetMapping("/delete/{userId}")
// public String deleteAccount(@PathVariable("userId") Integer userId,
// RedirectAttributes redirectAttributes) {
// try {
// // Kiểm tra xem sản phẩm có tồn tại không
// Account account = accountRepository.getById(userId);
// if (account != null) {
// // Nếu sản phẩm tồn tại, thực hiện xóa sản phẩm
// accountRepository.delete(account);
// redirectAttributes.addFlashAttribute("successMessage", "Tài khoản đã được xóa
// thành công.");
// } else {
// // Nếu sản phẩm không tồn tại, hiển thị thông báo lỗi
// redirectAttributes.addFlashAttribute("errorMessage", "Không tìm thấy Tài
// khoản để xóa.");
// }
// } catch (Exception e) {
// // Xử lý lỗi nếu có
// redirectAttributes.addFlashAttribute("errorMessage", "Đã xảy ra lỗi khi xóa
// Tài Khoản");
// }

// return "redirect:/admin/accounts";
// }
// @GetMapping("/searchName")
// public String searchName(@RequestParam("username") String username, Model
// model) {
// // Sử dụng phương thức tìm kiếm theo tên từ ProductDAO
// // Đây là ví dụ tìm kiếm theo tên sản phẩm
// List<Account> searchResults = accountRepository.findByUsername(username);

// model.addAttribute("accounts", searchResults);

// return "admin-account"; // Trả về view để hiển thị kết quả tìm kiếm
// }

// @GetMapping("/searchId")
// public String searchId(@RequestParam("userId") Integer userId, Model model) {
// // Sử dụng phương thức tìm kiếm theo Id từ ProductDAO
// // Đây là ví dụ tìm kiếm theo Id sản phẩm
// Account searchResults = accountRepository.findById(userId).orElse(null);

// model.addAttribute("accounts", searchResults);

// return "admin-account"; // Trả về view để hiển thị kết quả tìm kiếm
// }
// }
