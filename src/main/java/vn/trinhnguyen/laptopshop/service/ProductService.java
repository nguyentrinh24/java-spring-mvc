package vn.trinhnguyen.laptopshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpSession;
import vn.trinhnguyen.laptopshop.domain.Cart;
import vn.trinhnguyen.laptopshop.domain.CartDetail;
import vn.trinhnguyen.laptopshop.domain.Product;
import vn.trinhnguyen.laptopshop.domain.User;
import vn.trinhnguyen.laptopshop.repository.CartDetailRepository;
import vn.trinhnguyen.laptopshop.repository.CartRepository;
import vn.trinhnguyen.laptopshop.repository.ProductRepository;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final UploadService uploadService;
    private final CartRepository cartRepository;
    private final CartDetailRepository cartDetailRepository;
    private final UserService userService;

    public ProductService(ProductRepository productRepository, UploadService uploadService,
            CartRepository cartRepository, CartDetailRepository cartDetailRepository, UserService userService) {
        this.productRepository = productRepository;
        this.uploadService = uploadService;
        this.cartRepository = cartRepository;
        this.cartDetailRepository = cartDetailRepository;
        this.userService = userService;
    }

    public ProductRepository getProductRepository() {
        return productRepository;
    }

    public UploadService getUploadService() {
        return uploadService;
    }

    public CartRepository getCartRepository() {
        return cartRepository;
    }

    public CartDetailRepository getCartDetailRepository() {
        return cartDetailRepository;
    }

    public UserService getUserService() {
        return userService;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product saveProduct(Product product) {

        return productRepository.save(product);
    }

    public Optional<Product> getProductsById(Long id) {
        return productRepository.findById(id);
    }

    public void deleteProduct(long id) {
        productRepository.deleteById(id);
    }

    public void handleAddProductToCart(String email, Long id, HttpSession session) {
        User user = this.userService.getUserByEmail(email);
        if (user != null) {
            // Kiểm tra và tạo giỏ hàng nếu chưa có
            Cart cart = this.cartRepository.findByUser(user);
            if (cart == null) {
                cart = new Cart();
                cart.setUser(user);
                cart.setSum(0);
                cart = this.cartRepository.save(cart);
            }

            Optional<Product> productOptional = this.productRepository.findById(id);
            if (productOptional.isPresent()) {
                Product realProduct = productOptional.get();
                Optional<CartDetail> oldDetailOptional = this.cartDetailRepository.findByCartAndProduct(cart,
                        realProduct);

                if (oldDetailOptional.isEmpty()) {
                    CartDetail cd = new CartDetail();
                    cd.setCart(cart);
                    cd.setProduct(realProduct);
                    cd.setPrice(realProduct.getPrice());
                    cd.setQuantity(1);
                    this.cartDetailRepository.save(cd);

                    // Cập nhật tổng số lượng
                    int s = cart.getSum() + 1;
                    cart.setSum(s);
                    this.cartRepository.save(cart);
                    session.setAttribute("sum", s);
                } else {
                    CartDetail oldDetail = oldDetailOptional.get();
                    oldDetail.setQuantity(oldDetail.getQuantity() + 1);
                    this.cartDetailRepository.save(oldDetail);
                }
            }
        }
    }

}
