package bg.softuni.pizzashop.web;

import bg.softuni.pizzashop.security.CurrentUser;
import bg.softuni.pizzashop.service.RoleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    private final CurrentUser currentUser;

    private final RoleService roleService;

    public HomeController(CurrentUser currentUser, RoleService roleService) {
        this.currentUser = currentUser;
        this.roleService = roleService;
    }

    @GetMapping("/")
    public String index(Model model) {

        if (currentUser.getId() == null) {
            return "index";
        }

        if(roleService.isCustomer(currentUser.getRoles())) {
            if (roleService.isEmployee(currentUser.getRoles())) {
                if(roleService.isManager(currentUser.getRoles())) {
                    return "home-manager";
                }
                return "home-staff";
            }
            return "home-user";
        }

        return "index";
    }


    @GetMapping("/menu")
    public String menu() {
        return "menu-pizza";
    }

    @GetMapping("/order")
    public String order() {
        return "order-user-basket";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/profile")
    public String profile() {
        return "profile";
    }
}
