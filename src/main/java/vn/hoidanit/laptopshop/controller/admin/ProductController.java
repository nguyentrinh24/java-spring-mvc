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
import vn.hoidanit.laptopshop.service.ProductService;
import vn.hoidanit.laptopshop.service.UploadService;

@Controller
public class ProductController {
    private final ProductService pService;
    private final UploadService upService;

    public ProductController(ProductService pService, UploadService upService) {
        this.pService = pService;
        this.upService = upService;
    }

    @GetMapping("admin/product")
    public String getProductPage(Model model) {
        List<Product> products = pService.findAll();
        model.addAttribute("arrProduct", products);
        return "admin/product/showProductPage";
    }

    // Display the form for creating a product (GET)
    @GetMapping("admin/product/createProduct")
    public String getPageCreateProduct(Model model) {
        model.addAttribute("productCreate", new Product());
        return "admin/product/createProduct";
    }

    // Save a new product (POST)
    @PostMapping("admin/product/createProduct")
    public String saveProduct(Model model,
            @Valid @ModelAttribute("productCreate") Product productCreate,
            BindingResult productBindingResult,
            @RequestParam("createImgProduct") MultipartFile file) {

        // validate
        if (productBindingResult.hasErrors()) {
            return "admin/product/create";
        }

        // upload image
        String image = this.upService.handleSaveUploadFile(file, "product");
        productCreate.setImage(image);

        this.pService.saveProduct(productCreate);

        return "redirect:/admin/product";
    }

    @GetMapping("admin/product/{id}")
    public String viewProduct(Model model, @PathVariable Long id) {
        Optional<Product> product = this.pService.getProductsById(id);
        if (product.isPresent()) {
            model.addAttribute("showProductPage", product.get());
            model.addAttribute("id", id);
            return "admin/product/detailsProduct";
        } else {
            return "error"; // You might want to handle this case more specifically
        }
    }

    @GetMapping("admin/product/update/{id}")
    public String updateProduct(Model model, @PathVariable Long id) {
        Optional<Product> product = this.pService.getProductsById(id);
        if (product.isPresent()) {
            model.addAttribute("productCreate", product.get());
            return "admin/product/updateProduct";
        } else {
            return "error";
        }
    }

    @PostMapping("admin/product/update")
    public String postUpdateUser(Model model,
            @Valid @ModelAttribute("productCreate") Product productCreate,
            BindingResult productBindingResult,
            @RequestParam("updateImg") MultipartFile file) {
        // validate
        if (productBindingResult.hasErrors()) {
            return "admin/product/update";
        }

        Product currentProduct = this.pService.getProductsById(productCreate.getId()).get();
        if (currentProduct != null) {
            // update new image
            if (!file.isEmpty()) {
                String img = this.upService.handleSaveUploadFile(file, "product");
                currentProduct.setImage(img);
            }

            currentProduct.setName(productCreate.getName());
            currentProduct.setPrice(productCreate.getPrice());
            currentProduct.setQuantity(productCreate.getQuantity());
            currentProduct.setDetailDesc(productCreate.getDetailDesc());
            currentProduct.setShortDesc(productCreate.getShortDesc());
            currentProduct.setFactory(productCreate.getFactory());
            currentProduct.setTarget(productCreate.getTarget());

            this.pService.saveProduct(currentProduct);
        }

        return "redirect:/admin/product";
    }

    @RequestMapping("admin/product/delete/{id}")
    public String getDeletePage(Model model, @PathVariable Long id) {
        model.addAttribute("id", id);
        Product product = new Product();
        product.setId(id);
        model.addAttribute("deleteProduct", product); // Updated attribute name
        return "admin/product/deleteProduct";
    }

    @PostMapping("admin/product/delete/{id}")
    public String postDeletePage(@PathVariable Long id) {
        this.pService.deleteProduct(id);
        return "redirect:/admin/product";
    }
}
