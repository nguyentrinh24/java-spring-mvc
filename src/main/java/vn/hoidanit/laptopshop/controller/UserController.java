package vn.hoidanit.laptopshop.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import vn.hoidanit.laptopshop.domain.role;
import vn.hoidanit.laptopshop.domain.user;
import vn.hoidanit.laptopshop.repository.UserReponsitory;
import vn.hoidanit.laptopshop.repository.RoleRepository;
import vn.hoidanit.laptopshop.service.UploadService;
import vn.hoidanit.laptopshop.service.UserService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UserController {

    // Khai báo đối tượng UserService để xử lý logic nghiệp vụ
    private final UserService userService;
    private final UploadService uploadService;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    // Constructor để tiêm phụ thuộc (UserService và UserRepository)
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

    // Phương thức này xử lý cả yêu cầu GET và POST tới trang chủ ('/')
    // Kiểm tra người dùng bằng email và lưu người dùng nếu được truyền qua model
    // @RequestMapping(value = "/", method = { RequestMethod.POST, RequestMethod.GET
    // })
    // public String getCreate1(Model model, @ModelAttribute("userCreate") user
    // createUser) {
    // // Tìm danh sách người dùng theo email đã được chỉ định
    // List<user> arrEmail =
    // this.userService.findByEmail("spagetti24072002@gmail.com");
    // // In ra danh sách người dùng đã tìm được
    // System.out.println(arrEmail);

    // // In ra thông tin của người dùng đang được tạo
    // System.out.println("run here " + createUser);
    // // Lưu người dùng đã được tạo
    // this.userService.handleSaveUser(createUser);
    // return "hello";
    // }

    // Phương thức này hiển thị danh sách người dùng trong bảng (table)
    @RequestMapping(value = "/admin/user")
    public String handldeTableCreate(Model mode) {
        // Lấy danh sách tất cả người dùng từ dịch vụ
        List<user> users = userService.findAll();
        // Đưa danh sách người dùng vào model để hiển thị ở view
        mode.addAttribute("arrUser", users);
        return "admin/user/showUser"; // Trả về view tableUser
    }

    // hiển thị thông tin user
    @GetMapping("/admin/user/{id}")
    public String viewUser(Model model, @PathVariable Long id) {
        Optional<user> users = this.userService.getUsersById(id);
        // Kiểm tra xem user có tồn tại không
        if (users != null) {
            model.addAttribute("showUser", users.get()); // Truyền user vào JSP users.get() sẽ lấy đối tượng user ra từ
                                                         // Optional nếu nó tồn tại.
            model.addAttribute("id", id); // Truyền id để hiển thị
            return "admin/user/detailUser"; // Trả về trang JSP
        } else {
            return "errorPage"; // Nếu không tìm thấy user, chuyển hướng sang trang lỗi
        }
    }

    // Phương thức này hiển thị form để tạo người dùng (GET)
    @GetMapping("/admin/user/create")
    public String getPageCreateUser(Model model, @ModelAttribute("userCreate") user createUser) {
        // Thêm đối tượng user mới vào model để sử dụng trong form tạo người dùng
        model.addAttribute("createUser", new user());
        return "/admin/user/create"; // Trả về view create
    }

    // Phương thức này xử lý khi người dùng submit form tạo người dùng (POST)
    @PostMapping("/admin/user/create")
    public String saveTableUser(Model model, @ModelAttribute("userCreate") user createUser,
            @RequestParam("hoidanitFile") MultipartFile file) {

        // Lưu người dùng vừa được tạo thông qua dịch vụ
        // this.userService.handleSaveUser(createUser);
        String avatar = this.uploadService.handleSaveUploadFile(file, "avatar");
        String hasdPassword = this.passwordEncoder.encode(createUser.getPassWord());

        createUser.setAvatar(avatar);
        createUser.setPassWord(hasdPassword);
        // save role
        role roles = roleRepository.findByName(createUser.getRole().getName());
        createUser.setRole(roles);

        // Chuyển hướng tới trang danh sách người dùng sau khi tạo thành công
        return "redirect:/admin/user";
    }

    // gọi tới update user
    @GetMapping("/admin/user/update/{id}")
    public String updateUser(Model model, @PathVariable Long id) {
        Optional<user> users = this.userService.getUsersById(id);
        if (users != null) {
            model.addAttribute("userCreate", users.get());

            return "admin/user/updateUser"; // Trả về trang JSP
        } else {
            return "errorPage";
        }
    }

    // gọi tới update user
    @RequestMapping(value = "/admin/user/update", method = { RequestMethod.GET, RequestMethod.POST })
    public String postUpdateUser(Model model, @ModelAttribute("userCreate") user createUser) {
        Optional<user> users = this.userService.getUsersById(createUser.getId()); // Fetch user by ID
        if (users.isPresent()) { // Check if user exists
            user updateUser = users.get();

            // Set the updated fields from the form submission
            updateUser.setAddress(createUser.getAddress());
            updateUser.setPhone(createUser.getPhone()); // Set the phone number
            updateUser.setFullName(createUser.getFullName()); // Set the full name
            updateUser.setEmail(createUser.getEmail()); // Set the email if needed

            // Save the updated user
            this.userService.handleSaveUser(updateUser);

            // Redirect back to the main user page
            return "redirect:/admin/user";
        } else {
            // If user not found, show error page
            return "errorPage";
        }
    }

    @RequestMapping(value = "/admin/user/delete/{id}")
    public String getDeletePage(Model model, @PathVariable Long id) {
        model.addAttribute("id", id);
        user user = new user();
        user.setId(id);
        model.addAttribute("deleteUser", user);
        return "admin/user/deleteUser";
    }

    @PostMapping("/admin/user/delete/{id}")
    public String posrDeletePage(Model model, @PathVariable Long id, @ModelAttribute("deleteUser") user deleteUser) {
        this.userService.deleteUsers(deleteUser.getId());
        return "redirect:/admin/user";
    }

}
