package vn.hoidanit.laptopshop.controller.client;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import vn.hoidanit.laptopshop.domain.Product;
import vn.hoidanit.laptopshop.domain.RegisterDTO;
import vn.hoidanit.laptopshop.service.ProductService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class PageProductController {
    private final ProductService pService;

    public PageProductController(ProductService pService) {
        this.pService = pService;
    }

    @GetMapping("/product/{id}")
    public String getProduct(Model model, @PathVariable long id) {
        Optional<Product> products = this.pService.getProductsById(id);
        if (products.isPresent()) {
            model.addAttribute("productCreate", products.get());
            return "/client/product/details";

        }

        return "404";

    }

    @GetMapping("/register")
    public String getRegister(Model model) {
        model.addAttribute("registerUser", model);
        return "/client/auth/register";
    }

    @PostMapping("/register")
    public String postRegister(Model model, @ModelAttribute("registerUser") RegisterDTO registerDTO) {

        return "/client/auth/register";
    }

}
