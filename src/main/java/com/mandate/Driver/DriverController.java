package com.mandate.Driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/kierowcy")
public class DriverController {
    private final DriverService driverService;

    @Autowired
    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    @GetMapping
    public List<Driver> getDrivers() {
        return driverService.getDrivers();
    }

    @PostMapping
    public void addNewDriver(@RequestBody Driver driver){
        driverService.addNewDriver(driver);
    }

    @DeleteMapping(path = {"{DriverId}"})
    public void deleteDriver(@PathVariable("DriverId") Long driverId){
        driverService.deleteDriver(driverId);
    }

}
