package bg.softuni.pizzashop.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/order")
public class OrderController {

    @GetMapping("/active")
    public String orderActive() {
        return "order-staff-active";
    }

    @GetMapping("/completed")
    public String orderCompleted() {
        return "order-staff-completed";
    }
}
