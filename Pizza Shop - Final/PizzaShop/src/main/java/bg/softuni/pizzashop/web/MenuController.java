package bg.softuni.pizzashop.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/menu")
public class MenuController {

    @GetMapping("/pizza")
    public String pizza() {
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
