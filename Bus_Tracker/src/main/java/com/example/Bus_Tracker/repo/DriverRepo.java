package com.example.Bus_Tracker.repo;

import com.example.Bus_Tracker.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepo extends JpaRepository<Driver, Long> {

    Driver findByUsername(String username);
}
