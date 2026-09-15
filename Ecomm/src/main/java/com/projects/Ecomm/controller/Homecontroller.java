package com.projects.Ecomm.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping("/homepage")
@RestController
public class Homecontroller {
    @GetMapping("/home")
    public String greet() {
        return "hello";
    }
}
