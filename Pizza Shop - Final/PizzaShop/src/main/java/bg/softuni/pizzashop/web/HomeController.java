package bg.softuni.pizzashop.web;

import bg.softuni.pizzashop.model.entity.Comment;
import bg.softuni.pizzashop.service.CommentService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {

    private final CommentService commentService;

    public HomeController(CommentService commentService) {
        this.commentService = commentService;
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

    @GetMapping("/comments")
    public String commentPage(Model model) {
//        List<Comment> comments = commentService.allComments();
//        model.addAttribute("allComments", comments);
        return "comment";
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
