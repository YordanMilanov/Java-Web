package bg.softuni.pizzashop.web;

import bg.softuni.pizzashop.model.binding.UserRegisterBindingModel;
import bg.softuni.pizzashop.model.service.UserServiceModel;
import bg.softuni.pizzashop.repository.UserRepository;
import bg.softuni.pizzashop.service.AuthService;
import bg.softuni.pizzashop.util.CurrentUser;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
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
public class AuthController {

    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;
    private final AuthService authService;

    private final UserRepository userRepository;

    public AuthController(ModelMapper modelMapper, CurrentUser currentUser, AuthService authService, UserRepository userRepository) {
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
        this.authService = authService;
        this.userRepository = userRepository;
    }

    @GetMapping("/register")
    public String register(Model model) {

        if(!model.containsAttribute("usernameIsNotEmpty")) {
            model.addAttribute("usernameIsNotEmpty", false);
        }

        if(!model.containsAttribute("emailIsNotEmpty")) {
            model.addAttribute("emailIsNotEmpty", false);
        }
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

        if(userRepository.findByEmail(userRegisterBindingModel.getEmail()).isPresent()) {
            redirectAttributes.addFlashAttribute("userRegisterBindingModel", userRegisterBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegisterBindingModel", bindingResult);
            redirectAttributes.addFlashAttribute("emailIsNotEmpty", true);
            return "redirect:/users/register";
        }

        if(userRepository.findByUsername(userRegisterBindingModel.getUsername()).isPresent()) {
            redirectAttributes.addFlashAttribute("userRegisterBindingModel", userRegisterBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegisterBindingModel", bindingResult);
            redirectAttributes.addFlashAttribute("usernameIsNotEmpty", true);
            return "redirect:/users/register";
        }

        //save in db
        authService.registerUser(modelMapper
                .map(userRegisterBindingModel, UserServiceModel.class));

        //after registration is completed redirect to log in
        return "redirect:/users/login";
    }

    @PostMapping("/logout")
    public String logout() {
        currentUser.setId(null);
        return "redirect:/";
    }

    @ModelAttribute
    public UserRegisterBindingModel userRegisterBindingModel() {
        return new UserRegisterBindingModel();
    }
}
