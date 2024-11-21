package vn.trinhnguyen.laptopshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.trinhnguyen.laptopshop.domain.*;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
