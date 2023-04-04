package bg.softuni.pizzashop.web;

import bg.softuni.pizzashop.model.entity.enums.ProductTypeEnum;
import bg.softuni.pizzashop.service.OrderService;
import bg.softuni.pizzashop.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/menu")
public class MenuController {

    private final ProductService productService;
    private final OrderService orderService;

    public MenuController(ProductService productService, OrderService orderService) {
        this.productService = productService;
        this.orderService = orderService;
    }

    @GetMapping("/pizza")
    public String pizza(Model model) {
        model.addAttribute("allPizza", productService.allProductsByType(ProductTypeEnum.PIZZA));
        return "menu-pizza";
    }

    @GetMapping("/pasta")
    public String pasta() {
        return "menu-pasta";
    }

    @GetMapping("/salad")
    public String salad() {
        return "menu-salad";
    }

    @GetMapping("/dessert")
    public String desert() {
        return "menu-dessert";
    }

    @GetMapping("/drink")
    public String drink() {
        return "menu-drink";
    }

    @PostMapping("/{type}/{id}")
    public String addProductToCart(@PathVariable String type,@PathVariable Long id) {
        orderService.addToCart(id);
        return "redirect:/menu/" + type;
    }
}
