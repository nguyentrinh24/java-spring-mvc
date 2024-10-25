package vn.hoidanit.laptopshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import vn.hoidanit.laptopshop.domain.role;

@Repository
public interface RoleRepository extends JpaRepository<role, Long> {
    role findByName(String name);
}
