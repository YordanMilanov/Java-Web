package bg.softuni.pizzashop.web;

import bg.softuni.pizzashop.model.entity.enums.RoleNameEnum;
import bg.softuni.pizzashop.model.service.RoleServiceModel;
import bg.softuni.pizzashop.util.CurrentUser;
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

        RoleServiceModel roleServiceModel = roleService.highestRole(currentUser.getRoles());
        if(roleServiceModel.getRole().equals(RoleNameEnum.MANAGER)) {
            return "home-manager";
        } else if(roleServiceModel.getRole().equals(RoleNameEnum.STAFF)) {
            return "home-staff";
        } else {
            return "home-user";
        }
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

    @GetMapping("/product")
    public String product() {
        return "add-ingredient";
    }
}
