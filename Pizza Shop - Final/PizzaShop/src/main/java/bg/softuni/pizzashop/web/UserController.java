package bg.softuni.pizzashop.web;

import bg.softuni.pizzashop.model.binding.UserRegisterBindingModel;
import bg.softuni.pizzashop.model.service.UserServiceModel;
import bg.softuni.pizzashop.service.UserService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @GetMapping("/login")
    public String login(Model model) {

        if(!model.containsAttribute("isFound")) {
            model.addAttribute("isFound", true);
        }

        return "login";
    }

    @PostMapping("/register")
    public String RegisterConfirm(
            @Valid UserRegisterBindingModel userRegisterBindingModel,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes) {

        //check if the userRegisterBindingModel has any errors
        if (bindingResult.hasErrors() ||
                !userRegisterBindingModel.getPassword().equals(userRegisterBindingModel.getConfirmPassword())) {

            redirectAttributes.addFlashAttribute("userRegisterBindingModel", userRegisterBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegisterBindingModel", bindingResult);

            //redirect again to register
            return "redirect:/users/register";
        }

        //save in db
        userService.registerUser(modelMapper
                .map(userRegisterBindingModel, UserServiceModel.class));

        //after registration is completed redirect to log in
        return "redirect:/users/login";
    }

    @ModelAttribute
    public UserRegisterBindingModel userRegisterBindingModel() {
        return new UserRegisterBindingModel();
    }
}
