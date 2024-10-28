package vn.hoidanit.laptopshop.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {
    @GetMapping(value = "admin/product")
    public String getMethodName() {
        return "/admin/product/productPage";
    }

}
