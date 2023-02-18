package com.example.demo.web;

import com.example.demo.model.entity.CategoryNameEnum;
import com.example.demo.security.CurrentUser;
import com.example.demo.service.ProductService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final CurrentUser currentUser;
    private final ProductService productService;

    public HomeController(CurrentUser currentUser, ProductService productService) {
        this.currentUser = currentUser;
        this.productService = productService;
    }

    @GetMapping("/")
    public String index(HttpSession httpSession, Model model) {

        if(currentUser.getId() == null) {
            return "index";
        }

        model.addAttribute("totalSum", productService.getTotalSum());
        model.addAttribute("drinks",productService.findAllProductsByCategoryName(CategoryNameEnum.DRINK));

        return "home";
    }
}
