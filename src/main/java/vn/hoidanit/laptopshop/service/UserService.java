package vn.hoidanit.laptopshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import vn.hoidanit.laptopshop.domain.user;
import vn.hoidanit.laptopshop.repository.UserReponsitory;
import vn.hoidanit.laptopshop.repository.RoleRepository;

@Service
public class UserService {
    private final UserReponsitory userReponsitory;
    private final RoleRepository roleRepository;

    public UserService(UserReponsitory userReponsitory,
            RoleRepository roleRepository) {
        this.userReponsitory = userReponsitory;
        this.roleRepository = roleRepository;
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

    public void getByName(String name) {
        this.roleRepository.findByName(name);
    }

}
