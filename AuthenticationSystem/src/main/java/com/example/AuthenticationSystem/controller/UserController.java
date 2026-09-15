package com.example.AuthenticationSystem.controller;

import com.example.AuthenticationSystem.Model.User;
import com.example.AuthenticationSystem.Service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
            return "Login successful! You can now visit /user/profile" ;
        }

        return "Invalid username or password. Please go back and try again.";
    }


    @PostMapping("/register")
    @ResponseBody
    public String register(@RequestBody User user) {
        User savedUser = service.register(user);

        return "Registered successfully. Your ID is: " + savedUser.getId();
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
    @GetMapping("/all")
    @ResponseBody
    public List<User> all(){
        return service.findall();
    }
    @PostMapping("/findbyid/{id}")
    @ResponseBody
    public User findid( @PathVariable int id){
        return service.findid(id);
    }
    @PostMapping("/delete")
    @ResponseBody
    public String delete(@RequestBody User user){
          service.deleteprofile(
                user.getId(),
                user.getUsername(),
                user.getPassword()
        );
          return  "deleted";
    }
}