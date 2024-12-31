package com.mandate.Policeman;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "api/policjanci")
public class PolicemanController {
    private final PolicemanService policemanService;

    @Autowired
    public PolicemanController(PolicemanService policemanService) {
        this.policemanService = policemanService;
    }

    @GetMapping
    public List<Policeman> getPolicemen() {
        return policemanService.getPolicemen();
    }

    @GetMapping("/{badge}")
    public Policeman getPolicemanByBadge(@RequestParam Long badgeNumber){
        return policemanService.getPolicemanByBadge(badgeNumber);
    }

    @PostMapping
    public void addNewPoliceman(@RequestBody Policeman policeman){
        policemanService.addNewPoliceman(policeman);
    }

    @DeleteMapping(path = {"/{PolicemanId}"})
    public void deletePoliceman(@PathVariable("PolicemanId") Long PolicemanId){
        policemanService.deletePoliceman(PolicemanId);
    }

}
