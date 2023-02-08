package com.softuni.mobilele.web;

import com.softuni.mobilele.domain.dtos.banding.UserRegisterFormDto;
import com.softuni.mobilele.domain.dtos.view.UserRoleViewDto;
import com.softuni.mobilele.services.role.UserRoleService;
import com.softuni.mobilele.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController extends BaseController {

    private final UserRoleService roleService;
    private final UserService userService;

    @Autowired
    public UserController(UserRoleService userRoleService, UserService userService) {
        this.roleService = userRoleService;
        this.userService = userService;
    }

    @GetMapping("/register")
    public ModelAndView getRegister(ModelAndView modelAndView) {
        List<UserRoleViewDto> roleServiceAll = this.roleService.getAll();

        modelAndView.addObject("roles", roleServiceAll);

        return super.view("auth-register", modelAndView);
    }

    @PostMapping("/register")
    public ModelAndView postRegister( UserRegisterFormDto userRegisterInfo) {
        this.userService.registerUser(userRegisterInfo);

        return super.redirect("auth-login");
    }
}
