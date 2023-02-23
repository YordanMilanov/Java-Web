package com.example.pathfinderdemo.web;

import com.example.pathfinderdemo.model.binding.UserLoginBindingModel;
import com.example.pathfinderdemo.model.binding.UserRegisterBindingModel;
import com.example.pathfinderdemo.model.service.UserServiceModel;
import com.example.pathfinderdemo.model.view.UserViewModel;
import com.example.pathfinderdemo.service.UserService;
import com.example.pathfinderdemo.util.CurrentUser;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    public UserController(UserService userService, ModelMapper modelMapper, CurrentUser currentUser) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @ModelAttribute
    public UserRegisterBindingModel userRegisterBindingModel() {
        return new UserRegisterBindingModel();
    }

    @ModelAttribute
    public UserLoginBindingModel userLoginBindingModel() {
        return new UserLoginBindingModel();
    }

    @GetMapping("/register")
    public String register(Model model) {

        return "register"; // връщаме името на файла в
        // темплейт папката, който искаме да върнем без
        // постфикса(без .html)
    }

    @PostMapping("/register")
    //@Valid is responsible for the validation of the annotations that we put in the class(in this case userRegisterBindingModel)
    public String registerConfirm(@Valid UserRegisterBindingModel userRegisterBindingModel,
                                  BindingResult bindingResult,// the results from the validations
                                  RedirectAttributes redirectAttributes) { //redirectAttributes serves to keep the info from the registration when we redirect again to register
        //returns boolean if there is errors
        if (bindingResult.hasErrors() || !userRegisterBindingModel.getPassword().equals(userRegisterBindingModel.getConfirmPassword())) { //addFlashAttribute - It adds to the attributes  (key - value pair) userRegisterBindingModel - userRegisterBindingModel
            redirectAttributes.addFlashAttribute("userRegisterBindingModel", userRegisterBindingModel); // we add the object to the attributes
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegisterBindingResult", bindingResult); //we add the results from the validation to the attributes
            return "redirect:register";
        }

        userService.registerUser(modelMapper.map(userRegisterBindingModel, UserServiceModel.class));

        return "redirect:login";
    }

    @GetMapping("/login")
    public String login(Model model) {

        model.addAttribute("isExists", true);
        return "login";
    }

    @PostMapping("/login")
    public String loginConfirm(@Valid UserLoginBindingModel userLoginBindingModel,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes
                    .addFlashAttribute("userLoginBindingModel", userLoginBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.userLoginBindingResult", bindingResult);
            return "redirect:login";
        }

        UserServiceModel user = userService.findUserByUsernameAndPassword(userLoginBindingModel.getUsername(), userLoginBindingModel.getPassword());

        if (user == null) {
            if (bindingResult.hasErrors()) {
                redirectAttributes.addFlashAttribute("userLoginBindingModel", userLoginBindingModel)
                        .addFlashAttribute("org.springframework.validation.BindingResult.userLoginBindingResult", bindingResult)
                        .addFlashAttribute("isExists", false);

                return "redirect:login";
            }

            //loginUser()

            return "redirect:login";
        }

        userService.loginUser(user.getId(), user.getUsername());



        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout() {
        userService.logout();
        return "redirect:/";
    }

    @GetMapping("/profile/{id}")
    private String profile(@PathVariable Long id, Model model) {
        model
                .addAttribute("user", modelMapper
                        .map(userService.findById(id), UserViewModel.class));


        return "profile";
    }
}
