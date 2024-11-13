package vn.hoidanit.laptopshop.controller.client;

import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import vn.hoidanit.laptopshop.domain.Product;
import vn.hoidanit.laptopshop.domain.Role;
import vn.hoidanit.laptopshop.domain.User;
import vn.hoidanit.laptopshop.domain.DTO.RegisterDTO;
import vn.hoidanit.laptopshop.repository.RoleRepository;
import vn.hoidanit.laptopshop.service.ProductService;
import vn.hoidanit.laptopshop.service.UserService;

import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class PageProductController {
    private final ProductService pService;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    private final UserService userService;

    public PageProductController(ProductService pService, PasswordEncoder passwordEncoder,
            RoleRepository roleRepository, UserService userService) {
        this.pService = pService;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
        this.userService = userService;
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

        model.addAttribute("registerUser", new RegisterDTO());
        return "/client/auth/register";
    }

    @PostMapping("/register")
    public String postRegister(Model model,
            @ModelAttribute("registerUser") @Valid RegisterDTO registerDTO,
            BindingResult newUserBindingResult) {

        // validate
        if (newUserBindingResult.hasErrors()) {
            return "/client/auth/register";
        }
        User user = this.userService.registerDTOtoUser(registerDTO);

        String hashPassword = this.passwordEncoder.encode(user.getPassWord());
        user.setPassWord(hashPassword);
        Role roles = roleRepository.findByName("USER");
        user.setRole(roles);
        user.setPhone("null");
        user.setAvatar("null");
        this.userService.handleSaveUser(user);

        return "redirect:login";
    }

    @GetMapping("/login")
    public String getLogin(Model model) {

        return "client/auth/login";
    }
}
