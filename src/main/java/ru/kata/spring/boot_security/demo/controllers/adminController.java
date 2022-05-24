package ru.kata.spring.boot_security.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.kata.spring.boot_security.demo.models.Role;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.services.RoleService;
import ru.kata.spring.boot_security.demo.services.UserService;

import java.security.Principal;
import java.util.List;

@Controller
public class adminController {
    private final UserService userService;
    private final RoleService roleService;
    @Autowired
    public adminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/admin")
    public String index(ModelMap model, Principal principal){
        List<User> users = userService.users();
        User currentUser = userService.findUserByName(principal.getName());
        User newUser = new User();
        List<Role> roles = roleService.roles();

        model.addAttribute("roles", roles);
        model.addAttribute("currentUser", currentUser);
        model.addAttribute("newUser", newUser);
        model.addAttribute("users", users);
        return "admin/index";
    }
    @GetMapping("/admin/create")
    public String create(ModelMap model){
        User user = new User();
        user.setRoles(roleService.roles());
        model.addAttribute("model", user);
        return "admin/create";
    }
    @PostMapping("/admin/create")
    public String create(User user){
        userService.create(user);
        return "redirect:/admin";
    }
    @GetMapping("/admin/edit")
    public String edit(int id, ModelMap model) {
        model.addAttribute("roles", roleService.roles());
        model.addAttribute("model", userService.findUserById(id));

        return "admin/edit";
    }
    @PostMapping("/admin/edit")
    public String edit(int id, User user) {
        userService.edit(id, user);
        return "redirect:/admin";
    }
    @PostMapping("/admin/delete")
    public String delete(int id) {
        userService.delete(id);
        return "redirect:/admin";
    }
}
