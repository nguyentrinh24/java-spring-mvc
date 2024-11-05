package vn.hoidanit.laptopshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.hoidanit.laptopshop.domain.*;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
