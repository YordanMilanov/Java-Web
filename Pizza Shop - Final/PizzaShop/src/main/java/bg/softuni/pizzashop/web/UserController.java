package bg.softuni.pizzashop.web;

import bg.softuni.pizzashop.model.binding.UserLoginBindingModel;
import bg.softuni.pizzashop.model.binding.UserRegisterBindingModel;
import bg.softuni.pizzashop.model.service.UserServiceModel;
import bg.softuni.pizzashop.model.view.UserViewModel;
import bg.softuni.pizzashop.util.CurrentUser;
import bg.softuni.pizzashop.service.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    private final CurrentUser currentUser;

    public UserController(UserService userService, ModelMapper modelMapper, CurrentUser currentUser) {
        this.userService = userService;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
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

    @PostMapping("/login")
    public String loginConfirm(@Valid UserLoginBindingModel userLoginBindingModel,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes) {

        //has any errors with the input fields
        if(bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userLoginBindingModel", userLoginBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userLoginBindingModel", bindingResult);

            //with redirect without "/" -> redirect:login it refers to method with name "login" in the controller not to the href /login
            return "redirect:login";
        }

        UserServiceModel userServiceModel = userService
                .findByUsernameAndPassword(userLoginBindingModel.getUsername(), userLoginBindingModel.getPassword());

        //user not found
        if (userServiceModel == null) {
            redirectAttributes.addFlashAttribute("userLoginBindingModel", userLoginBindingModel);
            redirectAttributes.addFlashAttribute("isFound", false);

            return "redirect:login";
        }


        //login successful -> login user
        userService.loginUser(userServiceModel.getId(), userServiceModel.getUsername(), userServiceModel.getRoles(), userServiceModel.getLevel());


        return "redirect:/";
    }

    @GetMapping("/list")
    public String userList(Model model) {
        List<UserViewModel> allUsers = userService.getAll();
        model.addAttribute("allUsers",allUsers);
        return "list-user";
    }

    @GetMapping("/logout")
    public String logout(HttpSession httpSession) {
        httpSession.invalidate();
        currentUser.setId(null);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String userDelete(@PathVariable(name = "id")Long id) {
        userService.deleteUser(id);
        return "redirect:/users/list";
    }



    @ModelAttribute
    public UserRegisterBindingModel userRegisterBindingModel() {
        return new UserRegisterBindingModel();
    }

    @ModelAttribute
    public UserLoginBindingModel userLoginBindingModel() {
        return new UserLoginBindingModel();
    }
}
