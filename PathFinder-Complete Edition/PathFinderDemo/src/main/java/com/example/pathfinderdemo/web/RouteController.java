package com.example.pathfinderdemo.web;

import com.example.pathfinderdemo.model.binding.RouteAddBindingModel;
import com.example.pathfinderdemo.model.view.RouteViewModel;
import com.example.pathfinderdemo.service.RouteService;
import com.example.pathfinderdemo.util.CurrentUser;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/routes")
public class RouteController {

    private final RouteService routeService;
    private final CurrentUser currentUser;

    public RouteController(RouteService routeService, CurrentUser currentUser) {
        this.routeService = routeService;
        this.currentUser = currentUser;
    }

    @GetMapping("/all")
    public String allRoutes(Model model) {

        List<RouteViewModel> routeViewModelList = routeService
                .findAllRoutesView();

        model.addAttribute("routes", routeViewModelList);
        return "routes";
    }

    @GetMapping("/add")
    public String add() {
        if(currentUser.getId() == null) {
            return "redirect:/users/login";
        }

        return "add-route";
    }

    @PostMapping("/add")
    public String addConfirm(@Valid RouteAddBindingModel routeAddBindingModel,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {

        if(bindingResult.hasErrors()) {

        }

        return "redirect:all";
    }

    @ModelAttribute
    public RouteAddBindingModel routeAddBindingModel() {
        return new RouteAddBindingModel();
    }
}
