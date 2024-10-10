package vn.hoidanit.laptopshop.controller;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;

import vn.hoidanit.laptopshop.service.UserService;


@RestController
public class UserController {
    
    private  UserService userService;
    

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("")
    public String getHomePage()
    {

        return this.userService.handlHello();
    }
    
    
}
