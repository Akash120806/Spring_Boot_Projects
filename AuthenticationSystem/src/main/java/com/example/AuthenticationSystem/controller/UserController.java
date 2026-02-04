package com.example.AuthenticationSystem.controller;

import com.example.AuthenticationSystem.Model.User;
import com.example.AuthenticationSystem.Service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String showRegisterPage() {
        return "register";
    }

    @PostMapping("/login")
    @ResponseBody
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        HttpSession session) {

        User user = service.login(username, password);

        if (user != null) {
            session.setAttribute("loggedUser", user);
            return "Login successful! You can now visit /user/profile";
        }

        return "Invalid username or password. Please go back and try again.";
    }


    @PostMapping("/register")
    @ResponseBody
    public String register(@ModelAttribute User user) {
        service.register(user);
        return "User registered successfully! You can now go to /user/login";
    }

    @GetMapping("/profile")
    @ResponseBody
    public Object profile(HttpSession session) {
        User user = (User) session.getAttribute("loggedUser");

        if (user == null) {
            return "Please login first at /user/login";
        }

        return user; }

    @GetMapping("/logout")
    @ResponseBody
    public String logout(HttpSession session) {
        session.invalidate();
        return "Logged out successfully.";
    }
}