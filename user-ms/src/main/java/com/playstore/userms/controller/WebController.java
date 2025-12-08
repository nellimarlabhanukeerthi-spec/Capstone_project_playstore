package com.playstore.userms.controller;

import com.playstore.userms.dto.UserDto;
import com.playstore.userms.entity.User;
import com.playstore.userms.service.UserService;
import com.playstore.userms.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class WebController {

    private final UserService userService;
    private final UserRepository repository;

    public WebController(UserService userService, UserRepository repository) {
        this.userService = userService;
        this.repository = repository;
    }

    @GetMapping("/register")
    public String showRegister(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String doRegister(@ModelAttribute User user, Model model) {
        if (repository.existsByUsername(user.getUsername())) {
            model.addAttribute("error", "Username already exists");
            return "register";
        }
        userService.register(user);
        model.addAttribute("success", "Registration successful. Please login.");
        return "login";
    }

    @GetMapping("/login")
    public String showLogin() {
        return "login";
    }

    @GetMapping("/users")
    public String users(Model model) {
        List<UserDto> all = userService.getAll();
        model.addAttribute("users", all);
        return "user-list";
    }
}
