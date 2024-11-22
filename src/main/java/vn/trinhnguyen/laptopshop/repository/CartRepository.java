package vn.trinhnguyen.laptopshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.trinhnguyen.laptopshop.domain.Cart;
import vn.trinhnguyen.laptopshop.domain.User;

public interface CartRepository extends JpaRepository<Cart, Long> {

    Cart findByUser(User user);
}