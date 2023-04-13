package bg.softuni.pizzashop.web;

import bg.softuni.pizzashop.model.entity.enums.RoleNameEnum;
import bg.softuni.pizzashop.model.service.RoleServiceModel;
import bg.softuni.pizzashop.model.view.UserViewModel;
import bg.softuni.pizzashop.service.UserService;
import bg.softuni.pizzashop.util.CurrentUser;
import bg.softuni.pizzashop.service.RoleService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    private final CurrentUser currentUser;

    private final RoleService roleService;

    private final UserService userService;

    public HomeController(CurrentUser currentUser, RoleService roleService, UserService userService) {
        this.currentUser = currentUser;
        this.roleService = roleService;
        this.userService = userService;
    }

    @GetMapping("/")
    public String index(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_MANAGER"))) {
            return "home-manager";
        } else if (auth.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_STAFF"))) {
            return "home-staff";
        } else if (auth.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_CUSTOMER"))) {
            return "home-user";
        }
        return "index";
    }

    @GetMapping("/menu")
    public String menu() {
        return "menu";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/product")
    public String product() {
        return "add-ingredient";
    }

    @ModelAttribute
    public CurrentUser currentUser() {
        return currentUser;
    }
}
