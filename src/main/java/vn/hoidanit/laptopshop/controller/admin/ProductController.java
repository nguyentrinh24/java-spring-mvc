package vn.hoidanit.laptopshop.controller.admin;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import jakarta.validation.Valid;
import vn.hoidanit.laptopshop.domain.Product;
import vn.hoidanit.laptopshop.domain.User;
import vn.hoidanit.laptopshop.service.ProductService;
import vn.hoidanit.laptopshop.service.UploadService;

@Controller
public class ProductController {
    private final ProductService pService;
    private final UploadService uService;

    public ProductController(ProductService pService, UploadService uService) {
        this.pService = pService;
        this.uService = uService;
    }

    @GetMapping(value = "admin/product")
    public String getProductPage(Model model) {
        List<Product> products = pService.findAll();
        model.addAttribute("arrProduct", products);

        return "/admin/product/showProductPage";
    }

    // Display the form for creating a product (GET)
    @GetMapping("/admin/product/createProduct")
    public String getPageCreateProduct(Model model,
            @ModelAttribute("productCreate") Product productCreate) {
        model.addAttribute("productCreate", new Product());
        return "/admin/product/createProduct"; // Return the create view for product
    }

    // Save a new product (POST)
    @PostMapping("/admin/product/create")
    public String saveProduct(Model model,
            @Valid @ModelAttribute("productCreate") Product productCreate,
            BindingResult productBindingResult,
            @RequestParam("hoidanitFile") MultipartFile file) {

        // Print validation errors, if any
        List<FieldError> errors = productBindingResult.getFieldErrors();
        for (FieldError error : errors) {
            System.out.println(error.getField() + " - " + error.getDefaultMessage());
        }

        if (productBindingResult.hasErrors()) {
            // Return to the create product page if there are validation errors
            return "/admin/product/createProduct";
        }

        // Handle file upload and set the product's image
        String avatar = this.uService.handleSaveUploadFile(file, "product");
        productCreate.setImage(avatar);

        // Save the product
        this.pService.saveProducts(productCreate);

        // Redirect to the product list page
        return "redirect:/admin/product";
    }

    @GetMapping("/admin/product/{id}")
    public String viewProduct(Model model, @PathVariable(name = "id", required = true) Long id) {
        System.out.println("ID received: " + id);
        Optional<Product> product = this.pService.getProductsById(id);
        if (product.isPresent()) {
            model.addAttribute("showProductPage", product.get());
            model.addAttribute("id", id);
            return "admin/product/detailsProduct";
        } else {
            return "hello";
        }
    }

    @GetMapping("/admin/product/update/{id}")
    public String updateUser(Model model, @PathVariable Long id) {
        Optional<Product> product = this.pService.getProductsById(id);
        if (product.isPresent()) {
            model.addAttribute("productCreate", product.get());
            return "/admin/product/updateProduct";
        } else {
            return "hello";
        }
    }

    @PostMapping("/admin/product/update")
    public String postUpdateUser(Model model,
            @Valid @ModelAttribute("productCreate") Product productCreate,
            BindingResult productBindingResult,
            @RequestParam("hoidanitFile") MultipartFile file) {
        Optional<Product> product = this.pService.getProductsById(productCreate.getId());
        System.out.println(productCreate.getId());
        if (product.isPresent()) {

            Product updateProduct = product.get();
            updateProduct.setName(productCreate.getName());
            updateProduct.setPrice(productCreate.getPrice());
            updateProduct.setDetailDesc(productCreate.getDetailDesc());
            updateProduct.setShortDesc(productCreate.getShortDesc());
            updateProduct.setQuanity(productCreate.getQuanity());
            updateProduct.setFactory(productCreate.getFactory());
            updateProduct.setTarget(productCreate.getTarget());
            if (!file.isEmpty()) {
                String img = this.uService.handleSaveUploadFile(file, "product");
                updateProduct.setImage(img);
            }

            this.pService.saveProducts(updateProduct);
            return "redirect:/admin/product";
        } else {
            return "hello";
        }
    }

    @RequestMapping(value = "/admin/product/delete/{id}")
    public String getDeletePage(Model model, @PathVariable Long id) {
        model.addAttribute("id", id);
        Product product = new Product();
        product.setId(id);
        model.addAttribute("deleteUser", product);
        return "admin/product/deleteProduct";
    }

    @PostMapping("/admin/product/delete/{id}")
    public String postDeletePage(Model model, @PathVariable Long id,
            @ModelAttribute("deleteProduct") User deleteProduct) {
        this.pService.deleteProduct(deleteProduct.getId());
        return "redirect:/admin/product";
    }

}
