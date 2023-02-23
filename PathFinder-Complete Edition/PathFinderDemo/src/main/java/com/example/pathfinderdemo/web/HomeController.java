package com.example.pathfinderdemo.web;

//managing index page

import com.example.pathfinderdemo.service.PictureService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final PictureService pictureService;

    public HomeController(PictureService pictureService) {
        this.pictureService = pictureService;
    }

    @GetMapping("/") //скобите на GetMapping определяме на кой адрес слушаме
    //името на метода няма значение не то определя какво връщаме
    public String index(Model model) {
        model.addAttribute("pictures",
                pictureService.findAllUrls());

        //ретърна определя какво ще върни
        return "index";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }
}
