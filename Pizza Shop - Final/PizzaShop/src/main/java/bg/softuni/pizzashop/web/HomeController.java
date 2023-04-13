package bg.softuni.pizzashop.web;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

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
}
