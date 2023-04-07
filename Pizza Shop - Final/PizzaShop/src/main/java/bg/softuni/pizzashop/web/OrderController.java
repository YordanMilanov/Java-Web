package bg.softuni.pizzashop.web;

import bg.softuni.pizzashop.model.binding.OrderAddBindingModel;
import bg.softuni.pizzashop.model.entity.Product;
import bg.softuni.pizzashop.model.entity.enums.OrderStatusEnum;
import bg.softuni.pizzashop.model.view.OrderViewModel;
import bg.softuni.pizzashop.repository.ProductRepository;
import bg.softuni.pizzashop.service.OrderService;
import bg.softuni.pizzashop.util.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

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

    @GetMapping("/cart")
    public String orderCart(Model model) {
        if(currentUser.getId() == null) {
            return "redirect:/users/login";
        }
        double totalSum = orderService.OrderTotalSum(currentUser.getCurrentOrder());
        currentUser.setOrderSum(totalSum);
       currentUser.getCurrentOrder().getProducts().sort(Comparator.comparing(Product::getId));

        model.addAttribute("OrderTotalSum", String.format("%.2f", currentUser.getOrderSum()));
        model.addAttribute("currentUser", currentUser);
        return "order-user-cart";
    }

    @GetMapping("cart/remove/{id}")
    public String orderCart(@PathVariable(name = "id")Long id) {

       orderService.removeItemFromCart(id);

        return "redirect:/order/cart";
    }

    @GetMapping("/active")
    public String orderActive(Model model) {
       model.addAttribute("allOrders", orderService.allOrdersByOrderStatus(OrderStatusEnum.IN_PROCESS));
        return "order-staff-active";
    }

    @GetMapping("/completed")
    public String orderCompleted(Model model) {
        model.addAttribute("allOrders", orderService.allOrdersByOrderStatus(OrderStatusEnum.FINISHED));
        return "order-staff-completed";
    }

    @PostMapping("/cart")
    public String orderConfirm() {
      orderService.addOrder(currentUser.getCurrentOrder());
        return "redirect:/order/cart";
    }

    @GetMapping("/view/{id}")
    public String orderView(@PathVariable(name = "id")Long id, Model model) {
        //sort the products by id
        OrderViewModel orderView = orderService.findByIdViewModel(id);
        orderService.sortProductsInOrder(orderView);
        model.addAttribute("order", orderView);
        return "order-view";
    }

    @GetMapping("active/finish/{id}")
    public String finishOrder(@PathVariable(name = "id")Long id) {
        orderService.finishOrder(orderService.findById(id));

        return "redirect:/order/active";
    }

    @ModelAttribute
    public OrderAddBindingModel orderAddBindingModel() {
        return new OrderAddBindingModel();
    }
}
