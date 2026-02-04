package com.example.WebApp.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @RequestMapping("/page")
    public String Opening() {
        return "Welcome to this page";
    }


}
