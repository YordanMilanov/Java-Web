package com.example.pathfinderdemo.web;

//managing index page

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/") //скобите на GetMapping определяме на кой адрес слушаме
    //името на метода няма значение не то определя какво връщаме
    public String index() {

        //ретърна определя какво ще върни
        return "index";
    }
}
