package vn.hoidanit.laptopshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import vn.hoidanit.laptopshop.domain.user;
import vn.hoidanit.laptopshop.repository.UserReponsitory;

@Service
public class UserService {
    private final UserReponsitory userReponsitory;

    public UserService(UserReponsitory userReponsitory) {
        this.userReponsitory = userReponsitory;
    }

    public user handleSaveUser(user creatUser) {
        return userReponsitory.save(creatUser);
    }

    public List<user> findByEmail(String email) {
        return userReponsitory.findByEmail(email);
    }

    public List<user> findAll() {
        return userReponsitory.findAll();
    }

    public Optional<user> getUsersById(Long id) {
        return userReponsitory.findById(id);
    }

    public void deleteUsers(long id) {
        this.userReponsitory.deleteById(id);
    }

}
