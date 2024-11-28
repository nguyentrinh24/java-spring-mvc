package vn.trinhnguyen.laptopshop.controller.client;

import java.util.ArrayList;
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

import vn.trinhnguyen.laptopshop.domain.Cart;
import vn.trinhnguyen.laptopshop.domain.CartDetail;
import vn.trinhnguyen.laptopshop.domain.Product;
import vn.trinhnguyen.laptopshop.domain.Role;
import vn.trinhnguyen.laptopshop.domain.User;
import vn.trinhnguyen.laptopshop.domain.DTO.RegisterDTO;
import vn.trinhnguyen.laptopshop.repository.RoleRepository;
import vn.trinhnguyen.laptopshop.service.ProductService;
import vn.trinhnguyen.laptopshop.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;

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

    @GetMapping("product/{id}")
    public String getProduct(Model model, @PathVariable long id) {
        Optional<Product> products = this.pService.getProductsById(id);
        if (products.isPresent()) {
            model.addAttribute("productCreate", products.get());
            return "client/product/details";

        }

        return "404";

    }

    @GetMapping("register")
    public String getRegister(Model model) {

        model.addAttribute("registerUser", new RegisterDTO());
        return "client/auth/register";
    }

    @PostMapping("product-add-to-cart/{id}")
    public String postMethodCart(@PathVariable long id, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        Long idProduct = id;
        String email = (String) session.getAttribute("email");
        this.pService.handleAddProductToCart(email, idProduct, session);
        return "redirect:/";
    }

    @GetMapping("cart")
    public String getMethodCart(Model model, HttpServletRequest request) {
        User currentUser = new User();
        HttpSession serSession = request.getSession(false);
        long id = (long) serSession.getAttribute("id"); // lấy id của người dùng từ session
        currentUser.setId(id);

        Cart cart = this.pService.fetchByUser(currentUser);
        if (cart == null) {
            // Tạo 1 cart mới nếu rỗng
            cart = new Cart();
            cart.setCartDetails(new ArrayList<>());

        }
        List<CartDetail> cartDetails = cart.getCartDetails();

        double totalPrice = 0;
        for (CartDetail cartDetail : cartDetails) {
            totalPrice += cartDetail.getPrice() * cartDetail.getQuantity();
        }
        model.addAttribute("cartDetails", cartDetails);
        model.addAttribute("totalPrice", totalPrice);
        return "client/cart/show";
    }

    @PostMapping("delete-cart-product/{id}")
    public String postMethodName(Model model, HttpServletRequest request, @PathVariable long id) {
        HttpSession serSession = request.getSession(false);
        long cartDetailId = id;
        this.pService.handleCartRemove(cartDetailId, serSession);
        return "redirect:/cart";
    }

    @PostMapping("register")
    public String postRegister(Model model,
            @ModelAttribute("registerUser") @Valid RegisterDTO registerDTO,
            BindingResult newUserBindingResult) {

        // validate
        if (newUserBindingResult.hasErrors()) {
            return "client/auth/register";
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

    @GetMapping("login")
    public String getLogin(Model model) {

        return "client/auth/login";
    }

    @GetMapping("accessDenied")
    public String getDenied(Model model) {

        return "client/auth/denied";
    }
}
