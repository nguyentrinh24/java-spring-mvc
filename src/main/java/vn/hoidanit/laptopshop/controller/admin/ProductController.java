package vn.hoidanit.laptopshop.controller.admin;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import vn.hoidanit.laptopshop.domain.Product;
import vn.hoidanit.laptopshop.repository.*;
import vn.hoidanit.laptopshop.service.*;

@Controller
public class ProductController {
    private final ProductService pService;

    public ProductController(ProductService pService) {
        this.pService = pService;
    }

    @GetMapping(value = "admin/product")
    public String getMethodName(Model model) {
        List<Product> product = pService.findAll();
        model.addAttribute("arrProduct", product);

        return "/admin/product/showProductPage";
    }

    // Phương thức này hiển thị form để tạo người dùng (GET)
    @GetMapping("/admin/product/createProduct")
    public String getPageCreateUser(Model model, @ModelAttribute("productCreate") Product productCreate) {
        // Thêm đối tượng user mới vào model để sử dụng trong form tạo người dùng
        model.addAttribute("productCreate", new Product());
        return "/admin/product/createProduct"; // Trả về view create
    }

}
