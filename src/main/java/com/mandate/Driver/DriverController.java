package com.mandate.Driver;

import com.mandate.Mandate.Mandate;
import com.mandate.Mandate.MandateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/")
public class DriverController {
    private final DriverService driverService;
    private final MandateService mandateService;

    @Autowired
    public DriverController(DriverService driverService, MandateService mandateService) {
        this.driverService = driverService;
        this.mandateService = mandateService;
    }

    @GetMapping
    public String index(Model model){
        System.out.println("Strona");
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
//        System.out.println(driver);
        List<Mandate> mandates = mandateService.getDriverMandates(driver);
        model.addAttribute("pesel", pesel);
        model.addAttribute("driver", driver);
        model.addAttribute("mandates", mandates);
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
