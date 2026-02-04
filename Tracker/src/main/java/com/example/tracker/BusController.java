package com.example.tracker;



import com.example.tracker.model.BusLocation;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin(origins = "*") // allow frontend calls
public class BusController {

    private final Map<String, BusLocation> buses = new HashMap<>();

    // Driver updates location
    @PostMapping("/updateLocation")-
    public void updateLocation(@RequestBody BusLocation loc) {
        buses.put(loc.getBusNo(), loc);
    }

    // Student fetch all buses
    @GetMapping("/getLocations")
    public Collection<BusLocation> getLocations() {
        return buses.values();
    }
}

