package bg.softuni.pizzashop.web;

import bg.softuni.pizzashop.model.binding.OrderAddBindingModel;
import bg.softuni.pizzashop.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/order")
public class ShoppingCartController {

    private final ShoppingCartService shoppingCartService;

    @Autowired
    public ShoppingCartController(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @PostMapping("/cart")
    public String orderConfirm(OrderAddBindingModel orderAddBindingModel) {
        shoppingCartService.buyCart(orderAddBindingModel.getDescription());
        return "redirect:/order/cart";
    }

    @GetMapping("cart/remove/{id}")
    public String productRemove(@PathVariable(name = "id")Long id) {
        shoppingCartService.removeProduct(id);
        return "redirect:/order/cart";
    }

    @GetMapping("/cart")
    public String orderCart(Model model) {
        model.addAttribute("products", shoppingCartService.getProductsInCart());
        model.addAttribute("total", shoppingCartService.getTotal());
        return "order-user-cart";
    }

    @ModelAttribute
    public OrderAddBindingModel orderAddBindingModel() {
        return new OrderAddBindingModel();
    }
}
