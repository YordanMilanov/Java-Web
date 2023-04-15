package bg.softuni.pizzashop.web;

import bg.softuni.pizzashop.model.binding.UserAddRoleBindingModel;
import bg.softuni.pizzashop.model.binding.UserNameUpdateBindingModel;
import bg.softuni.pizzashop.model.binding.UserRegisterBindingModel;
import bg.softuni.pizzashop.model.view.UserViewModel;
import bg.softuni.pizzashop.service.UserService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
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
        model.addAttribute("allUsers", allUsers);
        return "list-user";
    }

    @DeleteMapping("/delete/{id}")
    public String userDelete(@PathVariable(name = "id") Long id) {
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
        model.addAttribute("userNameUpdateBindingModel", new UserNameUpdateBindingModel());
        return "profile";
    }

    // --Username Update--

    @PostMapping("/profile")
    public String profileConfirm(
            @Valid UserNameUpdateBindingModel userNameUpdateBindingModel,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes) {


        //check if the userViewModel has any errors
        if (bindingResult.hasErrors()) {
            redirectAttributes
                    .addFlashAttribute("userNameUpdateBindingModel", userNameUpdateBindingModel)
                    .addFlashAttribute("incorrectName", true);
            return "redirect:/users/profile";
        }

        if (userService.isUsernameUsed(userNameUpdateBindingModel.getUsername())) {
            redirectAttributes.addFlashAttribute("userNameUpdateBindingModel", userNameUpdateBindingModel);
            redirectAttributes.addFlashAttribute("usedName", true);
            return "redirect:/users/profile";
        }

        //update user to database
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String oldName = auth.getName();

        userService.updateUsername(oldName, userNameUpdateBindingModel.getUsername());

        //update the principal username
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userNameUpdateBindingModel.getUsername(), auth.getCredentials(), auth.getAuthorities());
        authentication.setDetails(auth.getDetails());

        SecurityContextHolder.getContext().setAuthentication(authentication);

        //after profile update is completed redirect to home page
        return "redirect:/users/profile";
    }

    // --role management--

    @GetMapping("/roles/{id}")
    public String editUserRoles(@PathVariable(name = "id") Long id, Model model) {
        model.addAttribute("userViewModel", userService.getUserViewModelById(id));
        model.addAttribute("userAddRoleBindingModel", new UserAddRoleBindingModel());
        return "user-role-management";
    }

    @DeleteMapping("roles/delete/{userId}/{roleId}")
    public String deleteRole(@PathVariable(name = "userId") Long userId, @PathVariable(name = "roleId") Long roleId, RedirectAttributes redirectAttributes) {
        try {
            userService.deleteRole(userId, roleId);
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("NoRolesLeft", e.getMessage());
            return "redirect:/users/roles/" + userId;
        }
        return "redirect:/users/roles/" + userId;
    }

    @PostMapping("/roles/add/{userId}")
    public String addRoleToUser(@PathVariable Long userId,
                                UserAddRoleBindingModel userAddRoleBindingModel,
                                RedirectAttributes redirectAttributes) {
        try {
            userService.addRoleToUser(userId, userAddRoleBindingModel.getRoleName());
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorSelectMessage", e.getMessage());
        }
        return "redirect:/users/roles/" + userId;
    }
}
