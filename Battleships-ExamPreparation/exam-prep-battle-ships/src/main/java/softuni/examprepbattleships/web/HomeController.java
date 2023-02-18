package softuni.examprepbattleships.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import softuni.examprepbattleships.domain.helpers.LoggedUser;
import softuni.examprepbattleships.domain.models.UserWithShipsModel;
import softuni.examprepbattleships.domain.models.binding.BattleShipsModel;
import softuni.examprepbattleships.services.BattleService;
import softuni.examprepbattleships.services.UserService;

@Controller
@RequestMapping("/")
public class HomeController {

    private final LoggedUser loggedUser;
    private final BattleService battleService;

    private final UserService userService;

    @Autowired
    public HomeController(LoggedUser loggedUser, BattleService battleService, UserService userService) {
        this.loggedUser = loggedUser;
        this.battleService = battleService;
        this.userService = userService;
    }

    @GetMapping("/home")
    public ModelAndView getHome(ModelAndView modelAndView) {
        UserWithShipsModel loggedUserWithShips = battleService.getUserWithShips(this.loggedUser.getId());
        UserWithShipsModel notLoggedUserWithShips = battleService.getUserWithShips(this.userService.findByIdNot(this.loggedUser.getId()).getId());

        modelAndView.setViewName("home");
        modelAndView.addObject("loggedUserWithShips", loggedUserWithShips);
        modelAndView.addObject("notLoggedUserWithShips", notLoggedUserWithShips);
        return modelAndView;
    }

    @GetMapping
    public String getIndex() {
        return "index";
    }

    @PostMapping("battle")
    public String getHome(@ModelAttribute(name = "battleShipsModel")BattleShipsModel battleShipsModel) {
        return "redirect:/home";
    }

    @ModelAttribute(name = "battleShipsModel")
    public BattleShipsModel battleShipsModel() {
        return new BattleShipsModel();
    }

}
