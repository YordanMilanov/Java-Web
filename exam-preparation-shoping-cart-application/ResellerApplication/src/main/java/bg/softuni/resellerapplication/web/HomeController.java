package bg.softuni.resellerapplication.web;

import bg.softuni.resellerapplication.service.OfferService;
import bg.softuni.resellerapplication.util.CurrentUser;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
    private final CurrentUser currentUser;

    private final OfferService offerService;

    public HomeController(CurrentUser currentUser, OfferService offerService) {
        this.currentUser = currentUser;
        this.offerService = offerService;
    }

    @GetMapping("/")
    public String index(Model model) {
        if (currentUser.getId() == null) {
            return "index";
        }

        model.addAttribute("offers", offerService.findAllByUserOwner(currentUser.getId()));
        //have no time
        return "";
    }



}
