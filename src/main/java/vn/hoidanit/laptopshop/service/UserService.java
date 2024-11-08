package vn.hoidanit.laptopshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import vn.hoidanit.laptopshop.domain.User;
import vn.hoidanit.laptopshop.domain.DTO.RegisterDTO;
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

    public User handleSaveUser(User creatUser) {
        return userReponsitory.save(creatUser);
    }

    public List<User> findByEmail(String email) {
        return userReponsitory.findByEmail(email);
    }

    public List<User> findAll() {
        return userReponsitory.findAll();
    }

    public Optional<User> getUsersById(Long id) {
        return userReponsitory.findById(id);
    }

    public void deleteUsers(long id) {
        this.userReponsitory.deleteById(id);
    }

    public void getByName(String name) {
        this.roleRepository.findByName(name);
    }

    public User registerDTOtoUser(RegisterDTO registerDTO) {
        User user = new User();
        user.setFullName(registerDTO.getFirstName() + "" + registerDTO.getLastName());
        user.setEmail(registerDTO.getEmail());
        user.setPassWord(registerDTO.getPassword());

        return user;
    }

}
