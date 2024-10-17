package vn.hoidanit.laptopshop.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import vn.hoidanit.laptopshop.domain.user;
import vn.hoidanit.laptopshop.repository.UserReponsitory;
import vn.hoidanit.laptopshop.service.UserService;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// @RestController
// public class UserController { 
//     private  UserService userService;
//     public UserController(UserService userService) {
//         this.userService = userService;
//     }
//     @GetMapping("/hello")
//     public String getHomePage()
//     {
//         String test= this.userService.handlHello();
//         return test;
//     }
// }

@Controller
public class UserController<repository> {

    // private static final String UserService = null;
    // private UserService userService;
    // public UserController(UserService userService) {
    // this.userService = userService;
    // }
    // @RequestMapping("/")
    // public String getHomePage(Model model) {
    // String test = this.userService.handlHello();
    // model.addAttribute("trinh", test);

    // return "hello";
    // }
    // @RequestMapping("/admin/user")
    // public String userCreate(Model model) {

    // return "admin/user/create";
    // }
    private final UserService userService;

    public UserController(UserService userService, UserReponsitory userReponsitory) {
        this.userService = userService;

    }

    // TRANG CHỦ
    @RequestMapping(value = "/", method = { RequestMethod.POST,
            RequestMethod.GET })

    public String getCreate1(Model model, @ModelAttribute("userCreate") user createUser) {
        List<user> arrEmail = this.userService.findByEmail("spagetti24072002@gmail.com");
        System.out.println(arrEmail);

        System.out.println("run here " + createUser);
        this.userService.handleUser(createUser);
        return "hello";
    }

    // TABLE USER
    @RequestMapping(value = "admin/user")

    public String getTableCreate(Model mode) {
        List<user> users = userService.findAll();

        mode.addAttribute("new user", new user());
        return "admin/user/tableUser";
    }

    // CREATE USER

    @RequestMapping(value = "admin/user/create", method = { RequestMethod.POST,
            RequestMethod.GET })
    public String getPageCreateUser(Model model, @ModelAttribute("userCreate") user createUser) {
        user users = userService.handleUser(createUser);
        model.addAttribute("createUser", new user());
        return "admin/user/create";
    }

    //
}
