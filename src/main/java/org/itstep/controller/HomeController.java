package org.itstep.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping
    public String home() {
        return "index";
    }

    @GetMapping("/login?logout")
    public String logout(){
        return "index";
    }
}
