package vn.hoidanit.laptopshop.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class UserService {
    private UserService userService;
    

    public UserService(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("")
    public String getHandlHello(){
        return this.userService.getHandlHello();
    }
}
