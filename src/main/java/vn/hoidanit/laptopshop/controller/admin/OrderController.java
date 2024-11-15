package vn.hoidanit.laptopshop.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrderController {
    @GetMapping(value = "admin/order")
    public String getMethodName() {
        return "admin/order/orderPage";
    }

}
