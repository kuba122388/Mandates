package com.mandate.Driver;

import com.mandate.Policeman.Policeman;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/kierowcy")
public class DriverController {
    private final DriverService driverService;

    @Autowired
    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    @GetMapping("/list")
    public List<Driver> getDrivers() {
        return driverService.getDrivers();
    }

    @GetMapping
    public String getSite(){
        return "Index";
    }

    @GetMapping("/{pesel}")
    public Driver getDriverByPesel(@PathVariable String pesel){
        return driverService.getDriverByPesel(pesel);
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
