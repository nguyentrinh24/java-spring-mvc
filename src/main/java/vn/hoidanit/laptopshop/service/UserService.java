package vn.hoidanit.laptopshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import vn.hoidanit.laptopshop.domain.user;
import vn.hoidanit.laptopshop.repository.UserReponsitory;

@Service
public class UserService {
    private final UserReponsitory userReponsitory;

    public UserService(UserReponsitory userReponsitory) {
        this.userReponsitory = userReponsitory;
    }

    public user handleUser(user creatUser) {
        return userReponsitory.save(creatUser);
    }

    public List<user> findByEmail(String email) {
        return userReponsitory.findByEmail(email);
    }

    public List<user> findAll() {
        return userReponsitory.findAll();
    }

}
