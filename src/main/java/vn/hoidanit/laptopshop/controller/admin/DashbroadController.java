package vn.hoidanit.laptopshop.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashbroadController {
    @GetMapping("admin")
    public String getMethodName() {
        return "admin/dashbroad/dashbroadPage";
    }

}
