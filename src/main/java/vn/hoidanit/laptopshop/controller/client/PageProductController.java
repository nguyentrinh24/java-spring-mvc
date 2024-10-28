package vn.hoidanit.laptopshop.controller.client;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageProductController {
    @GetMapping("/product/{id}")
    public String getProduct() {
        return "/client/product/details";
    }

}
