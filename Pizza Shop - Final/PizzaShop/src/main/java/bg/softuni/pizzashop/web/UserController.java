package bg.softuni.pizzashop.web;

import bg.softuni.pizzashop.model.view.UserViewModel;
import bg.softuni.pizzashop.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/list")
    public String userList(Model model) {
        List<UserViewModel> allUsers = userService.getAll();
        model.addAttribute("allUsers",allUsers);
        return "list-user";
    }


    @GetMapping("/delete/{id}")
    public String userDelete(@PathVariable(name = "id")Long id) {
        userService.deleteUser(id);
        return "redirect:/users/list";
    }

    @GetMapping("/profile")
    public String profile(Model model) {
        //Authentication -> returns the authenticated user
        //SecurityContextHolder -> manages the user
        //getContext() -> returns the currently spring security user
        //getAuthentication() -> returns the "fields"
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        UserViewModel userViewModel = this.userService.getUserViewModel(username);
        model.addAttribute("userViewModel", userViewModel);
        return "profile";
    }
}
