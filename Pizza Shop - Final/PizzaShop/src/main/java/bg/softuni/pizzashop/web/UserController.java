package bg.softuni.pizzashop.web;

import bg.softuni.pizzashop.model.view.UserViewModel;
import bg.softuni.pizzashop.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
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

    @GetMapping("/roles/{id}")
    public String editUserRoles(@PathVariable(name = "id")Long id, Model model) {
        model.addAttribute("userViewModel", userService.getUserViewModelById(id));
        model.addAttribute("NoRolesLeft", null);
        return "user-role-management";
    }

    @GetMapping("roles/delete/{userId}/{roleId}")
    public String deleteRole(@PathVariable(name = "userId")Long userId, @PathVariable(name = "roleId")Long roleId, RedirectAttributes redirectAttributes){

       try {
           userService.deleteRole(userId, roleId);
       } catch (Exception e) {
           redirectAttributes.addFlashAttribute("NoRolesLeft", e.getMessage());
           return "redirect:/users/roles/" + userId;
       }

        return "redirect:/users/roles/" + userId;
    }
}
