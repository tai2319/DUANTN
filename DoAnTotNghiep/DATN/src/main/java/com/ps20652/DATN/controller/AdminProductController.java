// package com.ps20652.DATN.controller;

// import java.io.File;
// import java.io.FileOutputStream;
// import java.io.IOException;
// import java.io.InputStream;
// import java.io.OutputStream;
// import java.nio.file.Files;
// import java.nio.file.Path;
// import java.nio.file.Paths;
// import java.nio.file.StandardCopyOption;
// import java.util.Base64;
// import java.util.List;
// import java.util.Optional;
// import java.util.UUID;

// import javax.servlet.ServletContext;
// import javax.servlet.http.HttpServletRequest;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.core.io.Resource;
// import org.springframework.core.io.ResourceLoader;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.util.StringUtils;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.ModelAttribute;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.multipart.MultipartFile;
// import org.springframework.web.servlet.mvc.support.RedirectAttributes;

// import com.ps20652.DATN.DAO.ProductDAO;
// import com.ps20652.DATN.entity.Product;
// import com.ps20652.DATN.entity.ProductDTO;

// @Controller
// @RequestMapping("/admin/products")
// public class AdminProductController {

// @Autowired
// private ResourceLoader resourceLoader;

// @Autowired
// private ProductDAO productRepository;

// @GetMapping
// public String listProducts(Model model) {
// List<Product> products = productRepository.findAll();
// model.addAttribute("products", products);
// return "admin-product";
// }

// @PostMapping("/add")
// public String addProduct(@ModelAttribute("productDTO") ProductDTO productDTO,
// @RequestParam("image") MultipartFile image) {
// Product product = new Product();

// // Xử lý tải lên hình ảnh
// String imageString = "Logo.png"; // Giá trị mặc định
// if (!image.isEmpty()) {
// try {
// // Đường dẫn lưu trữ hình ảnh
// // Path path = Paths.get("DATN/src/main/resources/static/assets/images/");
// // String uploadPath = servletContext.getRealPath("/assets/images/"); //
// Đường dẫn tuyệt đối
// // Path path = Paths.get(uploadPath);

// // Lấy đường dẫn thực của dự án
// Resource resource = resourceLoader.getResource("classpath:/");
// String projectPath = resource.getFile().getAbsolutePath();

// // Đường dẫn lưu trữ hình ảnh
// String uploadPath = projectPath + "/static/assets/images/";
// Path path = Paths.get(uploadPath);

// // Lấy đường dẫn thực của dự án
// // Resource resource = resourceLoader.getResource("classpath:");
// // String projectPath = resource.getURI().getPath();

// // Đường dẫn lưu trữ hình ảnh
// // String uploadPath = projectPath + "assets/images/";
// // Path path = Paths.get(uploadPath);

// // Lưu trữ hình ảnh vào thư mục uploads
// Files.copy(image.getInputStream(), path.resolve(image.getOriginalFilename()),
// StandardCopyOption.REPLACE_EXISTING);

// // Lấy tên hình ảnh đã lưu
// imageString = image.getOriginalFilename();
// } catch (IOException e) {
// e.printStackTrace();
// // Xử lý lỗi khi tải lên hình ảnh
// // Có thể xem xét việc báo lỗi cho người dùng
// }
// }

// // Thiết lập dữ liệu cho sản phẩm
// product.setName(productDTO.getName());
// product.setDescription(productDTO.getDescription());
// // product.setPrice(productDTO.getPrice());
// product.setQuantityInStock(productDTO.getQuantityInStock());
// product.setCategory(productDTO.getCategory());
// product.setImage(imageString);

// // Lưu sản phẩm vào cơ sở dữ liệu
// productRepository.save(product);

// // Chuyển hướng đến trang danh sách sản phẩm sau khi thêm
// return "redirect:/admin/products";
// }

// // private String saveImage(MultipartFile image) throws IOException {
// // String fileName = StringUtils.cleanPath(image.getOriginalFilename());
// // String uploadDir = "D:\\";
// // String filePath = Paths.get(uploadDir, fileName).toString();
// //
// // // Tạo đường dẫn lưu trữ
// // Path storagePath = Paths.get(uploadDir);
// // if (!Files.exists(storagePath)) {
// // Files.createDirectories(storagePath);
// // }
// //
// // // Lưu trữ tệp hình ảnh
// // try (InputStream inputStream = image.getInputStream()) {
// // Path destination = Paths.get(filePath);
// // Files.copy(inputStream, destination, StandardCopyOption.REPLACE_EXISTING);
// // }
// //
// // return "/" + filePath;
// // }

// // Hàm để lưu tệp hình ảnh và trả về đường dẫn
// // private String saveImage(MultipartFile imageFile) {
// // try {
// // // Xử lý lưu trữ tệp hình ảnh và trả về đường dẫn
// // // Ví dụ: lưu vào thư mục trên máy chủ
// //
// // String uploadDirectory =
// "D:\\java5\\DATN\\src\\main\\resources\\static\\assets\\images";
// // String fileName = imageFile.getOriginalFilename();
// // String filePath = Paths.get(uploadDirectory, fileName).toString();
// //
// // // Lưu tệp hình ảnh vào đường dẫn đã xác định
// // Files.copy(imageFile.getInputStream(), Paths.get(filePath));
// //
// // // Trả về đường dẫn hình ảnh sau khi lưu
// // return fileName; // Đường dẫn được cấu hình dựa trên thư mục assets/images
// // } catch (IOException e) {
// // e.printStackTrace();
// // // Xử lý lỗi nếu có
// // return null; // Trả về null hoặc đường dẫn mặc định nếu có lỗi
// // }

// // try {
// // String filename = imageFile.getOriginalFilename();
// // // String path = app.getRealPath("/images/"+filename);
// // File file = new File(app.getRealPath("/images/" + filename));
// // imageFile.transferTo(file);
// // model.addAttribute("name", image.getOriginalFilename());
// // model.addAttribute("type", image.getContentType());
// // model.addAttribute("size", image.getSize());
// // return "admin/adminTableProduct";
// // } catch (Exception e) {
// // model.addAttribute("message", "Lỗi lưu file !");
// // }
// // return null;
// //
// // }

// // @RequestMapping("/uploadFile")
// // public String upload(ModelMap model, @RequestParam("image") MultipartFile
// image) {
// //
// // try {
// // String filename = image.getOriginalFilename();
// // // String path = app.getRealPath("/images/"+filename);
// // File file = new File(app.getRealPath("/images/" + filename));
// // image.transferTo(file);
// // model.addAttribute("name", image.getOriginalFilename());
// //// model.addAttribute("type", image.getContentType());
// //// model.addAttribute("size", image.getSize());
// // return "admin/adminTableProduct";
// // } catch (Exception e) {
// //// model.addAttribute("message", "Lỗi lưu file !");
// // }
// //
// // return "redirect:/tableProduct";
// // }

// @GetMapping("edit/{productId}")
// public String showEditProductForm(@PathVariable("productId") Integer
// productId, Model model) {
// // Lấy sản phẩm từ cơ sở dữ liệu theo productId
// Product product = productRepository.getById(productId);

// // Kiểm tra xem sản phẩm có tồn tại hay không
// if (product == null) {
// return "redirect:/admin/products";
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

// model.addAttribute("product", product);

// return "edit-product";
// }

// // Xử lý lưu thông tin chỉnh sửa sản phẩm
// // @PostMapping("/edit/{productId}")
// // public String handleEditProductForm(@PathVariable("productId") Integer
// productId,
// // @ModelAttribute("editedProduct") Product editedProduct, RedirectAttributes
// redirectAttributes,
// // Model model) {
// // // Ở đây, bạn cần thực hiện cập nhật thông tin của sản phẩm trong cơ sở dữ
// liệu
// // // dựa trên editedProduct
// // // Giả sử bạn có một ProductService để thực hiện cập nhật sản phẩm.
// //
// // try {
// // productRepository.save(editedProduct);
// // redirectAttributes.addFlashAttribute("successMessage", "Sản phẩm đã được
// cập nhật thành công.");
// // } catch (Exception e) {
// // redirectAttributes.addFlashAttribute("errorMessage", "Đã xảy ra lỗi khi
// cập nhật sản phẩm.");
// // }
// //
// // return "redirect:/admin/products";
// // }
// @PostMapping("/edit/{productId}")
// public String handleEditProductForm(@PathVariable("productId") Integer
// productId,
// @ModelAttribute("productDTO") ProductDTO editedProduct, RedirectAttributes
// redirectAttributes, @RequestParam("image") MultipartFile image) {
// try {
// Product existingProduct = productRepository.findById(productId).orElse(null);
// if (existingProduct == null) {
// // Nếu sản phẩm không tồn tại, bạn có thể thực hiện xử lý phù hợp ở đây, ví
// dụ: hiển thị thông báo lỗi
// return "redirect:/admin/products";
// }

// // Cập nhật thông tin sản phẩm từ editedProduct

// // Xử lý tải lên hình ảnh và cập nhật đường dẫn ảnh

// Product product = productRepository.getById(productId);
// String img = product.getImage();

// String imageString = img; // Giá trị của img cũ
// if (!image.isEmpty()) {
// try {
// // Đường dẫn lưu trữ hình ảnh
// // Path path = Paths.get("DATN/src/main/resources/static/assets/images/");
// // String uploadPath = servletContext.getRealPath("/assets/images/"); //
// Đường dẫn tuyệt đối
// // Path path = Paths.get(uploadPath);

// // Lấy đường dẫn thực của dự án
// Resource resource = resourceLoader.getResource("classpath:/");
// String projectPath = resource.getFile().getAbsolutePath();

// // Đường dẫn lưu trữ hình ảnh
// String uploadPath = projectPath + "/static/assets/images/";
// Path path = Paths.get(uploadPath);

// // Lấy đường dẫn thực của dự án
// // Resource resource = resourceLoader.getResource("classpath:");
// // String projectPath = resource.getURI().getPath();

// // Đường dẫn lưu trữ hình ảnh
// // String uploadPath = projectPath + "assets/images/";
// // Path path = Paths.get(uploadPath);

// // Lưu trữ hình ảnh vào thư mục uploads
// Files.copy(image.getInputStream(), path.resolve(image.getOriginalFilename()),
// StandardCopyOption.REPLACE_EXISTING);

// // Lấy tên hình ảnh đã lưu
// imageString = image.getOriginalFilename();
// } catch (IOException e) {
// e.printStackTrace();
// // Xử lý lỗi khi tải lên hình ảnh
// // Có thể xem xét việc báo lỗi cho người dùng
// }
// }

// existingProduct.setName(editedProduct.getName());
// existingProduct.setDescription(editedProduct.getDescription());
// // existingProduct.setPrice(editedProduct.getPrice());
// existingProduct.setQuantityInStock(editedProduct.getQuantityInStock());
// existingProduct.setImage(imageString);

// // Lưu sản phẩm đã cập nhật vào cơ sở dữ liệu
// productRepository.save(existingProduct);

// redirectAttributes.addFlashAttribute("successMessage", "Sản phẩm đã được cập
// nhật thành công.");
// } catch (Exception e) {
// redirectAttributes.addFlashAttribute("errorMessage", "Đã xảy ra lỗi khi cập
// nhật sản phẩm.");
// }

// return "redirect:/admin/products";
// }

// // Hàm lưu trữ hình ảnh vào thư mục và trả về đường dẫn đã lưu
// // private String saveImageFile(MultipartFile imageFile) {
// // String imageString = "Logo.png"; // Giá trị mặc định
// // if (!imageFile.isEmpty()) {
// // try {
// // // Đường dẫn lưu trữ hình ảnh
// //// Path path = Paths.get("DATN/src/main/resources/static/assets/images/");
// //// String uploadPath = servletContext.getRealPath("/assets/images/"); //
// Đường dẫn tuyệt đối
// //// Path path = Paths.get(uploadPath);
// //
// // // Lấy đường dẫn thực của dự án
// // Resource resource = resourceLoader.getResource("classpath:/");
// // String projectPath = resource.getFile().getAbsolutePath();
// //
// // // Đường dẫn lưu trữ hình ảnh
// // String uploadPath = projectPath + "/static/assets/images/";
// // Path path = Paths.get(uploadPath);
// //
// //
// //
// // // Lấy đường dẫn thực của dự án
// //// Resource resource = resourceLoader.getResource("classpath:");
// //// String projectPath = resource.getURI().getPath();
// //
// // // Đường dẫn lưu trữ hình ảnh
// //// String uploadPath = projectPath + "assets/images/";
// //// Path path = Paths.get(uploadPath);
// //
// //
// // // Lưu trữ hình ảnh vào thư mục uploads
// // Files.copy(imageFile.getInputStream(),
// path.resolve(imageFile.getOriginalFilename()),
// StandardCopyOption.REPLACE_EXISTING);
// //
// // // Lấy tên hình ảnh đã lưu
// // imageString = imageFile.getOriginalFilename();
// // } catch (IOException e) {
// // e.printStackTrace();
// // // Xử lý lỗi khi tải lên hình ảnh
// // // Có thể xem xét việc báo lỗi cho người dùng
// // }
// // }
// // return imageString;
// //
// // // Trả về đường dẫn tới tệp hình ảnh đã lưu
// // }

// @GetMapping("/delete/{productId}")
// public String deleteProduct(@PathVariable("productId") Integer productId,
// RedirectAttributes redirectAttributes) {
// try {
// // Kiểm tra xem sản phẩm có tồn tại không
// Product product = productRepository.getById(productId);
// if (product != null) {
// // Nếu sản phẩm tồn tại, thực hiện xóa sản phẩm
// productRepository.delete(product);
// redirectAttributes.addFlashAttribute("successMessage", "Sản phẩm đã được xóa
// thành công.");
// } else {
// // Nếu sản phẩm không tồn tại, hiển thị thông báo lỗi
// redirectAttributes.addFlashAttribute("errorMessage", "Không tìm thấy sản phẩm
// để xóa.");
// }
// } catch (Exception e) {
// // Xử lý lỗi nếu có
// redirectAttributes.addFlashAttribute("errorMessage", "Đã xảy ra lỗi khi xóa
// sản phẩm.");
// }

// return "redirect:/admin/products";
// }

// @GetMapping("/searchName")
// public String searchProductsNAME(@RequestParam("name") String productName,
// Model model) {
// // Sử dụng phương thức tìm kiếm theo tên từ ProductDAO
// // Đây là ví dụ tìm kiếm theo tên sản phẩm
// List<Product> searchResults = productRepository.findByName(productName);

// model.addAttribute("products", searchResults);

// return "admin-product"; // Trả về view để hiển thị kết quả tìm kiếm
// }

// @GetMapping("/searchId")
// public String searchProductsID(@RequestParam("productId") Integer productId,
// Model model) {
// // Sử dụng phương thức tìm kiếm theo Id từ ProductDAO
// // Đây là ví dụ tìm kiếm theo Id sản phẩm
// Product searchResults = productRepository.findById(productId).orElse(null);

// model.addAttribute("products", searchResults);

// return "admin-product"; // Trả về view để hiển thị kết quả tìm kiếm
// }

// @GetMapping("/searchPrice")
// public String price(HttpServletRequest request, Model model,
// @RequestParam("min")double min,
// @RequestParam("max")double max) {
// //List<Product> items = dao.findByPriceBetween(min, max);

// List<Product> searchResults = productRepository.findByPrice(min, max);
// model.addAttribute("products", searchResults);

// return "admin-product"; // Trả về view để hiển thị kết quả lọc
// }

// }
