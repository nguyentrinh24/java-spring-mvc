package vn.trinhnguyen.laptopshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import vn.trinhnguyen.laptopshop.domain.Product;
import vn.trinhnguyen.laptopshop.repository.ProductRepository;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final UploadService uploadService;

    public ProductService(ProductRepository productRepository, UploadService uploadService) {
        this.productRepository = productRepository;
        this.uploadService = uploadService;
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
}
