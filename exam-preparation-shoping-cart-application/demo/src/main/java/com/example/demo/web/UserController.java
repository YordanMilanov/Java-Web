package com.example.demo.web;

import com.example.demo.model.binding.UserLoginBindingModel;
import com.example.demo.model.binding.UserRegisterBindingModel;
import com.example.demo.model.service.UserServiceModel;
import com.example.demo.security.CurrentUser;
import com.example.demo.service.UserService;
import jakarta.servlet.http.HttpSession;
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
    public String register(Model model) {
        if (model.containsAttribute("userRegisterBindingModel"))
            model.addAttribute("userRegisterBindingModel", userRegisterBindingModel());
        return "register";
    }

    @PostMapping("/register")
    public String RegisterConfirm(
            @Valid UserRegisterBindingModel userRegisterBindingModel,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors() ||
                !userRegisterBindingModel.getPassword()
                        .equals(userRegisterBindingModel.getConfirmPassword())) {

            redirectAttributes.addFlashAttribute("userRegisterBindingModel", userRegisterBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegisterBindingModel", bindingResult);

            return "redirect:/users/register";
        }

        userService.registerUser(modelMapper.map(userRegisterBindingModel, UserServiceModel.class));

        return "redirect:/users/login";
    }

    @GetMapping("/login")
    public String login(Model model) {
        if (!model.containsAttribute("userLoginBindingModel")) {
            model.addAttribute("userLoginBindingModel", userLoginBindingModel());
            model.addAttribute("notFound", false);
        }
        return "login";
    }

    @PostMapping("/login")
    public String loginConfirm(
            @Valid UserLoginBindingModel userLoginBindingModel,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userLoginBindingModel", userLoginBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userLoginBindingModel", bindingResult);

            return "redirect:login";
        }
        UserServiceModel userServiceModel =
                userService
                        .findByUsernameAndPassword(
                                userLoginBindingModel.getUsername(),
                                userLoginBindingModel.getPassword());

        if (userServiceModel == null) {
            redirectAttributes.addFlashAttribute("userLoginBindingModel");
            redirectAttributes.addFlashAttribute("notFound", true);

            return "redirect:login";
        }

        userService.loginUser(userServiceModel.getId(), userLoginBindingModel.getUsername());

        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(CurrentUser currentUser) {
        currentUser.setId(null);
        currentUser.setUsername(null);

        return "redirect:/";
    }

    public UserRegisterBindingModel userRegisterBindingModel() {
        return new UserRegisterBindingModel();
    }

    public UserLoginBindingModel userLoginBindingModel() {
        return new UserLoginBindingModel();
    }
}
