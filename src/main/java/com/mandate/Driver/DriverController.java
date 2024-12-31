package com.mandate.Driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/")
public class DriverController {
    private final DriverService driverService;

    @Autowired
    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    @GetMapping
    public String index(Model model){
        System.out.println("Strona");
        // model.addAttribute("lol", "XD");
        return "index";
    }

    @GetMapping("/list")
    public List<Driver> getDrivers() {
        return driverService.getDrivers();
    }

    @GetMapping("/driver")
    public String getDriverByPesel(@RequestParam(value = "pesel", required = false) String pesel, Model model) {
        System.out.println("Pobrano Drivera: " + pesel);
        Driver driver = driverService.getDriverByPesel(pesel);
        System.out.println(driver);
        model.addAttribute("driver", driver);
        return "index";
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
