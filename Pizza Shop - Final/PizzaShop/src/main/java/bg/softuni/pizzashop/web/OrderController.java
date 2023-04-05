package bg.softuni.pizzashop.web;

import bg.softuni.pizzashop.model.binding.OrderAddBindingModel;
import bg.softuni.pizzashop.repository.ProductRepository;
import bg.softuni.pizzashop.service.OrderService;
import bg.softuni.pizzashop.util.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;
    private final CurrentUser currentUser;
    private final ProductRepository productRepository;

    public OrderController(OrderService orderService, CurrentUser currentUser, ProductRepository productRepository) {
        this.orderService = orderService;
        this.currentUser = currentUser;
        this.productRepository = productRepository;
    }

    @GetMapping("")
    public String order(Model model) {
        if(currentUser.getId() == null) {
            return "redirect:/users/login";
        }
        model.addAttribute("currentUser", currentUser);
        return "order-user-cart";
    }

    @GetMapping("/remove/{id}")
    public String order(@PathVariable(name = "id")Long id, Model model) {

       orderService.removeItemFromCart(id);

        return "redirect:/order";
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

    @PostMapping("/")
    public String orderConfirm(OrderAddBindingModel orderAddBindingModel) {

        orderService.addOrder();

        return "index";
    }

    @ModelAttribute
    public OrderAddBindingModel orderAddBindingModel() {
        return new OrderAddBindingModel();
    }
}
