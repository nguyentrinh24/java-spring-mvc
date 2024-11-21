package vn.hoidanit.laptopshop.controller.admin;

import java.util.List;
import java.util.Optional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import vn.hoidanit.laptopshop.domain.User;
import vn.hoidanit.laptopshop.domain.Role;
import vn.hoidanit.laptopshop.repository.UserReponsitory;
import vn.hoidanit.laptopshop.repository.RoleRepository;
import vn.hoidanit.laptopshop.service.UploadService;
import vn.hoidanit.laptopshop.service.UserService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.Valid;

@Controller
public class UserController {

    private final UserService userService;
    private final UploadService uploadService;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    public UserController(UserService userService,
            UserReponsitory userReponsitory,
            UploadService uploadService,
            PasswordEncoder passwordEncoder,
            RoleRepository roleRepository) {
        this.userService = userService;
        this.uploadService = uploadService;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }

    @RequestMapping(value = "/admin/user")
    public String handldeTableCreate(Model mode) {
        List<User> users = userService.findAll();
        mode.addAttribute("arrUser", users);
        return "admin/user/showUser";
    }

    @GetMapping("/admin/user/{id}")
    public String viewUser(Model model, @PathVariable Long id) {
        Optional<User> users = this.userService.getUsersById(id);
        if (users.isPresent()) {
            model.addAttribute("showUser", users.get());
            model.addAttribute("id", id);
            return "admin/user/detailUser";
        } else {
            return "errorPage";
        }
    }

    @GetMapping("admin/user/create")
    public String getPageCreateUser(Model model, @ModelAttribute("userCreate") User createUser) {
        model.addAttribute("createUser", new User());
        return "admin/user/create";
    }

    @PostMapping("admin/user/create")
    public String saveTableUser(Model model,
            @Valid @ModelAttribute("userCreate") User createUser,
            BindingResult newUserBindingResult,
            @RequestParam("hoidanitFile") MultipartFile file) {
        List<FieldError> errors = newUserBindingResult.getFieldErrors();
        for (FieldError error : errors) {
            System.out.println(error.getField() + " - " + error.getDefaultMessage());
        }

        if (newUserBindingResult.hasErrors()) {

            return "admin/user/create"; // Trả về trang tạo nếu có lỗi
        }

        String avatar = this.uploadService.handleSaveUploadFile(file, "avatar");
        String hashPassword = this.passwordEncoder.encode(createUser.getPassWord());

        createUser.setAvatar(avatar);
        createUser.setPassWord(hashPassword);

        Role roles = roleRepository.findByName(createUser.getRole().getName());
        createUser.setRole(roles);

        this.userService.handleSaveUser(createUser);

        return "redirect:/admin/user";
    }

    @GetMapping("/admin/user/update/{id}")
    public String updateUser(Model model, @PathVariable Long id) {
        Optional<User> users = this.userService.getUsersById(id);
        if (users.isPresent()) {
            model.addAttribute("userCreate", users.get());
            return "admin/user/updateUser";
        } else {
            return "errorPage";
        }
    }

    @RequestMapping(value = "/admin/user/update", method = { RequestMethod.GET, RequestMethod.POST })
    public String postUpdateUser(Model model, @ModelAttribute("userCreate") User createUser) {
        Optional<User> users = this.userService.getUsersById(createUser.getId());
        if (users.isPresent()) {
            User updateUser = users.get();
            updateUser.setAddress(createUser.getAddress());
            updateUser.setPhone(createUser.getPhone());
            updateUser.setFullName(createUser.getFullName());
            updateUser.setEmail(createUser.getEmail());

            this.userService.handleSaveUser(updateUser);
            return "redirect:/admin/user";
        } else {
            return "errorPage";
        }
    }

    @RequestMapping(value = "/admin/user/delete/{id}")
    public String getDeletePage(Model model, @PathVariable Long id) {
        model.addAttribute("id", id);
        User user = new User();
        user.setId(id);
        model.addAttribute("deleteUser", user);
        return "admin/user/deleteUser";
    }

    @PostMapping("/admin/user/delete/{id}")
    public String postDeletePage(Model model, @PathVariable Long id, @ModelAttribute("deleteUser") User deleteUser) {
        this.userService.deleteUsers(deleteUser.getId());
        return "redirect:/admin/user";
    }
}
