package com.softuni.mobilele.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/users")
public class UserController extends BaseController {

    @GetMapping("/register")
    public ModelAndView getRegister() {
        return super.view("auth-register");
    }

    @PostMapping("/register")
    public ModelAndView postRegister() {

        return super.redirect("auth-login");
    }
}
