package vn.hoidanit.laptopshop.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import vn.hoidanit.laptopshop.domain.user;

@Repository

public interface UserReponsitory extends JpaRepository<user, Long> {

    user save(user creatUser);

    List<user> findByEmail(String email);

    List<user> findAll();
}
