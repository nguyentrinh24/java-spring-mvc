package vn.hoidanit.laptopshop.controller.client;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import vn.hoidanit.laptopshop.domain.Product;
import vn.hoidanit.laptopshop.repository.ProductRepository;

@Controller
public class HomePageController {
    private final ProductRepository pRepository;

    public HomePageController(ProductRepository pRepository) {
        this.pRepository = pRepository;
    }

    @GetMapping("/")
    public String getHomePage(Model model) {
        List<Product> products = pRepository.findAll();
        model.addAttribute("productHome", products);
        return "client/homepage/ShowHomePage";
    }

}
