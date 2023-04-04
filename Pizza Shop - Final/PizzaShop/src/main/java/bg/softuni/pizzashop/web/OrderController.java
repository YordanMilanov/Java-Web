package bg.softuni.pizzashop.web;

import bg.softuni.pizzashop.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }


    @GetMapping("/active")
    public String orderActive(Model model) {
        return "order-staff-active";
       // model.addAttribute("allOrders", orderService.allOrders());
    }

    @GetMapping("/completed")
    public String orderCompleted() {
        return "order-staff-completed";
    }
}
