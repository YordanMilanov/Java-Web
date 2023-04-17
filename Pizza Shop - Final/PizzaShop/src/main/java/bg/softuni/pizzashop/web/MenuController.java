package bg.softuni.pizzashop.web;

import bg.softuni.pizzashop.model.entity.enums.ProductTypeEnum;
import bg.softuni.pizzashop.service.OrderService;
import bg.softuni.pizzashop.service.ProductService;
import bg.softuni.pizzashop.service.ShoppingCartService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/menu")
public class MenuController {

    private final ProductService productService;
    private final OrderService orderService;

    private final ShoppingCartService shoppingCartService;

    public MenuController(ProductService productService, OrderService orderService, ShoppingCartService shoppingCartService) {
        this.productService = productService;
        this.orderService = orderService;
        this.shoppingCartService = shoppingCartService;
    }

    @GetMapping("/all/{productName}")
    public String pizza(@RequestParam(name = "productName")String productName, Model model) {
        model.addAttribute("allPizza", productService.allProductsByType(ProductTypeEnum.valueOf(productName.toUpperCase())));
        return "menu-pizza";
    }

    @GetMapping("/pasta")
    public String pasta(Model model) {
        model.addAttribute("allPasta", productService.allProductsByType(ProductTypeEnum.PASTA));
        return "menu-pasta";
    }

    @GetMapping("/salad")
    public String salad(Model model) {
        model.addAttribute("allSalad", productService.allProductsByType(ProductTypeEnum.SALAD));
        return "menu-salad";
    }

    @GetMapping("/dessert")
    public String desert(Model model) {
        model.addAttribute("allDessert", productService.allProductsByType(ProductTypeEnum.DESSERT));
        return "menu-dessert";
    }

    @GetMapping("/drink")
    public String drink(Model model) {
        model.addAttribute("allDrink", productService.allProductsByType(ProductTypeEnum.DRINK));
        return "menu-drink";
    }

    @GetMapping("/{type}/{id}")
    public String addProductToCart(@PathVariable String type,@PathVariable Long id) {

        shoppingCartService.addProduct(id);
        return "redirect:/menu/" + type;
    }
}
