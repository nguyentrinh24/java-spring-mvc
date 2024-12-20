package vn.trinhnguyen.laptopshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import vn.trinhnguyen.laptopshop.domain.User;

@Repository

public interface UserReponsitory extends JpaRepository<User, Long> {

    User save(User creatUser);

    List<User> findByEmail(String email);

    List<User> findAll();

    boolean existsByEmail(String email);

    User findUserByEmail(String email);

}
