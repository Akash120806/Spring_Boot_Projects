package com.example.Bus_Tracker.controller;

import com.example.Bus_Tracker.model.Driver;
import com.example.Bus_Tracker.service.DriverService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class DriverController {

    private final DriverService service;

    public DriverController(DriverService service) {
        this.service = service;
    }

    @PostMapping("/registerDriver")
    public Driver register(@RequestBody Driver d) {
        return service.registerDriver(d);
    }

    @PostMapping("/loginDriver")
    public String login(@RequestBody Driver d) {
        Driver driver = service.checkLogin(d.getUsername(), d.getPassword());
        if (driver != null) {
            return "Login Success";
        }
        return "Invalid Credentials";
    }
}
