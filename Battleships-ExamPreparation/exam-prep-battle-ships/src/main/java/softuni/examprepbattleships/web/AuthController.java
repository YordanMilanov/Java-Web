package softuni.examprepbattleships.web;

import ch.qos.logback.core.model.Model;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import softuni.examprepbattleships.domain.models.binding.UserRegisterModel;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @GetMapping("/register")
    public String getRegister(Model model) {
        return "register";
    }

    @PostMapping("/register")
    public String postRegister(@Valid @ModelAttribute(name = "userRegisterModel") UserRegisterModel userRegisterModel,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userRegisterModel", userRegisterModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.userRegisterModel", bindingResult);
            return "redirect:register";
        }
        return "redirect:login";
    }

    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }

    //Model attributes
    @ModelAttribute(name = "userRegisterModel")
    public UserRegisterModel userRegisterModel() {
        return new UserRegisterModel();
    }
}
