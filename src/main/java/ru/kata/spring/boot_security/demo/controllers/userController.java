package ru.kata.spring.boot_security.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import ru.kata.spring.boot_security.demo.services.UserService;

import java.security.Principal;

@Controller
public class userController {
    final
    UserService userService;
    @Autowired
    public userController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public String index(Principal principal, ModelMap model){
        model.addAttribute("user", userService.findUserByName(principal.getName()));

        return "profile";
    }
}
