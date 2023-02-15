package softuni.examprepbattleships.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ships")
public class ShipController {

    @GetMapping("/ship-add")
    public String getAddShip() {
        return "ship-add";
    }

    @PostMapping("/ship-add")
    public String postAddShip() {
        return "redirect:home";
    }

}
