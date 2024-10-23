package vn.hoidanit.laptopshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DashbroadController {
    @GetMapping("/admin")
    public String getMethodName() {
        return "/admin/dashbroad/dashbroadPage";
    }

}
