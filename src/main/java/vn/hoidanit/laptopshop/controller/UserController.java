package vn.hoidanit.laptopshop.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import vn.hoidanit.laptopshop.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

     @RequestMapping("/")
    
     public String getHomePage() {
         return "hello.html";
     }
     
}
