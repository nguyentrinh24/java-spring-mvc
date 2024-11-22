package vn.trinhnguyen.laptopshop.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.trinhnguyen.laptopshop.domain.Cart;
import vn.trinhnguyen.laptopshop.domain.CartDetail;
import vn.trinhnguyen.laptopshop.domain.Product;

public interface CartDetailRepository extends JpaRepository<CartDetail, Long> {

    boolean existsByCartAndProduct(Cart cart, Product product);

    Optional<CartDetail> findByCartAndProduct(Cart cart, Product product);

}
