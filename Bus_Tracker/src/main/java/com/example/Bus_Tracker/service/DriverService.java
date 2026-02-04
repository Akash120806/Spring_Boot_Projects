package com.example.Bus_Tracker.service;

import com.example.Bus_Tracker.model.Driver;
import com.example.Bus_Tracker.repo.DriverRepo;
import org.springframework.stereotype.Service;

@Service
public class DriverService {

    private final DriverRepo repo;

    public DriverService(DriverRepo repo) {
        this.repo = repo;
    }

    public Driver registerDriver(Driver d) {
        return repo.save(d);
    }

    public Driver checkLogin(String username, String password) {
        Driver d = repo.findByUsername(username);
        if (d != null && d.getPassword().equals(password)) {
            return d;
        }
        return null;
    }
}
