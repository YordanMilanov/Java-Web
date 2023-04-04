package bg.softuni.pizzashop.web;

import bg.softuni.pizzashop.model.entity.enums.ProductTypeEnum;
import bg.softuni.pizzashop.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/menu")
public class MenuController {

    private final ProductService productService;

    public MenuController(ProductService productService) {
        this.productService = productService;
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
}
