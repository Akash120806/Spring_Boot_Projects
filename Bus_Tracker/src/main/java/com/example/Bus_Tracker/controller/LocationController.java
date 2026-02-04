package com.example.Bus_Tracker.controller;

import com.example.Bus_Tracker.model.BusLocation;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin("*")
public class LocationController {

    private Map<String, BusLocation> busMap = new HashMap<>();

    @PostMapping("/updateLocation")
    public String update(@RequestBody BusLocation loc) {
        busMap.put(loc.getBusNo(), loc);
        return "Location Updated";
    }

    @GetMapping("/getLocations")
    public Collection<BusLocation> getAll() {
        return busMap.values();
    }
}
