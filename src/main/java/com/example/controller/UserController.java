package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.entity.UserEntity;
import com.example.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("user", new UserEntity());
        return "form";
    }

    @PostMapping("/confirm")
    public String submitForm(@ModelAttribute UserEntity user, Model model) {
        model.addAttribute("user", user);
        return "confirm";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute UserEntity user, Model model) {
        userService.save(user);
        model.addAttribute("users", userService.getAllUsers());
        return "list";
    }

    @GetMapping("/list")
    public String listUsers(Model model) {
    	model.addAttribute("users", userService.getAllUsers());
        return "list";
    }
}
