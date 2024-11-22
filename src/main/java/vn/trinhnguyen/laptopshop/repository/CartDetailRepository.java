package vn.trinhnguyen.laptopshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.trinhnguyen.laptopshop.domain.CartDetail;

public interface CartDetailRepository extends JpaRepository<CartDetail, Long> {

}
