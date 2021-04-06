package org.itstep.controller;

import org.itstep.domain.User;
import org.itstep.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(UserController.BASE_URL)
public class UserController {
    public static final String BASE_URL = "/register";
    public static final String REDIRECT_INDEX = "redirect:" + BASE_URL;
    public static final String VIEW_PATH = "user";
    public static final String FORM_PATH = VIEW_PATH + "/form";
//    public static final String INDEX_PATH = VIEW_PATH + "/index";

    final UserServiceImpl service;

    @Autowired
    public UserController(UserServiceImpl service) {
        this.service = service;
    }


    @GetMapping
    public String index(Model model) {
        User user = new User();
        model.addAttribute(user);
        return FORM_PATH;
    }

    @PostMapping
    public String create(@ModelAttribute User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return FORM_PATH;
        }
        service.save(user);
        return "index";
    }

}
